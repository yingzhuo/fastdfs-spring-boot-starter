package com.github.yingzhuo.fastdfs.springboot.domain.conn;

import com.github.yingzhuo.fastdfs.springboot.domain.proto.CmdConstants;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.OtherConstants;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.mapper.BytesUtils;
import com.github.yingzhuo.fastdfs.springboot.exception.FastDfsConnectException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * 默认连接实现
 *
 * @author tobato
 * @author 应卓
 */
@Slf4j
class ConnectionImpl implements Connection {

    private Socket socket;
    private Charset charset;

    public ConnectionImpl(InetSocketAddress address, int soTimeout, int connectTimeout, Charset charset) {
        try {
            this.charset = charset;
            socket = new Socket();
            socket.setSoTimeout(soTimeout);
            socket.connect(address, connectTimeout);
        } catch (IOException e) {
            throw new FastDfsConnectException("can't create connection to" + address, e);
        }
    }

    public synchronized void close() {
        log.debug("disconnect from {}", socket);
        byte[] header = new byte[OtherConstants.FDFS_PROTO_PKG_LEN_SIZE + 2];
        Arrays.fill(header, (byte) 0);

        byte[] hex_len = BytesUtils.long2buff(0);
        System.arraycopy(hex_len, 0, header, 0, hex_len.length);
        header[OtherConstants.PROTO_HEADER_CMD_INDEX] = CmdConstants.FDFS_PROTO_CMD_QUIT;
        header[OtherConstants.PROTO_HEADER_STATUS_INDEX] = (byte) 0;
        try {
            socket.getOutputStream().write(header);
            socket.close();
        } catch (IOException e) {
            log.warn("close connection error", e);
        } finally {
            try {
                socket.close();
            } catch (IOException ignored) {
            }
        }
    }

    @Override
    public boolean isClosed() {
        return socket.isClosed();
    }

    @Override
    public boolean isValid() {
        try {
            byte[] header = new byte[OtherConstants.FDFS_PROTO_PKG_LEN_SIZE + 2];
            Arrays.fill(header, (byte) 0);

            byte[] hex_len = BytesUtils.long2buff(0);
            System.arraycopy(hex_len, 0, header, 0, hex_len.length);
            header[OtherConstants.PROTO_HEADER_CMD_INDEX] = CmdConstants.FDFS_PROTO_CMD_ACTIVE_TEST;
            header[OtherConstants.PROTO_HEADER_STATUS_INDEX] = (byte) 0;
            socket.getOutputStream().write(header);
            if (socket.getInputStream().read(header) != header.length) {
                return false;
            }

            return header[OtherConstants.PROTO_HEADER_STATUS_INDEX] == 0;
        } catch (IOException e) {
            log.error("valid connection error", e);
            return false;
        }
    }

    public OutputStream getOutputStream() throws IOException {
        return socket.getOutputStream();
    }

    public InputStream getInputStream() throws IOException {
        return socket.getInputStream();
    }

    public Charset getCharset() {
        return charset;
    }

}

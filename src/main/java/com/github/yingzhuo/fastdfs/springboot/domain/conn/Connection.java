package com.github.yingzhuo.fastdfs.springboot.domain.conn;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * 表示一个客户端与服务端的连接
 *
 * @author tobato
 * @author 应卓
 */
public interface Connection extends Closeable {

    public void close() throws IOException;

    public boolean isClosed();

    public boolean isValid();

    public OutputStream getOutputStream() throws IOException;

    public InputStream getInputStream() throws IOException;

    public Charset getCharset();

}

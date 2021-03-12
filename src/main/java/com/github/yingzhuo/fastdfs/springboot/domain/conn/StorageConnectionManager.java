package com.github.yingzhuo.fastdfs.springboot.domain.conn;

import com.github.yingzhuo.fastdfs.springboot.domain.proto.Command;

import java.net.InetSocketAddress;

/**
 * 连接池管理
 *
 * @author tobato
 * @author 应卓
 */
public class StorageConnectionManager extends AbstractConnectionManager {

    public StorageConnectionManager(ConnectionPool pool) {
        super(pool);
    }

    public <T> T executeStorageCommand(InetSocketAddress address, Command<T> command) {
        Connection conn = getConnection(address);
        return doExecute(address, conn, command);
    }

}

package com.github.yingzhuo.fastdfs.springboot.domain.conn;

import com.github.yingzhuo.fastdfs.springboot.domain.fdfs.TrackerLocator;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.Command;
import com.github.yingzhuo.fastdfs.springboot.exception.FastDfsConnectException;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * 管理TrackerClient连接池分配
 *
 * @author tobato
 * @author 应卓
 */
public class TrackerConnectionManager extends AbstractConnectionManager {

    private final TrackerLocator locator;

    public TrackerConnectionManager(ConnectionPool pool, List<String> trackerList) {
        super(pool);
        this.locator = new TrackerLocator(trackerList);
    }

    public <T> T executeTrackerCommand(Command<T> command) {
        Connection conn;
        InetSocketAddress address = null;
        try {
            address = locator.getTrackerAddress();
            conn = getConnection(address);
            locator.setActive(address);
        } catch (FastDfsConnectException e) {
            locator.setInActive(address);
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Unable to borrow buffer from pool", e);
        }
        return doExecute(address, conn, command);
    }

}

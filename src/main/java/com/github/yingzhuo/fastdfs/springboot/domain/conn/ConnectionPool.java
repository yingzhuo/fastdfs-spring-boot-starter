package com.github.yingzhuo.fastdfs.springboot.domain.conn;

import com.github.yingzhuo.fastdfs.springboot.properties.PoolProperties;
import org.apache.commons.pool2.impl.GenericKeyedObjectPool;
import org.springframework.beans.factory.DisposableBean;

import java.net.InetSocketAddress;

/**
 * 连接池
 *
 * @author tobato
 * @author 应卓
 */
public class ConnectionPool extends GenericKeyedObjectPool<InetSocketAddress, Connection> implements DisposableBean {

    public ConnectionPool(ConnectionFactory factory, PoolProperties config) {
        super(factory, config);
    }

    @Override
    public void destroy() {
        this.close();
    }

}

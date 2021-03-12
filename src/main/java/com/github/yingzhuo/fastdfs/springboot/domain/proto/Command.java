package com.github.yingzhuo.fastdfs.springboot.domain.proto;

import com.github.yingzhuo.fastdfs.springboot.domain.conn.Connection;

import java.io.Serializable;

/**
 * 命令抽象
 *
 * @author tobato
 */
public interface Command<T> extends Serializable {

    public T execute(Connection conn);

}

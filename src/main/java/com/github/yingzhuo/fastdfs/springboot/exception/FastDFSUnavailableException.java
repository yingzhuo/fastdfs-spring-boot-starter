package com.github.yingzhuo.fastdfs.springboot.exception;

/**
 * 非fastdfs本身的错误码抛出的异常，取服务端连接取不到时抛出的异常
 *
 * @author yuqihuang
 */
public class FastDFSUnavailableException extends FastDFSException {

    public FastDFSUnavailableException(String message) {
        super(message);
    }

    public FastDFSUnavailableException(String message, Throwable t) {
        super(message, t);
    }

}

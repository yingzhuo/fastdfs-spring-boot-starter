package com.github.yingzhuo.fastdfs.springboot.exception;

/**
 * 非fastdfs本身的错误码抛出的异常，socket连不上时抛出的异常
 *
 * @author yuqihuang
 * @author tobato
 */
public class FastDfsConnectException extends FastDFSUnavailableException {

    public FastDfsConnectException(String message, Throwable t) {
        super(message, t);
    }

}

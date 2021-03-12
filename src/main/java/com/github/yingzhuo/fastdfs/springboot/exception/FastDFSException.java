package com.github.yingzhuo.fastdfs.springboot.exception;

/**
 * 封装fastdfs的异常，使用运行时异常
 *
 * @author yuqih
 * @author tobato
 */
public abstract class FastDFSException extends RuntimeException {

    protected FastDFSException(String message) {
        super(message);
    }

    protected FastDFSException(String message, Throwable cause) {
        super(message, cause);
    }

}

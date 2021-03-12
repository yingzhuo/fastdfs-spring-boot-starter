package com.github.yingzhuo.fastdfs.springboot.exception;

/**
 * 非fastdfs本身的错误码抛出的异常，而是java客户端向服务端发送命令、文件或从服务端读取结果、下载文件时发生io异常
 *
 * @author yuqihuang
 * @author tobato
 */
public class FastDFSIOException extends FastDFSException {

    public FastDFSIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public FastDFSIOException(String message) {
        super(message);
    }

}

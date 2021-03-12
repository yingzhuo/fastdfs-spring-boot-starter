package com.github.yingzhuo.fastdfs.springboot.exception;

/**
 * 从Url解析StorePath文件路径对象错误
 *
 * @author wuyf
 */
public class FastDFSUnsupportedStorePathException extends FastDFSException {

    public FastDFSUnsupportedStorePathException() {
        this(null);
    }

    public FastDFSUnsupportedStorePathException(String message) {
        super(message);
    }

}

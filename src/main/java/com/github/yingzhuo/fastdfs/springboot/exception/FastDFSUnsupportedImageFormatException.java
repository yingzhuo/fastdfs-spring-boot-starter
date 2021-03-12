package com.github.yingzhuo.fastdfs.springboot.exception;

/**
 * 不支持的图片格式
 *
 * @author tobato
 */
public class FastDFSUnsupportedImageFormatException extends FastDFSException {

    public FastDFSUnsupportedImageFormatException() {
        this(null);
    }

    public FastDFSUnsupportedImageFormatException(String message) {
        super(message);
    }

}

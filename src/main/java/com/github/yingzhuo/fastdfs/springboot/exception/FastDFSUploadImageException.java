package com.github.yingzhuo.fastdfs.springboot.exception;

/**
 * 上传图片例外
 *
 * @author tobato
 */
public class FastDFSUploadImageException extends FastDFSException {

    protected FastDFSUploadImageException(String message) {
        super(message);
    }

    public FastDFSUploadImageException(String message, Throwable cause) {
        super(message, cause);
    }

}

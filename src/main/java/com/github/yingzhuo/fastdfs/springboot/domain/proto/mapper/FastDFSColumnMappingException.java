package com.github.yingzhuo.fastdfs.springboot.domain.proto.mapper;

/**
 * 映射例外
 *
 * @author tobato
 */
public class FastDFSColumnMappingException extends RuntimeException {

    protected FastDFSColumnMappingException() {
    }

    protected FastDFSColumnMappingException(String message, Throwable cause, boolean enableSuppression,
                                            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    protected FastDFSColumnMappingException(String message, Throwable cause) {
        super(message, cause);
    }

    protected FastDFSColumnMappingException(String message) {
        super(message);
    }

    protected FastDFSColumnMappingException(Throwable cause) {
        super(cause);
    }

}

package com.github.yingzhuo.fastdfs.springboot.domain.proto.storage;

import java.io.IOException;

/**
 * 文件下载回调接口
 *
 * @author tobato
 */
public interface DownloadCallback<T> {

    public T done(RichInputStream ins) throws IOException;

}

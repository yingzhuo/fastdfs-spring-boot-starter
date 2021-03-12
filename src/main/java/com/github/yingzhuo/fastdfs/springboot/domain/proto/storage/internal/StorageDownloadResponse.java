package com.github.yingzhuo.fastdfs.springboot.domain.proto.storage.internal;

import com.github.yingzhuo.fastdfs.springboot.domain.proto.Response;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.storage.DownloadCallback;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.storage.RichInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * 文件下载结果
 *
 * @author tobato
 * @author 应卓
 */
public class StorageDownloadResponse<T> extends Response<T> {

    private DownloadCallback<T> callback;

    public StorageDownloadResponse(DownloadCallback<T> callback) {
        this.callback = callback;
    }

    @Override
    public T decodeContent(InputStream in, Charset charset) throws IOException {
        RichInputStream input = new RichInputStream(in, getContentLength());
        return callback.done(input);
    }

}

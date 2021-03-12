package com.github.yingzhuo.fastdfs.springboot.domain.proto.storage;

import org.apache.commons.io.IOUtils;

import java.io.IOException;

/**
 * @author 应卓
 * @since 1.6.11
 */
public class BytesDownloadCallback implements DownloadCallback<byte[]> {

    private byte[] bytes;

    @Override
    public byte[] done(RichInputStream ins) throws IOException {
        bytes = IOUtils.toByteArray(ins);
        return bytes;
    }

    public byte[] getBytes() {
        return bytes;
    }

}

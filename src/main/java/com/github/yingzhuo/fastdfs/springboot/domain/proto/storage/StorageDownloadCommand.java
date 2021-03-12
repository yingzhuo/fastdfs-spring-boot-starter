package com.github.yingzhuo.fastdfs.springboot.domain.proto.storage;

import com.github.yingzhuo.fastdfs.springboot.domain.proto.AbstractCommand;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.storage.internal.StorageDownloadRequest;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.storage.internal.StorageDownloadResponse;

/**
 * 文件下载命令
 *
 * @author tobato
 */
public class StorageDownloadCommand<T> extends AbstractCommand<T> {

    public StorageDownloadCommand(String groupName, String path, long fileOffset, long downloadBytes,
                                  DownloadCallback<T> callback) {
        this.request = new StorageDownloadRequest(groupName, path, fileOffset, downloadBytes);
        // 输出响应
        this.response = new StorageDownloadResponse<T>(callback);
    }

    public StorageDownloadCommand(String groupName, String path, DownloadCallback<T> callback) {
        this.request = new StorageDownloadRequest(groupName, path, 0, 0);
        // 输出响应
        this.response = new StorageDownloadResponse<T>(callback);
    }

}

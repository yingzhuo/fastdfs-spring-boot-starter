package com.github.yingzhuo.fastdfs.springboot.domain.proto.storage;

import com.github.yingzhuo.fastdfs.springboot.domain.proto.AbstractCommand;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.Response;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.storage.internal.StorageDeleteFileRequest;

/**
 * 文件删除命令
 *
 * @author tobato
 */
public class StorageDeleteFileCommand extends AbstractCommand<Void> {

    public StorageDeleteFileCommand(String groupName, String path) {
        this.request = new StorageDeleteFileRequest(groupName, path);
        // 输出响应
        this.response = new Response<Void>() {
            // default response
        };
    }

}

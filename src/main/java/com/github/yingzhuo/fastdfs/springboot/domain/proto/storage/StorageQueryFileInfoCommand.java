package com.github.yingzhuo.fastdfs.springboot.domain.proto.storage;

import com.github.yingzhuo.fastdfs.springboot.domain.fdfs.FileInfo;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.AbstractCommand;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.Response;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.storage.internal.StorageQueryFileInfoRequest;

/**
 * 文件查询命令
 *
 * @author tobato
 */
public class StorageQueryFileInfoCommand extends AbstractCommand<FileInfo> {

    public StorageQueryFileInfoCommand(String groupName, String path) {
        super();
        this.request = new StorageQueryFileInfoRequest(groupName, path);
        // 输出响应
        this.response = new Response<FileInfo>() {
            // default response
        };
    }

}

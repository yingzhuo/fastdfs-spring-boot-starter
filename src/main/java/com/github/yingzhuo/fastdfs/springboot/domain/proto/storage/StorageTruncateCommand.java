package com.github.yingzhuo.fastdfs.springboot.domain.proto.storage;

import com.github.yingzhuo.fastdfs.springboot.domain.proto.AbstractCommand;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.Response;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.storage.internal.StorageTruncateRequest;

/**
 * 文件Truncate命令
 *
 * @author tobato
 */
public class StorageTruncateCommand extends AbstractCommand<Void> {

    public StorageTruncateCommand(String path, long fileSize) {
        this.request = new StorageTruncateRequest(path, fileSize);
        // 输出响应
        this.response = new Response<Void>() {
            // default response
        };
    }

}

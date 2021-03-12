package com.github.yingzhuo.fastdfs.springboot.domain.proto.storage;

import com.github.yingzhuo.fastdfs.springboot.domain.proto.AbstractCommand;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.Response;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.storage.internal.StorageModifyRequest;

import java.io.InputStream;

/**
 * 文件修改命令
 *
 * @author tobato
 */
public class StorageModifyCommand extends AbstractCommand<Void> {

    public StorageModifyCommand(String path, InputStream inputStream, long fileSize, long fileOffset) {
        super();
        this.request = new StorageModifyRequest(inputStream, fileSize, path, fileOffset);
        // 输出响应
        this.response = new Response<Void>() {
            // default response
        };
    }

}

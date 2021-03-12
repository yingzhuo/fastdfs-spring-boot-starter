package com.github.yingzhuo.fastdfs.springboot.domain.proto.storage;

import com.github.yingzhuo.fastdfs.springboot.domain.fdfs.MetaData;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.AbstractCommand;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.storage.internal.StorageGetMetadataRequest;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.storage.internal.StorageGetMetadataResponse;

import java.util.Set;

/**
 * 设置文件标签
 *
 * @author tobato
 */
public class StorageGetMetadataCommand extends AbstractCommand<Set<MetaData>> {

    public StorageGetMetadataCommand(String groupName, String path) {
        this.request = new StorageGetMetadataRequest(groupName, path);
        // 输出响应
        this.response = new StorageGetMetadataResponse();
    }

}

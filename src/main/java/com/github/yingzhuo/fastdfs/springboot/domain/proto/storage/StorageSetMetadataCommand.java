package com.github.yingzhuo.fastdfs.springboot.domain.proto.storage;

import com.github.yingzhuo.fastdfs.springboot.domain.fdfs.MetaData;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.AbstractCommand;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.Response;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.storage.enums.StorageMetadataSetType;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.storage.internal.StorageSetMetadataRequest;

import java.util.Set;

/**
 * 设置文件标签
 *
 * @author tobato
 */
public class StorageSetMetadataCommand extends AbstractCommand<Void> {

    public StorageSetMetadataCommand(String groupName, String path, Set<MetaData> metaDataSet,
                                     StorageMetadataSetType type) {
        this.request = new StorageSetMetadataRequest(groupName, path, metaDataSet, type);
        this.response = new Response<Void>() {
        };
    }

}

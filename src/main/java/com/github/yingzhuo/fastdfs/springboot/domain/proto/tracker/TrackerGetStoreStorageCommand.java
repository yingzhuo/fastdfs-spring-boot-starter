package com.github.yingzhuo.fastdfs.springboot.domain.proto.tracker;

import com.github.yingzhuo.fastdfs.springboot.domain.fdfs.StorageNode;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.AbstractCommand;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.Response;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.tracker.internal.TrackerGetStoreStorageRequest;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.tracker.internal.TrackerGetStoreStorageWithGroupRequest;

/**
 * 获取存储节点命令
 *
 * @author tobato
 */
public class TrackerGetStoreStorageCommand extends AbstractCommand<StorageNode> {

    public TrackerGetStoreStorageCommand(String groupName) {
        super.request = new TrackerGetStoreStorageWithGroupRequest(groupName);
        super.response = new Response<StorageNode>() {
            // default response
        };
    }

    public TrackerGetStoreStorageCommand() {
        super.request = new TrackerGetStoreStorageRequest();
        super.response = new Response<StorageNode>() {
            // default response
        };
    }

}

package com.github.yingzhuo.fastdfs.springboot.domain.proto.tracker;

import com.github.yingzhuo.fastdfs.springboot.domain.fdfs.StorageState;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.AbstractCommand;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.tracker.internal.TrackerListStorageRequest;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.tracker.internal.TrackerListStorageResponse;

import java.util.List;

/**
 * 列出组命令
 *
 * @author tobato
 */
public class TrackerListStorageCommand extends AbstractCommand<List<StorageState>> {

    public TrackerListStorageCommand(String groupName, String storageIpAddr) {
        super.request = new TrackerListStorageRequest(groupName, storageIpAddr);
        super.response = new TrackerListStorageResponse();
    }

    public TrackerListStorageCommand(String groupName) {
        super.request = new TrackerListStorageRequest(groupName);
        super.response = new TrackerListStorageResponse();
    }

}

package com.github.yingzhuo.fastdfs.springboot.domain.proto.tracker;

import com.github.yingzhuo.fastdfs.springboot.domain.proto.AbstractCommand;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.Response;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.tracker.internal.TrackerDeleteStorageRequest;

/**
 * 移除存储服务器命令
 *
 * @author tobato
 */
public class TrackerDeleteStorageCommand extends AbstractCommand<Void> {

    public TrackerDeleteStorageCommand(String groupName, String storageIpAddr) {
        super.request = new TrackerDeleteStorageRequest(groupName, storageIpAddr);
        super.response = new Response<Void>() {
            // default response
        };
    }

}

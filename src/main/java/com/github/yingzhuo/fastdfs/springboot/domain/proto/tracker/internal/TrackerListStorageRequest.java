package com.github.yingzhuo.fastdfs.springboot.domain.proto.tracker.internal;

import com.github.yingzhuo.fastdfs.springboot.domain.proto.CmdConstants;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.OtherConstants;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.ProtoHead;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.Request;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.mapper.Column;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.mapper.DynamicFieldType;

/**
 * 列出存储状态
 *
 * @author tobato
 */
public class TrackerListStorageRequest extends Request {

    /**
     * 组名
     */
    @Column(index = 0, max = OtherConstants.FDFS_GROUP_NAME_MAX_LEN)
    private String groupName;

    /**
     * 存储服务器ip地址
     */
    @Column(index = 1, max = OtherConstants.FDFS_IP_ADDR_SIZE - 1, dynamicField = DynamicFieldType.NULLABLE)
    private String storageIpAddr;

    public TrackerListStorageRequest() {
        head = new ProtoHead(CmdConstants.TRACKER_PROTO_CMD_SERVER_LIST_STORAGE);
    }

    public TrackerListStorageRequest(String groupName, String storageIpAddr) {
        this.groupName = groupName;
        this.storageIpAddr = storageIpAddr;
    }

    public TrackerListStorageRequest(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getStorageIpAddr() {
        return storageIpAddr;
    }

}

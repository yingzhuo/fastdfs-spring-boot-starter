package com.github.yingzhuo.fastdfs.springboot.domain.proto.tracker.internal;

import com.github.yingzhuo.fastdfs.springboot.domain.proto.CmdConstants;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.OtherConstants;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.ProtoHead;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.Request;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.mapper.Column;

/**
 * 移除存储服务器
 *
 * @author tobato
 */
public class TrackerDeleteStorageRequest extends Request {

    /**
     * 组名
     */
    @Column(index = 0, max = OtherConstants.FDFS_GROUP_NAME_MAX_LEN)
    private String groupName;

    /**
     * 存储ip
     */
    @Column(index = 1, max = OtherConstants.FDFS_IP_ADDR_SIZE - 1)
    private String storageIpAddr;

    public TrackerDeleteStorageRequest(String groupName, String storageIpAddr) {
        super.head = new ProtoHead(CmdConstants.TRACKER_PROTO_CMD_SERVER_DELETE_STORAGE);
        this.groupName = groupName;
        this.storageIpAddr = storageIpAddr;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getStorageIpAddr() {
        return storageIpAddr;
    }

}

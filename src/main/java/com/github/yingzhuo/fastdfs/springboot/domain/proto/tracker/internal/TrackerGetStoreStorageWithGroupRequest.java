package com.github.yingzhuo.fastdfs.springboot.domain.proto.tracker.internal;

import com.github.yingzhuo.fastdfs.springboot.domain.proto.CmdConstants;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.OtherConstants;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.ProtoHead;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.Request;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.mapper.Column;

/**
 * 按分组获取存储节点
 *
 * @author tobato
 */
public class TrackerGetStoreStorageWithGroupRequest extends Request {

    /**
     * 分组定义
     */
    @Column(index = 0, max = OtherConstants.FDFS_GROUP_NAME_MAX_LEN)
    private final String groupName;

    public TrackerGetStoreStorageWithGroupRequest(String groupName) {
        super.head = new ProtoHead(CmdConstants.TRACKER_PROTO_CMD_SERVICE_QUERY_STORE_WITH_GROUP_ONE);
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

}

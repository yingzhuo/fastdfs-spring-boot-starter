package com.github.yingzhuo.fastdfs.springboot.domain.proto.tracker.internal;

import com.github.yingzhuo.fastdfs.springboot.domain.proto.CmdConstants;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.OtherConstants;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.ProtoHead;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.Request;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.mapper.Column;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.mapper.DynamicFieldType;

/**
 * 获取源服务器
 *
 * @author tobato
 */
public class TrackerGetFetchStorageRequest extends Request {

    private static final byte fetchCmd = CmdConstants.TRACKER_PROTO_CMD_SERVICE_QUERY_FETCH_ONE;
    private static final byte updateCmd = CmdConstants.TRACKER_PROTO_CMD_SERVICE_QUERY_UPDATE;

    /**
     * 组名
     */
    @Column(index = 0, max = OtherConstants.FDFS_GROUP_NAME_MAX_LEN)
    private String groupName;

    /**
     * 路径名
     */
    @Column(index = 1, dynamicField = DynamicFieldType.ALL_REST_BYTE)
    private String path;

    public TrackerGetFetchStorageRequest(String groupName, String path, boolean toUpdate) {
        if (toUpdate) {
            super.head = new ProtoHead(updateCmd);
        } else {
            super.head = new ProtoHead(fetchCmd);
        }

        this.groupName = groupName;
        this.path = path;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getPath() {
        return path;
    }

}

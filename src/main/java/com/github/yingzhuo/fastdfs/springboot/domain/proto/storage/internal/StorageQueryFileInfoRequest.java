package com.github.yingzhuo.fastdfs.springboot.domain.proto.storage.internal;

import com.github.yingzhuo.fastdfs.springboot.domain.proto.CmdConstants;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.OtherConstants;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.ProtoHead;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.Request;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.mapper.Column;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.mapper.DynamicFieldType;

/**
 * 查询文件信息命令
 *
 * @author tobato
 */
public class StorageQueryFileInfoRequest extends Request {

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

    public StorageQueryFileInfoRequest(String groupName, String path) {
        super.head = new ProtoHead(CmdConstants.STORAGE_PROTO_CMD_QUERY_FILE_INFO);
        this.groupName = groupName;
        this.path = path;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}

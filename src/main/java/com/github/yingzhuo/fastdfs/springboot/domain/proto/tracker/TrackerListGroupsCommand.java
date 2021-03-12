package com.github.yingzhuo.fastdfs.springboot.domain.proto.tracker;

import com.github.yingzhuo.fastdfs.springboot.domain.fdfs.GroupState;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.AbstractCommand;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.tracker.internal.TrackerListGroupsRequest;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.tracker.internal.TrackerListGroupsResponse;

import java.util.List;

/**
 * 列出组命令
 *
 * @author tobato
 */
public class TrackerListGroupsCommand extends AbstractCommand<List<GroupState>> {

    public TrackerListGroupsCommand() {
        super.request = new TrackerListGroupsRequest();
        super.response = new TrackerListGroupsResponse();
    }

}

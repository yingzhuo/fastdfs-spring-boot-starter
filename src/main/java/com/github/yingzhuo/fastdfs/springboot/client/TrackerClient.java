package com.github.yingzhuo.fastdfs.springboot.client;

import com.github.yingzhuo.fastdfs.springboot.domain.fdfs.GroupState;
import com.github.yingzhuo.fastdfs.springboot.domain.fdfs.StorageNode;
import com.github.yingzhuo.fastdfs.springboot.domain.fdfs.StorageNodeInfo;
import com.github.yingzhuo.fastdfs.springboot.domain.fdfs.StorageState;

import java.util.List;

/**
 * 目录服务客户端接口
 *
 * @author tobato
 */
public interface TrackerClient {

    public StorageNode getStoreStorage();

    public StorageNode getStoreStorage(String groupName);

    public StorageNodeInfo getFetchStorage(String groupName, String filename);

    public StorageNodeInfo getUpdateStorage(String groupName, String filename);

    public List<GroupState> listGroups();

    public List<StorageState> listStorage(String groupName);

    public List<StorageState> listStorage(String groupName, String storageIpAddr);

    public void deleteStorage(String groupName, String storageIpAddr);

}

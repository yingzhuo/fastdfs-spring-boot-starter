package com.github.yingzhuo.fastdfs.springboot.client;

import com.github.yingzhuo.fastdfs.springboot.domain.fdfs.GroupState;
import com.github.yingzhuo.fastdfs.springboot.domain.fdfs.StorageNode;
import com.github.yingzhuo.fastdfs.springboot.domain.fdfs.StorageNodeInfo;
import com.github.yingzhuo.fastdfs.springboot.domain.fdfs.StorageState;

import java.util.List;

/**
 * @author 应卓
 */
public class TrackerClientImplSafe implements TrackerClient {

    private final TrackerClient delegate;

    public TrackerClientImplSafe(TrackerClient delegate) {
        this.delegate = delegate;
    }

    @Override
    public StorageNode getStoreStorage() {
        return delegate.getStoreStorage();
    }

    @Override
    public StorageNode getStoreStorage(String groupName) {
        return delegate.getStoreStorage(groupName);
    }

    @Override
    public StorageNodeInfo getFetchStorage(String groupName, String filename) {
        return delegate.getFetchStorage(groupName, filename);
    }

    @Override
    public StorageNodeInfo getUpdateStorage(String groupName, String filename) {
        return delegate.getUpdateStorage(groupName, filename);
    }

    @Override
    public List<GroupState> listGroups() {
        return delegate.listGroups();
    }

    @Override
    public List<StorageState> listStorage(String groupName) {
        return delegate.listStorage(groupName);
    }

    @Override
    public List<StorageState> listStorage(String groupName, String storageIpAddr) {
        return delegate.listStorage(groupName, storageIpAddr);
    }

    @Override
    public void deleteStorage(String groupName, String storageIpAddr) {
        throw new UnsupportedOperationException();
    }

}

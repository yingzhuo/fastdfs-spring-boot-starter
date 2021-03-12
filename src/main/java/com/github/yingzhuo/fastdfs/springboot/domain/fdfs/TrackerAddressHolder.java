package com.github.yingzhuo.fastdfs.springboot.domain.fdfs;

import java.net.InetSocketAddress;

/**
 * 管理TrackerAddress当前状态
 *
 * @author tobato
 */
public class TrackerAddressHolder {

    private InetSocketAddress address;

    private boolean available;

    private long lastUnavailableTime;

    public TrackerAddressHolder(InetSocketAddress address) {
        this.address = address;
        this.available = true;
    }

    public void setActive() {
        this.available = true;
    }

    public void setInActive() {
        this.available = false;
        this.lastUnavailableTime = System.currentTimeMillis();
    }

    public boolean isAvailable() {
        return available;
    }

    public long getLastUnavailableTime() {
        return lastUnavailableTime;
    }

    public boolean canTryToConnect(int retryAfterSeconds) {
        if (this.available) {
            return true;
        }
        return (System.currentTimeMillis() - lastUnavailableTime) > retryAfterSeconds * 1000;
    }

    public InetSocketAddress getAddress() {
        return address;
    }

}

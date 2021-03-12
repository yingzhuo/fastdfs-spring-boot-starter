package com.github.yingzhuo.fastdfs.springboot.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author 应卓
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "carnival.fastdfs.tracker")
public class TrackerProperties implements InitializingBean {

    private String[] nodes = new String[0];

    @Override
    public void afterPropertiesSet() {
        Assert.notEmpty(nodes, "tracker nodes not configured");
        nodes = Arrays.stream(nodes)
                .filter(Objects::nonNull)
                .map(String::trim)
                .toArray(String[]::new);
    }

}

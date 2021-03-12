package com.github.yingzhuo.fastdfs.springboot.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * 缩略图生成配置支持
 *
 * @author tobato
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "fastdfs.thumb-image")
public class ThumbImageProperties implements Serializable, InitializingBean {

    private int defaultWidth;
    private int defaultHeight;

    @Override
    public void afterPropertiesSet() {
    }

}

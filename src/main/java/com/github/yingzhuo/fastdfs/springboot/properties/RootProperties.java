package com.github.yingzhuo.fastdfs.springboot.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Getter
@Setter
@ConfigurationProperties(prefix = "carnival.fastdfs")
public class RootProperties implements InitializingBean {

    private boolean enabled = true;
    private int soTimeout;
    private int connectTimeout;
    private Charset charset = StandardCharsets.UTF_8;
    private boolean safeMode = true;

    @Override
    public void afterPropertiesSet() {
    }

}

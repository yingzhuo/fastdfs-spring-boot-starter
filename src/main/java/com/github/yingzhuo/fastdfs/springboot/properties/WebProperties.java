package com.github.yingzhuo.fastdfs.springboot.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 表示文件Web服务器对象
 *
 * @author tobato
 * @author 应卓
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "fastdfs.web")
public class WebProperties implements InitializingBean {

    private String url = "";

    @Override
    public void afterPropertiesSet() {
        if (url != null && !url.isEmpty()) {
            if (!url.endsWith("/")) {
                url = url + "/";
            }
        }
    }

}

package com.github.yingzhuo.fastdfs.springboot.autoconfig;

import com.github.yingzhuo.fastdfs.springboot.actuator.FastDFSHealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * @author 应卓
 */
@ConditionalOnClass(name = "org.springframework.boot.actuate.endpoint.annotation.Endpoint")
@ConditionalOnProperty(prefix = "carnival.fastdfs", name = "enabled", havingValue = "true", matchIfMissing = true)
public class FastDfsActuatorAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public FastDFSHealthIndicator fastDFSHealthIndicator() {
        return new FastDFSHealthIndicator();
    }

}

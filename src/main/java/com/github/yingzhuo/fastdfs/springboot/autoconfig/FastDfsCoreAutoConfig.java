package com.github.yingzhuo.fastdfs.springboot.autoconfig;

import com.github.yingzhuo.fastdfs.springboot.FastDFS;
import com.github.yingzhuo.fastdfs.springboot.client.*;
import com.github.yingzhuo.fastdfs.springboot.domain.conn.ConnectionFactory;
import com.github.yingzhuo.fastdfs.springboot.domain.conn.ConnectionPool;
import com.github.yingzhuo.fastdfs.springboot.domain.conn.StorageConnectionManager;
import com.github.yingzhuo.fastdfs.springboot.domain.conn.TrackerConnectionManager;
import com.github.yingzhuo.fastdfs.springboot.properties.*;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * 自动配置
 *
 * @author tobato
 * @author 应卓
 */
@Configuration
@EnableConfigurationProperties({
        RootProperties.class,
        PoolProperties.class,
        TrackerProperties.class,
        WebProperties.class,
        ThumbImageProperties.class
})
@ConditionalOnProperty(prefix = "carnival.fastdfs", name = "enabled", havingValue = "true", matchIfMissing = true)
public class FastDfsCoreAutoConfig implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        FastDFS.applicationContext = applicationContext;
    }

    @Bean
    @ConditionalOnMissingBean
    public ConnectionFactory connectionFactory(RootProperties rootConfig) {
        return new ConnectionFactory(
                rootConfig.getSoTimeout(),
                rootConfig.getConnectTimeout(),
                rootConfig.getCharset()
        );
    }

    @Bean
    @ConditionalOnMissingBean
    public ConnectionPool connectionPool(ConnectionFactory factory, PoolProperties poolConfig) {
        return new ConnectionPool(factory, poolConfig);
    }

    @Bean
    @ConditionalOnMissingBean
    public StorageConnectionManager storageConnectionManager(ConnectionPool pool) {
        return new StorageConnectionManager(pool);
    }

    @Bean
    @ConditionalOnMissingBean
    public TrackerConnectionManager trackerConnectionManager(ConnectionPool pool, TrackerProperties trackerConfig) {
        return new TrackerConnectionManager(
                pool,
                Arrays.asList(trackerConfig.getNodes())
        );
    }

    @Bean
    @ConditionalOnMissingBean
    public TrackerClient trackerClient(TrackerConnectionManager manager, RootProperties rootConfig) {
        TrackerClient bean = new TrackerClientImpl(manager);
        return rootConfig.isSafeMode() ? new TrackerClientImplSafe(bean) : bean;
    }

    @Bean
    @ConditionalOnMissingBean
    public GenerateStorageClient generateStorageClient(TrackerClient client, StorageConnectionManager manager) {
        return new GenerateStorageClientImpl(client, manager);
    }

    @Bean
    @ConditionalOnMissingBean
    public AppendFileStorageClient appendFileStorageClient(TrackerClient client, StorageConnectionManager manager) {
        return new AppendFileStorageClientImpl(client, manager);
    }

    @Bean
    @ConditionalOnMissingBean
    public FastFileStorageClient fastFileStorageClient(TrackerClient client, StorageConnectionManager manager, ThumbImageProperties thumbImageConfig) {
        return new FastFileStorageClientImpl(
                client,
                manager,
                thumbImageConfig.getDefaultWidth(),
                thumbImageConfig.getDefaultHeight()
        );
    }

}

package com.github.yingzhuo.fastdfs.springboot;

import com.github.yingzhuo.fastdfs.springboot.client.FastFileStorageClient;
import com.github.yingzhuo.fastdfs.springboot.domain.fdfs.MetaData;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.storage.BytesDownloadCallback;
import com.github.yingzhuo.fastdfs.springboot.properties.WebProperties;
import lombok.val;
import lombok.var;
import org.springframework.context.ApplicationContext;

import java.io.InputStream;
import java.util.Collections;
import java.util.Set;

/**
 * @author 应卓
 */
public final class FastDFS {

    public static ApplicationContext applicationContext;

    private FastDFS() {
    }

    public static String upload(InputStream in, long fileSize, String fileExtName) {
        return upload(in, fileSize, fileExtName, Collections.emptySet());
    }

    public static String upload(InputStream in, long fileSize, String fileExtName, Set<MetaData> metaDataSet) {

        var prefix = applicationContext.getBean(WebProperties.class).getUrl();
        if (prefix == null) {
            prefix = "";
        }

        val cli = applicationContext.getBean(FastFileStorageClient.class);
        val data = cli.uploadFile(in, fileSize, fileExtName, metaDataSet);
        return prefix + data.getFullPath();
    }

    public static void delete(String filePath) {

        var prefix = applicationContext.getBean(WebProperties.class).getUrl();
        if (prefix == null) {
            prefix = "";
        }

        if (filePath.startsWith(prefix)) {
            filePath = filePath.substring(prefix.length());
        }

        val cli = applicationContext.getBean(FastFileStorageClient.class);
        cli.deleteFile(filePath);
    }

    public static byte[] download(String filePath) {
        var prefix = applicationContext.getBean(WebProperties.class).getUrl();
        if (prefix == null) {
            prefix = "";
        }

        if (filePath.startsWith(prefix)) {
            filePath = filePath.substring(prefix.length());
        }

        val parts = filePath.split("/", 2);
        val groupName = parts[0];
        val path = parts[1];
        val cli = applicationContext.getBean(FastFileStorageClient.class);

        BytesDownloadCallback callback = new BytesDownloadCallback();
        cli.downloadFile(groupName, path, callback);
        return callback.getBytes();
    }

}

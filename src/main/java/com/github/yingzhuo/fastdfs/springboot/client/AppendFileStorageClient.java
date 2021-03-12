package com.github.yingzhuo.fastdfs.springboot.client;

import com.github.yingzhuo.fastdfs.springboot.domain.fdfs.StorePath;

import java.io.InputStream;

/**
 * 支持断点续传的文件服务接口
 *
 * @author tobato
 */
public interface AppendFileStorageClient extends GenerateStorageClient {

    /*
     * 上传支持断点续传的文件
     */
    public StorePath uploadAppenderFile(String groupName, InputStream inputStream, long fileSize, String fileExtName);

    /*
     * 断点续传文件
     */
    public void appendFile(String groupName, String path, InputStream inputStream, long fileSize);

    /*
     * 修改续传文件的内容
     */
    public void modifyFile(String groupName, String path, InputStream inputStream, long fileSize, long fileOffset);

    /*
     * 清除续传类型文件的内容
     */
    public void truncateFile(String groupName, String path, long truncatedFileSize);

    /*
     * 清除续传类型文件的内容
     */
    public void truncateFile(String groupName, String path);

}

package com.github.yingzhuo.fastdfs.springboot.domain.fdfs;

import com.github.yingzhuo.fastdfs.springboot.domain.proto.OtherConstants;
import com.github.yingzhuo.fastdfs.springboot.domain.proto.mapper.Column;
import lombok.*;

/**
 * 文件的基础信息
 *
 * @author yuqih
 * @author 应卓
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FileInfo {

    /**
     * 长度
     */
    @Column(index = 0)
    private long fileSize;

    /**
     * 创建时间
     */
    @Column(index = 1)
    private long createTime;

    /**
     * 校验码
     */
    @Column(index = 2)
    private int crc32;

    /**
     * ip地址
     */
    @Column(index = 3, max = OtherConstants.FDFS_IP_ADDR_SIZE)
    private String sourceIpAddr;

}

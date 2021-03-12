package com.github.yingzhuo.fastdfs.springboot.domain.proto.mapper;

import java.lang.annotation.*;

/**
 * 传输参数定义标签
 *
 * @author tobato
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

    public int index();

    public int max() default 0;

    public DynamicFieldType dynamicField() default DynamicFieldType.NULL;

}

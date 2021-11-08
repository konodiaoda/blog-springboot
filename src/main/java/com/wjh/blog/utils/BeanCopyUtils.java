package com.wjh.blog.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujiahui
 * @description 复制对象或者集合
 * @date 2021-10-22 12:07
 */
public class BeanCopyUtils {

    public static<T> T copyObject(Object source, Class<T> target){
        T temp=null;
        try {
            temp = target.newInstance();
            if (null!=source){
                BeanUtils.copyProperties(source,temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
    }
        return temp;
}

public static <T,S> List<T> copyList(List<S> source,Class<T> target){
    List<T> list =new ArrayList<>();
    if (!CollectionUtils.isEmpty(source)){
        source.forEach(obj->{
            list.add(BeanCopyUtils.copyObject(obj, target));
        });
    }
    return list;
    }
}

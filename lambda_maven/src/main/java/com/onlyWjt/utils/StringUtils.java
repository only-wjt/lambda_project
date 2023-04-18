package com.onlyWjt.utils;

import com.alibaba.fastjson.JSON;
import com.onlyWjt.utils.interfaceUtil.StringInte;

public class StringUtils{
   public static <T> T StringToAll(Class<T> type, String str){
       if (type == Integer.class) {
           return type.cast(Integer.parseInt(str));
       } else if (type == Double.class) {
           return type.cast(Double.parseDouble(str));
       } else if (type == JSON.class) {
           return type.cast(JSON.parse(str));
       } else {
           throw new IllegalArgumentException("Unsupported type: " + type);
       }
   }
}
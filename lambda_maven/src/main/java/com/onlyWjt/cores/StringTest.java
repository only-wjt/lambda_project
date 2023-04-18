package com.onlyWjt.cores;

import com.onlyWjt.utils.StringUtils;
import com.onlyWjt.utils.interfaceUtil.StringInte;

public class StringTest {
    public static void main(String[] args) {
        Integer integer =StringUtils.StringToAll(Integer.class, "111");
        System.out.println(integer);
    }
}

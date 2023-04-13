package com.onlyWjt.cores;

import com.only.utils.StringUtils;
import com.only.utils.interfaceUtil.StringInte;

public class StringTest {
    public static void main(String[] args) {
        Integer integer =StringUtils.StringToAll(Integer.class, "111");
        System.out.println(integer);
    }
}

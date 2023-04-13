package com.onlyWjt.cores;

import java.util.function.Function;

public class LambdaDemo02 {
    public static void main(String[] args) {
        Integer integer = typeConver(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        });
        typeConver(s -> Integer.parseInt(s));
    }
    public static <R> R typeConver(Function<String,R> function){
        String str = "1235";
        R result = function.apply(str);
        System.out.println(result);
        return result;
    }
}

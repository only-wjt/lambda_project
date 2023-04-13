package com.onlyWjt;

import com.onlyWjt.model.Author;
import com.onlyWjt.utils.Constutil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        test01();
        test02();
        test03();
    }
    private static void test03() {
        System.out.println("=============test03===================");
        Map<String,Integer> map = new HashMap<>();
        map.put("蜡笔小新",19);
        map.put("黑子",17);
        map.put("日向翔阳",16);
        Stream<Map.Entry<String, Integer>> streamMap = map.entrySet().stream();
        List<Map.Entry<String, Integer>> 日向翔阳 = streamMap.filter(stringIntegerEntry -> stringIntegerEntry.getKey().equals("日向翔阳")).collect(Collectors.toList());
        System.out.println(日向翔阳);

    }

    private static void test02() {
        System.out.println("test02======================");
        Integer[] arr = {1,2,3,4,5};
//        Arrays.stream(arr).
        Stream<Integer> stream = Arrays.stream(arr);
        List<Integer> collect = stream.filter(integer -> integer % 2 == 0).collect(Collectors.toList());
        System.out.println(collect.toString());

        Stream<Integer> stream2 = Stream.of(arr);
        stream2.filter(integer -> integer%2==0).collect(Collectors.toList());
    }

    private static void test01() {
        List<Author> authors = Constutil.getAuthors();
//        System.out.println(authors.toString());
        authors.stream()
                .distinct()
                .filter(data->data.getAge()<18)
                .forEach(data-> System.out.println(data.getName()));
    }
}
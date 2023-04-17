package com.onlyWjt;

import com.onlyWjt.model.Author;
import com.onlyWjt.model.Book;
import com.onlyWjt.model.Person;
import com.onlyWjt.utils.Constutil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
//        test01();
//        test02();
//        test03();
//        test04();
//        test05();
//        test06();
//        test07();
//        test08();
//        test09();
//        test10();
//        test11();
//        test12();
//        test13();
//        test14();
//        test15();
//        test16();
        test17();
    }

    private static void test17() {
        System.out.println("=============自定义链式调用===================");
        Person man = new Person().age(1).weight(179).gender("man").filterWeight().lessThan(100).done();


    }

    private static void test16() {
        System.out.println("=============test16===================");
        List<Author> authors = Constutil.getAuthors();
        Integer reduce = authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(0, (integer, integer2) -> integer + integer2);
        System.out.println(reduce);
        System.out.println("=============test16 reduce找年纪最大值===================");
        //第一个参数是返回的变量，第一个参数是传入的值
        Integer reduce1 = authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(Integer.MIN_VALUE, (integer, integer2) -> integer > integer2 ? integer : integer2);
        System.out.println(reduce1);
        System.out.println("=============test16 reduce找年纪最大值 一个参数的方法，确实就是把第一个参数当成了默认值===================");
        authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce((a1,a2)-> a1>a2?a1:a2)
                .ifPresent(age-> System.out.println(age));
    }

    private static void test15() {
        System.out.println("=============test15===================");
        List<Author> authors = Constutil.getAuthors();
        authors.stream()
                .filter(author -> author.getAge()>0)
                .findAny()
                .ifPresent(author -> System.out.println(author.getName()));
        System.out.println("=============findFirst===================");
        authors.stream()
                .findFirst().ifPresent(author -> System.out.println(author.getName()));
    }

    private static void test14() {
        System.out.println("=============test14===================");
        List<Author> authors = Constutil.getAuthors();
        boolean b = authors.stream()
                .anyMatch(author -> author.getAge() < 18);
        System.out.println(b);
        System.out.println("=============allMatch===================");
        //如果所有的都匹配，才会返回TRUE
        boolean b1 = authors.stream()
                .allMatch(author -> author.getAge() < 18);
        System.out.println(b1);
        System.out.println("=============noneMatch===================");
        //如果所有的都不匹配，才会返回TRUE
        boolean b2 = authors.stream()
                .noneMatch(author -> author.getAge() > 100);
        System.out.println(b2);

    }

    private static void test13() {
        System.out.println("=============test13===================");
        List<Author> authors = Constutil.getAuthors();
        Map<String, List<Book>> collect = authors.stream()
                .distinct()
                .collect(Collectors.toMap(author -> author.getName(), author -> author.getBooks()));
        System.out.println(collect);
    }

    private static void test12() {
        System.out.println("=============test12===================");
        List<Author> authors = Constutil.getAuthors();
        List<Author> collect = authors.stream().filter(data -> data.getAge() < 18).collect(Collectors.toList());
        System.out.println(collect);
        Set<Book> collect1 = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .collect(Collectors.toSet());
        System.out.println(collect1);

    }

    private static void test11() {
        System.out.println("=============test11===================");
        List<Author> authors = Constutil.getAuthors();
        Integer integer = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .max((o1, o2) -> o2 - o1).get();
        System.out.println(integer);
    }

    private static void test10() {
        System.out.println("=============test10===================");
        List<Author> authors = Constutil.getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream()
                        .distinct()
                        .flatMap(book-> Arrays.stream(book.getCategory().split(","))))
                .distinct()
                .forEach(category-> System.out.println(category.toString()));
    }

    private static void test09() {
        System.out.println("=============test09===================");
        List<Author> authors = Constutil.getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .forEach(book -> System.out.println(book));
    }

    private static void test08() {
        System.out.println("=============test08===================");
        List<Author> authors = Constutil.getAuthors();
        authors.stream().skip(1)
                .forEach(author-> System.out.println(author.getAge()));
    }

    private static void test07() {
        System.out.println("=============test07===================");
        List<Author> authors = Constutil.getAuthors();
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge()-o1.getAge())
                .limit(2)
                .forEach(author-> System.out.println(author.getAge()));
    }

    private static void test06() {
        System.out.println("=============test06===================");
        List<Author> authors = Constutil.getAuthors();
        authors.stream().distinct().sorted().forEach(user-> System.out.println(user.getAge()));
    }

    private static void test05() {
        System.out.println("=============test05===================");
        List<Author> authors = Constutil.getAuthors();
        authors.stream().distinct().forEach(author-> System.out.println(author.toString()));
    }

    private static void test04() {
        System.out.println("=============test04===================");
        List<Author> authors = Constutil.getAuthors();
        authors.stream().map(author->author.getName()).forEach(author-> System.out.println(author));
        authors.stream().map(author->author.getAge()).map(age->age+10).forEach(age-> System.out.println(age));

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
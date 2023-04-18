package com.onlyWjt;

import com.onlyWjt.model.Author;
import com.onlyWjt.utils.Constutil;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class MethodDemo {
    interface UseString{
        String use(String str,int start,int length);
    }

    public static String subAuthorName(String str, UseString useString){
        int start = 0;
        int length = 1;
        return useString.use(str,start,length);
    }
    public static void main(String[] args) {

        subAuthorName("三更草堂", new UseString() {
            @Override
            public String use(String str, int start, int length) {
                return str.substring(start,length);
            }
        });
        subAuthorName("三更草堂", String::substring);
        test01();
        test02();
        test03();
    }

    private static void test03() {
        System.out.println("==================test03===================");
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        stream.filter(num->num>5)
//                .reduce((result, ele) -> result+ele)
//                .get();
        System.out.println("==================并行流===================");

        Integer sum = stream.parallel()
                .peek(num -> System.out.println(num+Thread.currentThread().getName()))
                .filter(num -> num > 5)
                .reduce((result, ele) -> result + ele)
                .get();
        System.out.println(sum);
    }

    private static void test01() {
        List<Author> authors = Constutil.getAuthors();
        authors.stream()
                .map(Author::getName)
                .map(StringBuilder::new)//构造器方式
                .map(sb->sb.append("-三更").toString())
                .forEach(System.out::println);
    }
    private static void test02() {
        System.out.println("==================test02===================");
        List<Author> authors = Constutil.getAuthors();
        authors.stream()
                .map(author -> author.getAge())
                .map(age -> age + 10)
                .filter(age->age>18)
                .map(age->age+2)
                .forEach(System.out::println);

        authors.stream()
                .mapToInt(author -> author.getAge())
                .map(age -> age + 10)
                .filter(age->age>18)
                .map(age->age+2)
                .forEach(System.out::println);
    }

}

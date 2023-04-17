package com.onlyWjt;

import com.onlyWjt.model.Author;
import com.onlyWjt.model.Book;
import com.onlyWjt.utils.Constutil;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class OptionalDemo {
    public static void main(String[] args) {
//        test01();
//        Optional<Author> authorOptional = Constutil.getAuthorOptional();
//        authorOptional.ifPresent(author -> System.out.println("author = " + author));
//        test02();
//        test03();
        test04();
    }

    private static void test04() {
        System.out.println("=============test04==========");
        Optional<Author> authorOptional = Constutil.getAuthorOptional();
        authorOptional
                .flatMap(author -> Optional.ofNullable(author.getBooks()))
                .ifPresent(books -> System.out.println(books.get(0)));

        System.out.println("=============test04--flatMap==========");
        List<Book> collect = Constutil.getAuthors()
                .stream()
                .flatMap(author -> author.getBooks().stream())
                .collect(Collectors.toList());
        System.out.println(collect.toString());
    }

    private static void test03() {
        System.out.println("=============test03==========");
        Optional<Author> authorOptional = Constutil.getAuthorOptional();
        Optional<Author> author1 = authorOptional.filter(author -> author.getAge()>0);
        author1.ifPresent(author -> System.out.println("author = " + author));
        if(author1.isPresent()){
            System.out.println(author1);
        }
    }

    private static void test02() {
        System.out.println("=============test02==========");
        Optional<Author> authorOptional = Constutil.getAuthorOptional();
        Author author = authorOptional.orElseGet(() -> new Author());
        System.out.println(author);
        System.out.println("=============test02throwException==========");
        try {
            Author author2 = authorOptional.orElseThrow(() -> new RuntimeException("数据为null"));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static void test01() {
        Author author = Constutil.getAuthor();
        Optional<Author> author1 = Optional.ofNullable(author);
        author1.ifPresent(author2 -> System.out.println(author2.getName()));
    }
}

package com.onlyWjt;

import com.onlyWjt.model.Author;
import com.onlyWjt.utils.Constutil;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        testClass();
    }

    private static void testClass() {
        List<Author> authors = Constutil.getAuthors();
        authors.stream()
                .map(Author::getAge)
                .map(String::valueOf)
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        authors.stream()
                .map(author -> author.getName())
                .forEach(sb::append);
    }
}

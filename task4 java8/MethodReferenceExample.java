package org.example;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        // use lambda expression
        names.forEach(name -> System.out.println(name));

        // use method reference
        names.forEach(System.out::println);
    }
}

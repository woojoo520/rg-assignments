package org.example;

import java.util.Arrays;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Steve");
        names.stream()
                .filter(s -> s.startsWith("A"))
                .forEach(System.out::println);
    }
}

/*
// Without lambda expression
public class LambdaExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Steve");
        names.stream()
                .filter(new java.util.function.Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return s.startsWith("A");
                    }
                })
                .forEach(new java.util.function.Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        System.out.println(s);
                    }
                });
    }
}
*/
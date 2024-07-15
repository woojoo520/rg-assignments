package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Predicate<String> predicate = s -> s.length() > 5;
        List<String> names = Arrays.asList("Emma", "Alexander", "Alice", "Mariana");
        List<String> filterNames = names.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        System.out.println("Filtered names: " + filterNames);
        // output: Filtered names: [Alexander, Mariana]

        Function<String, Integer> getLen = s -> s.length();
        List<Integer> nameLens = names.stream()
                .map(getLen)
                .collect(Collectors.toList());
        System.out.println("Name lengths: " + nameLens);
        // output: Name lengths: [4, 9, 5, 7]

        Supplier<String> supplier = () -> "Generate Values";
        System.out.println(supplier.get());
        // output: Generate Values
    }
}

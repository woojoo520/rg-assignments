package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapToUppercaseExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("alice", "bob", "charlie", "david");
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Original List: " + names);
        System.out.println("Uppercase List: " + upperCaseNames);
    }
}

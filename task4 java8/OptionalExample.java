package org.example;

import java.time.Period;
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        String defaultValue = "DEFAULT";
        // Without Optional
        String value1 = getValue(true);
        if (value1 == null) {
            value1 = defaultValue;
        }
        System.out.println("Value is " + value1);

        // With optional
        String value2 = getOptionalValue(true)
                .orElse(defaultValue);
        System.out.println("Value is " + value2);

//        Optional<String> optionalValue = getOptionalValue(true);
//        optionalValue.orElseThrow(() -> new IllegalArgumentException("Empty args"));
    }

    public static String getValue(boolean returnNull) {
        return returnNull ? null : "Hello World";
    }

    public static Optional<String> getOptionalValue(boolean returnNull) {
        return returnNull ? Optional.empty() : Optional.of("Hello World");
    }
}

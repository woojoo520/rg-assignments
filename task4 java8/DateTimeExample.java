package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateTimeExample {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: " + currentDate);

        LocalTime currentTime = LocalTime.now();
        System.out.println("Current Time: " + currentTime);
    }
}

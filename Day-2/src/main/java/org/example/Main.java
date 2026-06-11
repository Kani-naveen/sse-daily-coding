package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       List<String> names = Arrays.asList("Shanmughakani", "Lavanya", "Mamatha");

       List<String> upperNames = names.stream()
               .map(String::toUpperCase)
               .toList();
        List<Integer> length = names.stream()
                .map(String::length)
                .toList();

       System.out.println(upperNames);
       System.out.println(length);

    }
}
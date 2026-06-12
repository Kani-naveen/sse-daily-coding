package org.example;

import java.util.Arrays;
import java.util.List;
//Streams: Map Strings to uppercase & collect
//get their lengths as well
public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Kani","Yazh","Naveen");

        List<String> upperNames = names.stream()
                .map(String::toUpperCase)
                .toList();
        List<Integer> length = names.stream()
                        .map(String::length)
                                .toList();

        System.out.println("UpperCased Names: "+ upperNames);
        System.out.println("Length: "+length);
    }
}
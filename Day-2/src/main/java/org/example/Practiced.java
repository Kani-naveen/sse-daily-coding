package org.example;

import java.util.Arrays;
import java.util.List;

//Streams: Map Strings to uppercase & collect
//get their lengths as well
public class Practiced {
    public static void main(String[] args){
        List<String> names = Arrays.asList("Kani","Naveen","Yazh");

        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .toList();

        List<Integer> length = names.stream()
                        .map(String::length)
                                .toList();

        System.out.println(upperCaseNames+"\n"+length);
    }
}

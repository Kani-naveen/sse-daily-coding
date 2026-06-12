package org.example;

import java.util.Arrays;
import java.util.List;
//streams: Flatmap nested lists into single stream
public class Main {
    public static void main(String[] args) {

        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,5,5,6,6),
                Arrays.asList(7,8,9)
        );

        List<Integer> result = numbers.stream()
                .flatMap(List::stream)
                .distinct()
                .toList();

        System.out.println(result);

    }
}
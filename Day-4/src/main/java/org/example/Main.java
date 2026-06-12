package org.example;

import java.util.Arrays;
import java.util.List;
//find the different behavior of findFirst() and findAny()
public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,1,3,51,441,32);

        Integer result = numbers.stream()
                .filter(n->n%2 == 0)
                .findFirst()
                .orElse(null);

       Integer findAnyResult = numbers.parallelStream()
                        .filter(n->n>20)
                        .findAny()
                        .orElse(null);

        System.out.println(result);
        System.out.println(findAnyResult);
    }
}
package org.example;


import java.util.Arrays;
import java.util.List;

public class Main{
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(5,7,8,10, 18, 12, 11, 4, 24, 36);

        List<Integer> result = numbers.stream()
                .filter(n->n>10 && n%2 == 0)
                .toList();

        System.out.println(result);
    }
}


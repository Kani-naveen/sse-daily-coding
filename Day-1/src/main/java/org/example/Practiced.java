package org.example;

import java.util.Arrays;
import java.util.List;

public class Practiced {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1,2,3,14,5,6,72,89,90,10);

        List<Integer> evenNumbers = numbers.stream()
                .filter(n->n>10 && n%2 == 0)
                .toList();
        System.out.println(evenNumbers);
    }
}

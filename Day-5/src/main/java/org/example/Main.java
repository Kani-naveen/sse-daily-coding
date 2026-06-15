package org.example;

import java.util.*;
//Streams: reduce() to sum all numbers
public class Main {
    public static void main(String[] args) {
       List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

       List<String> names = Arrays.asList("Shanmughakani", "Naveen", "Yazh");
       Integer result = numbers.stream()
               .reduce(0,Integer::sum);
//             .reduce(0,(a,b)->a+b);

       String strResult = names.stream()
                       .map(String::toUpperCase)
//                       .reduce("",String::concat);
                        .reduce((a,b)->a+" "+b)
                        .orElse("");
        System.out.println(result+"\n"+strResult);
    }
}
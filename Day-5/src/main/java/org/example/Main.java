package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
       List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

       List<String> names = Arrays.asList("Shanmughakani", "Naveen", "Yazh");
       Integer result = numbers.stream()
               .reduce(0,Integer::sum);

       String strResult = names.stream()
                       .reduce("",String::concat);
        System.out.println(result+"\n"+strResult);
    }
}
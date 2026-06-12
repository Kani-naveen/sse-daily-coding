package org.example;


import java.util.Arrays;
import java.util.List;
//Streams: Filter even numbers > 10 from the list
public class Main{
    public static void main(String[] args){
      List<Integer> numbers = Arrays.asList(5,3,24,36,73,36,2,1,8,44,46);

      List<Integer> result = numbers.stream()
              .filter(n->n>10 && n%2 == 0)
              .distinct()
              .toList();


      System.out.println(result);
    }
}


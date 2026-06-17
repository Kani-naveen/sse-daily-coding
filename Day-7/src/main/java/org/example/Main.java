package org.example;

//T can be a number or any subclass of number but restricts to non-numeric values.
public class Main {
    public static <T extends Number> void printNumber(T number){
        System.out.println(number);
    }
    public static void main(String[] args) {
       printNumber(5);
    }
}
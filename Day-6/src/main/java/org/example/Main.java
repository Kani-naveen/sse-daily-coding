package org.example;

import java.util.ArrayList;
import java.util.List;

class Stack<T>{
    private final List<T> elements = new ArrayList<>();

    public void push(T item){
        elements.add(item);
    }

    public T pop(){
        if (elements.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return elements.removeLast();
    }
    public T peek(){
        if(elements.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return elements.getLast();
    }
    public boolean isEmpty() {
        return elements.isEmpty();
    }
    public void display(){
        for(T element : elements){
            System.out.println(element);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println("And the stack elements are :");
        stack.display();
        System.out.println("++++++++++++++++++++++++++++");
        System.out.println("Peeking: "+stack.peek());

        System.out.println("Popping: "+stack.pop());
        System.out.println("Popping: "+stack.pop());

        System.out.println("Peeking: "+stack.peek());
        System.out.println("Is stack empty: "+stack.isEmpty());




    }
}
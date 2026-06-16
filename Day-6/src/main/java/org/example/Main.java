package org.example;

import java.util.ArrayList;
import java.util.List;

class Stack<T>{
    private List<T> elements = new ArrayList<>();

    public void push(T item){
        elements.add(item);
    }

    public T pop(){
        if (elements.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return elements.remove(elements.size()-1);
    }
    public T peek(){
        if(elements.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return elements.get(elements.size()-1);
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
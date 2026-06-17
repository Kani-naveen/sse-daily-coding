package org.example;
import java.util.*;

class DequeStack<T>{
    private final Deque<T> elements = new ArrayDeque<>();

    public void push(T item){
        elements.push(item);
    }
    public T peek(){
        return elements.peek();
    }
    public T pop(){
        return elements.pop();
    }
    public boolean isEmpty(){
       return elements.isEmpty();
    }
    public void display(){
        System.out.println(elements);
    }

}

public class DequeVersionOfStack {
    public static void main(String[] args) {
    DequeStack<Integer> stack = new DequeStack<>();
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(40);

        System.out.println(stack.peek());
        stack.display();
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.display();
        System.out.println(stack.isEmpty());
}
}

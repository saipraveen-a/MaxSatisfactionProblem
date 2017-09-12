package main.java.com.techolution;

import java.util.LinkedList;

public class Stack<T> {
  private LinkedList<T> stack;

  public Stack() {
    stack = new LinkedList<>();
  }

  public void push(T data) {
    stack.addFirst(data);
  }

  public T pop() {
    return stack.removeFirst();
  }

  public T top() {
    return stack.getFirst();
  }

  public boolean isEmpty() {
    return stack.isEmpty();
  }

  public int size() {
    return stack.size();
  }

  public void print() {
    System.out.println(stack);
  }
}

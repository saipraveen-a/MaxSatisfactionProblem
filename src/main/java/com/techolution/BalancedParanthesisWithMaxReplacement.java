package main.java.com.techolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BalancedParanthesisWithMaxReplacement {

  private static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {
    int[] balanced = new int[expressions.length];
    for (int i = 0; i < expressions.length; i++) {
      balanced[i] = isBalanced(expressions[i], maxReplacements[i]);
    }
    return balanced;
  }

  private static int isBalanced(String expression, int maxReplacement) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0 ; i < expression.length(); i++) {
      if (expression.charAt(i) == '<')
        stack.push(expression.charAt(i));
      if (expression.charAt(i) == '>') {
        if (!stack.isEmpty() && stack.top() == '<')
          stack.pop();
        else
          stack.push(expression.charAt(i));
      }
    }
    if (stack.isEmpty())
      return 1;
    while (!stack.isEmpty()) {
      int count = 0;
      Character c = stack.pop();
      if (c == '<') {
        count++;
        if (count > maxReplacement)
          return 0;
      }
    }
    return 0;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int numberOfLines = Integer.parseInt(br.readLine());
    String[] expressions = new String[numberOfLines];
    int[] maxReplacements = new int[numberOfLines];

    for (int i = 0; i < numberOfLines; i++) {
      expressions[i] = br.readLine();
    }
    for (int i = 0; i < numberOfLines; i++) {
      maxReplacements[i] = Integer.valueOf(br.readLine());
    }
    print(balancedOrNot(expressions, maxReplacements));

    br.close();
  }

  private static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}

package main.java.com.techolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsecutiveNumbersSum {
  private static List<String> consecutiveNumbers = new ArrayList<>();

  private static int findConsecutiveNumbersSum(long n) {
    int consecutiveNumbersSum = 0;
    for (long startIndex = 1; startIndex <= n/2; startIndex++) {
      long sum = 0;
      long endIndex = startIndex;
      while (sum < n) {
        sum += endIndex;
        endIndex++;
      }
      if (sum == n) {
        consecutiveNumbersSum += 1;
        consecutiveNumbers.add(startIndex + "-" + --endIndex);
        sum = 0;
      }
    }
    return consecutiveNumbersSum;
  }

  private static int findConsecutiveNumbersSumOptimized(long n) {
    int countOfConsecutiveNumbersAddingToN = 0;
    long endIndex = 1;
    long sum = 1;
    for (long startIndex = 1; startIndex <= n/2;) {
      if (sum < n) {
        endIndex++;
        sum += endIndex;
      } else if (sum == n) {
        countOfConsecutiveNumbersAddingToN++;
        consecutiveNumbers.add(startIndex + "-" + endIndex);
        sum -= startIndex;
        startIndex++;
      } else {
        sum -= startIndex;
        startIndex++;
      }
    }
    return countOfConsecutiveNumbersAddingToN;
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long number = Long.parseLong(br.readLine());
    System.out.println(findConsecutiveNumbersSumOptimized(number));
    System.out.println(consecutiveNumbers);

    br.close();
  }
}

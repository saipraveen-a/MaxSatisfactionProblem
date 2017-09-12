package main.java.com.techolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PsychometricTesting {

  private static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {
    Arrays.sort(scores);

    int[] countOfElementsInRange = new int[lowerLimits.length];
    for (int i = 0; i < lowerLimits.length; i++) {
      int lowerIndex = binarySearchForLowerIndex(scores, lowerLimits[i]);
      int upperIndex = binarySearchForUpperIndex(scores, upperLimits[i]);
      if (lowerIndex == -1 || upperIndex == -1)
        countOfElementsInRange[i] = 0;
      countOfElementsInRange[i] = upperIndex - lowerIndex;
      if (isElementAtIndexSameAsLimit(scores[upperIndex], upperLimits[i]))
        countOfElementsInRange[i]++;
      if (isElementAtIndexSameAsLimit(scores[lowerIndex], lowerLimits[i]))
        countOfElementsInRange[i]++;
    }
    return countOfElementsInRange;
  }

  private static boolean isElementAtIndexSameAsLimit(int score, int upperLimit) {
    return score == upperLimit;
  }

  private static int binarySearchForUpperIndex(int[] scores, int upperLimit) {
    if (upperLimit < scores[0])
      return -1;
    int low = 0;
    int high = scores.length - 1;
    while (low != high) {
      int mid = (low + high)/2;
      if (scores[mid] <= upperLimit) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low;
  }

  private static int binarySearchForLowerIndex(int[] scores, int lowerLimit) {
    if (lowerLimit > scores[scores.length - 1])
      return -1;
    int low = 0;
    int high = scores.length - 1;
    while (low != high) {
      int mid = (low + high)/2;
      if (scores[mid] <= lowerLimit) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int numberOfScores = Integer.parseInt(br.readLine());
    int[] scores = new int[numberOfScores];
    for (int i = 0; i < numberOfScores; i++) {
      scores[i] = Integer.valueOf(br.readLine());
    }
    int q = Integer.parseInt(br.readLine());
    int[] lowerLimits = new int[q];
    for (int i = 0; i < q; i++) {
      lowerLimits[i] = Integer.parseInt(br.readLine());
    }

    q = Integer.parseInt(br.readLine());
    int[] upperLimits = new int[q];
    for (int i = 0; i < q; i++) {
      upperLimits[i] = Integer.parseInt(br.readLine());
    }

    print(jobOffers(scores, lowerLimits, upperLimits));
  }

  private static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}

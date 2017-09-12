package main.java.com.techolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoCircles {
  private static String[] circles(String[] circleInfos) {
    String[] circleLabels = new String[circleInfos.length];

    for (int i = 0; i < circleInfos.length; i++) {
      circleLabels[i] = labelCircles(circleInfos[i]);
    }

    return circleLabels;
  }

  private static String labelCircles(String circleInfo) {
    String[] coordinates = circleInfo.split(" ");
    int x1 = Integer.valueOf(coordinates[0]);
    int y1 = Integer.valueOf(coordinates[1]);
    int r1 = Integer.valueOf(coordinates[2]);
    int x2 = Integer.valueOf(coordinates[3]);
    int y2 = Integer.valueOf(coordinates[4]);
    int r2 = Integer.valueOf(coordinates[5]);

    int squareOfDistance = squareOfDistance(x1, y1, x2, y2);
    int squareOfRadiusSum = square(r1+r2);

    if (x1 == x2 && y1 == y2) {
      return "Concentric";
    }
    if (squareOfDistance == squareOfRadiusSum || squareOfDistance == square(Math.abs(r1-r2))) {
      return "Touching";
    }
    if (squareOfDistance < squareOfRadiusSum) {
      return "Intersecting";
    }
    if (squareOfDistance > squareOfRadiusSum) {
      return "Disjoint-Outside";
    }
    if (squareOfDistance < square(Math.abs(r1-r2))) {
      return "Disjoint-Inside";
    }
    return "NoLabel";
  }

  private static int square(int i) {
    return i * i;
  }

  private static int squareOfDistance(int x1, int y1, int x2, int y2) {
    return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int numberOfTests = Integer.parseInt(br.readLine());
    String[] circleInfo = new String[numberOfTests];

    for (int i = 0; i < numberOfTests; i++) {
      circleInfo[i] = br.readLine();
    }

    print(circles(circleInfo));
  }

  private static void print(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }
}

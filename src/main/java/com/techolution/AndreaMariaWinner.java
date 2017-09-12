package main.java.com.techolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AndreaMariaWinner {
  private static String findWinner(int[] andrea, int[] maria, String s) {
    int andreasValue = 0;
    int startIndex = -1;
    if (s.equalsIgnoreCase("Odd"))
      startIndex = 1;
    else
      startIndex = 0;

    for (int i = startIndex; i < andrea.length; i+=2) {
      andreasValue += andrea[i] - maria[i];
    }

    if (andreasValue > 0) {
      return "Andrea";
    } else if (andreasValue < 0) {
      return "Maria";
    } else {
      return "Tie";
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int numberOfAndreaEntries = Integer.parseInt(br.readLine());
    int[] andrea = new int[numberOfAndreaEntries];
    for (int i = 0; i < numberOfAndreaEntries; i++) {
      andrea[i] = Integer.valueOf(br.readLine());
    }

    int numberOfMariaEntries = Integer.parseInt(br.readLine());
    int[] maria = new int[numberOfMariaEntries];
    for (int i = 0; i < numberOfMariaEntries; i++) {
      maria[i] = Integer.valueOf(br.readLine());
    }

    String s = br.readLine();

    System.out.println(findWinner(andrea, maria, s));

    br.close();
  }
}

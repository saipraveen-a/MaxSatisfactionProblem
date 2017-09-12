package main.java.com.techolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuyMovieTickets {
  private static long waitingTime(int[] tickets, int p) {
    long waitingTime = 0;
    for (int i = 0; i < tickets.length; i++) {
      if (i <= p) {
        int min = Math.min(tickets[i], tickets[p]);
        waitingTime += min;
      } else {
        int min = Math.min(tickets[i], tickets[p] - 1);
        waitingTime += min;
      }
    }
    return waitingTime;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int numberOfLines = Integer.parseInt(br.readLine());
    int[] tickets = new int[numberOfLines];

    for (int i = 0; i < numberOfLines; i++) {
      tickets[i] = Integer.valueOf(br.readLine());
    }

    int p = Integer.valueOf(br.readLine());

    System.out.println(waitingTime(tickets, p));

    br.close();
  }
}

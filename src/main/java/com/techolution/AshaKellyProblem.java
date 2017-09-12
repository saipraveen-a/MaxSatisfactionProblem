package main.java.com.techolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AshaKellyProblem {
  private static int minNum(int numberOfProblemsAshaSolvesPerDay, int numberOfProblemsKellySolvesPerDay,
                             int numberOfProblemsAshaIsAheadOfKelly) {
    int totalProblemsSolvedByAsha = numberOfProblemsAshaIsAheadOfKelly;
    int totalProblemsSolvedByKelly = 0;
    int numberOfDays = 0;

    if (numberOfProblemsKellySolvesPerDay < numberOfProblemsAshaSolvesPerDay)
      return -1;

    while (totalProblemsSolvedByKelly <= totalProblemsSolvedByAsha) {
      totalProblemsSolvedByAsha += numberOfProblemsAshaSolvesPerDay;
      totalProblemsSolvedByKelly += numberOfProblemsKellySolvesPerDay;
      numberOfDays++;
    }
    return numberOfDays;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int numberOfProblemsAshaSolvesPerDay = Integer.parseInt(br.readLine());
    int numberOfProblemsKellySolvesPerDay = Integer.parseInt(br.readLine());
    int numberOfProblemsAshaIsAheadOfKelly = Integer.parseInt(br.readLine());

    System.out.println(minNum(numberOfProblemsAshaSolvesPerDay, numberOfProblemsKellySolvesPerDay,
        numberOfProblemsAshaIsAheadOfKelly));

    br.close();
  }
}

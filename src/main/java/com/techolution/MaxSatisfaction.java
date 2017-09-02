package main.java.com.techolution;

public class MaxSatisfaction {

  public int maxSatisfactionWithRepeatingItems(int totalItems, int totalTime, int[] itemEatingTimes, int[] itemSatisfactions) {
    int maxSatisfaction[] = new int[totalTime+1];

    for (int t = 0; t <= totalTime; t++) {
      for (int i = 0; i < totalItems; i++) {
        if (itemEatingTimes[i] <= t) {
          maxSatisfaction[t] = Math.max(maxSatisfaction[t], itemSatisfactions[i] + maxSatisfaction[t - itemEatingTimes[i]]);
        }
      }
    }
    return maxSatisfaction[totalTime];
  }

  public int maxSatisfactionWithoutRepeatingItems(int totalItems, int totalTime, int[] itemEatingTimes, int[] itemSatisfactions) {
    int maxSatisfaction[][] = new int[totalItems + 1][totalTime + 1];

    for (int i = 0; i <= totalItems; i++) {
      for (int t = 0; t <= totalTime; t++) {
        if (i == 0 || t == 0) {
          maxSatisfaction[i][t] = 0;
        } else if (itemEatingTimes[i - 1] > t) {
          maxSatisfaction[i][t] = maxSatisfaction[i - 1][t];
        } else {
          maxSatisfaction[i][t] = Math.max(maxSatisfaction[i - 1][t - itemEatingTimes[i - 1]] + itemSatisfactions[i - 1],
              maxSatisfaction[i - 1][t]);
        }
      }
    }
    return maxSatisfaction[totalItems][totalTime];
  }
}

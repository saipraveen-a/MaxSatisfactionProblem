package main.java.com.techolution;

import java.io.*;

public class MaxSatisfactionCalculator {
  private int totalTime;
  private int totalItems;
  private int[] itemEatingTimes;
  private int[] itemSatisfactions;

  public void readFileAndInitialize(String fileName) {
    String line = null;
    int index = 0;

    try {
      InputStream is = this.getClass().getResourceAsStream(fileName);
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

      line = bufferedReader.readLine();
      String[] values = line.split(" +");
      totalTime = Integer.parseInt(values[0]);
      totalItems = Integer.parseInt(values[1]);
      itemEatingTimes = new int[totalItems];
      itemSatisfactions = new int[totalItems];

      while ((line = bufferedReader.readLine()) != null) {
        values = line.split(" +");
        itemSatisfactions[index] = Integer.parseInt(values[0]);
        itemEatingTimes[index] = Integer.parseInt(values[1]);
        index++;
      }
      bufferedReader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    String fileName = "data.txt";
    MaxSatisfactionCalculator maxSatisfactionCalculator = new MaxSatisfactionCalculator();
    maxSatisfactionCalculator.readFileAndInitialize(fileName);

    MaxSatisfaction maxSatisfaction = new MaxSatisfaction();
    int maxSatisfactionWithRepeatingItems = maxSatisfaction.maxSatisfactionWithRepeatingItems(
        maxSatisfactionCalculator.totalItems,
        maxSatisfactionCalculator.totalTime, maxSatisfactionCalculator.itemEatingTimes,
        maxSatisfactionCalculator.itemSatisfactions);
    int maxSatisfactionWithOutRepeatingItems = maxSatisfaction.maxSatisfactionWithoutRepeatingItems(
        maxSatisfactionCalculator.totalItems,
        maxSatisfactionCalculator.totalTime, maxSatisfactionCalculator.itemEatingTimes,
        maxSatisfactionCalculator.itemSatisfactions);
    System.out.println("Max Satisfaction when items can be repeated: " + maxSatisfactionWithRepeatingItems);
    System.out.println("Max Satisfaction when items cannot be repeated: " + maxSatisfactionWithOutRepeatingItems);
  }
}

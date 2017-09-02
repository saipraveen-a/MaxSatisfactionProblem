package test.java.com.techolution;

import main.java.com.techolution.MaxSatisfaction;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MaxSatisfactionTest {
  private MaxSatisfaction maxSatisfaction = new MaxSatisfaction();

  @Test
  public void testMaxSatisfactionWithRepeatingItems_whenTotalTimeIsZero() {
    int[] itemEatingTimes = {10, 20, 5, 8, 12, 3, 9, 16, 35, 26};
    int[] itemSatisfactions = {100, 500, 1000, 50, 25, 75, 200, 175, 150, 225};
    assertThat(maxSatisfaction.maxSatisfactionWithRepeatingItems(10, 0, itemEatingTimes, itemSatisfactions), is(0));
  }

  @Test
  public void testMaxSatisfactionWithRepeatingItems_whenTotalItemsIsZero() {
    int[] itemEatingTimes = {10, 20, 5, 8, 12, 3, 9, 16, 35, 26};
    int[] itemSatisfactions = {100, 500, 1000, 50, 25, 75, 200, 175, 150, 225};
    assertThat(maxSatisfaction.maxSatisfactionWithRepeatingItems(0, 10, itemEatingTimes, itemSatisfactions), is(0));
  }

  @Test
  public void testMaxSatisfactionWithRepeatingItems() {
    int[] itemEatingTimes = {10, 20, 5, 8, 12, 3, 9, 16, 35, 26};
    int[] itemSatisfactions = {100, 500, 1000, 50, 25, 75, 200, 175, 150, 225};
    assertThat(maxSatisfaction.maxSatisfactionWithRepeatingItems(10, 100, itemEatingTimes, itemSatisfactions), is(20000));
  }

  @Test
  public void testMaxSatisfactionWithRepeatingItems1() {
    int[] itemEatingTimes = {10, 20, 5, 8, 12, 3, 9, 16, 35, 26};
    int[] itemSatisfactions = {100, 500, 1000, 50, 25, 75, 200, 175, 150, 225};
    assertThat(maxSatisfaction.maxSatisfactionWithRepeatingItems(10, 104, itemEatingTimes, itemSatisfactions), is(20075));
  }

  @Test
  public void testMaxSatisfactionWithoutRepeatingItems_whenTotalTimeIsZero() {
    int[] itemEatingTimes = {10, 20, 5, 8, 12, 3, 9, 16, 35, 26};
    int[] itemSatisfactions = {100, 500, 1000, 50, 25, 75, 200, 175, 150, 225};
    assertThat(maxSatisfaction.maxSatisfactionWithoutRepeatingItems(10, 0, itemEatingTimes, itemSatisfactions), is(0));
  }

  @Test
  public void testMaxSatisfactionWithoutRepeatingItems_whenTotalItemsIsZero() {
    int[] itemEatingTimes = {10, 20, 5, 8, 12, 3, 9, 16, 35, 26};
    int[] itemSatisfactions = {100, 500, 1000, 50, 25, 75, 200, 175, 150, 225};
    assertThat(maxSatisfaction.maxSatisfactionWithoutRepeatingItems(0, 10, itemEatingTimes, itemSatisfactions), is(0));
  }

  @Test
  public void testMaxSatisfactionWithoutRepeatingItems() {
    int[] itemEatingTimes = {10, 20, 5, 8, 12, 3, 9, 16, 35, 26};
    int[] itemSatisfactions = {100, 500, 1000, 50, 25, 75, 200, 175, 150, 225};
    assertThat(maxSatisfaction.maxSatisfactionWithoutRepeatingItems(10, 100, itemEatingTimes, itemSatisfactions), is(2325));
  }

  @Test
  public void testMaxSatisfactionWithoutRepeatingItems1() {
    int[] itemEatingTimes = {10, 20, 5, 8, 12, 3, 9, 16, 35, 26};
    int[] itemSatisfactions = {100, 500, 1000, 50, 25, 75, 200, 175, 150, 225};
    assertThat(maxSatisfaction.maxSatisfactionWithoutRepeatingItems(10, 95, itemEatingTimes, itemSatisfactions), is(2275));
  }
}

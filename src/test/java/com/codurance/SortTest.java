package com.codurance;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortTest {
  private List<Integer> unsorted;
  private QuickSort quickSort;
  private int left;
  private int right;

  @BeforeEach
  void setUp() {
    unsorted = Arrays.asList(5,7,3,9,2,10,6,8,1,4);
    quickSort = new QuickSort();
    left = 0;
    right = unsorted.size() - 1;
  }

  @Test
  public void shouldReturnCollectionInAscendingNumericOrder() {
    System.out.println("Original unsorted list: " + unsorted);
    List<Integer> sorted = quickSort.sort(unsorted, left, right);

    List<Integer> expected = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    assertThat(sorted, is(expected));
    System.out.println("Sorted list: " + sorted);
  }
}

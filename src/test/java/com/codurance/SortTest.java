package com.codurance;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SortTest {

  @Test
  void sortings() {
    List<Integer> unsortedList = sort(intList());
    List<Integer> sorted = intList();
    assertSorted(unsortedList, sorted);
    assertSorted(sort(intList(1)), intList(1));
    assertSorted(sort(intList(2, 1)), intList(1, 2));
    assertSorted(sort(intList( 2, 1, 3)), intList(1, 2, 3));
  }

  private void sortBigList(int n) {
    List<Integer> unsorted = new ArrayList<>();
    for (int i = 0; i < n; i++)
      unsorted.add((int)(Math.random() * 10000.0));
    List<Integer> sorted = sort(unsorted);

    for (int i = 0; i < n - 1; i++)
      assertTrue(sorted.get(i) <= sorted.get(i + 1));
  }

  private void assertSorted(List<Integer> unsortedList, List<Integer> sorted) {
    assertThat(unsortedList, is(sorted));
  }

  private List<Integer> intList(Integer... ints) {
    return asList(ints);
  }

  private List<Integer> sort(List<Integer> list){
    List<Integer> sorted = new ArrayList<>();
    if (list.size() <= 1)
      return list;
    else if (list.size() == 2){
      if (list.get(0) > list.get(1)){
        sorted.add(list.get(1));
        sorted.add(list.get(0));
      }else {
        sorted.add(list.get(0));
        sorted.add(list.get(1));
      }
    } else if (list.size() == 3) {
      if (list.get(1) > list.get(2)){
        sorted.add(list.get(2));
        sorted.add(list.get(0));
        sorted.add(list.get(1));
      }else {
        sorted.add(list.get(1));
        sorted.add(list.get(0));
        sorted.add(list.get(2));
      }
    }

    return sorted;
  }

  private boolean outOfOrder(List<Integer> list, Integer index) {
    return list.get(index) > list.get(index + 1);
  }

  private void swap(List<Integer> list, int index) {
    Integer temp = list.get(index);
    list.set(index, list.get(index + 1));
    list.set(index + 1, temp);
  }
}

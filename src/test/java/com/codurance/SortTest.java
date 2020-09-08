package com.codurance;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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
    assertSorted(sort(intList(1, 3, 2)), intList(1, 2, 3));
  }

  private void assertSorted(List<Integer> unsortedList, List<Integer> sorted) {
    assertThat(unsortedList, is(sorted));
  }

  private List<Integer> intList(Integer... ints) {
    return asList(ints);
  }

  private List<Integer> sort(List<Integer> list){
    if(list.size() > 1) {
      if (list.get(0) > list.get(1)) {
        Integer temp = list.get(0);
        list.set(0, list.get(1));
        list.set(1, temp);
      }
      if (list.size() > 2){
        if (list.get(1) > list.get(2)) {
          Integer temp = list.get(1);
          list.set(1, list.get(2));
          list.set(2, temp);
        }
      }
    }
    return list;
  }
}

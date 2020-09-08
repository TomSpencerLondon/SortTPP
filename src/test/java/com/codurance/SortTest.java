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
    int index = 0;
    while(list.size() > index + 1) {
      if (list.get(index) > list.get(index + 1)) {
        Integer temp = list.get(index);
        list.set(index, list.get(index + 1));
        list.set(index + 1, temp);
      }
      index++;
    }
    return list;
  }
}

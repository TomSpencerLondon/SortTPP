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
    assertThat(sort(intList()), is(intList()));
  }

  private List<Integer> intList() {
    return asList();
  }

  private List<Integer> sort(List<Integer> list){
    return new ArrayList<>();
  }
}

package com.eddy.unittesting.spike;


import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;


import org.junit.Test;

public class HamcrestMatcherTest {

	@Test
	public void learning() {
		List<Integer> numbers = Arrays.asList(10,12,13,19);
		assertThat(numbers,hasSize(4));
		assertThat(numbers,hasItems(12,10));
		assertThat(numbers,everyItem(greaterThan(9)));
		
		assertThat("",isEmptyString());
		assertThat("ABCD",containsString("CD"));
		assertThat("ABCDE",startsWith("ABC"));
	}
}

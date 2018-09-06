package com.eddy.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AssertJTest {

	@Test
	public void learning() {
		List<Integer> numbers = Arrays.asList(10,12,13,19);
		/*assertThat(numbers,hasSize(4));
		assertThat(numbers,hasItems(12,10));
		assertThat(numbers,everyItem(greaterThan(9)));
		
		assertThat("",isEmptyString());
		assertThat("ABCD",containsString("CD"));
		assertThat("ABCDE",startsWith("ABC"));*/
		
		assertThat(numbers)
			.hasSize(4)
			.contains(12,10)
			.allMatch(x -> x > 9);
		
		assertThat("").isEmpty();
		
		assertThat("ABCDE").contains("CD")
				.startsWith("ABC");
		
	}
}

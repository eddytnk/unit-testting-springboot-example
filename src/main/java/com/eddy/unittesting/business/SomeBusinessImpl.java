package com.eddy.unittesting.business;

import java.util.Arrays;
import java.util.stream.IntStream;

import com.eddy.unittesting.services.SomeDataService;

public class SomeBusinessImpl {

	SomeDataService someDataService;
	
	public int calculateSum(int[] data) {
		return IntStream.of(data).sum();
	}
	
	public int calculateSumUsingDataService() {
		return IntStream.of(someDataService.retrieveAllData()).sum();
	}
}

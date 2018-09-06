package com.eddy.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.eddy.unittesting.services.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessImplTest {

	@Mock
	private SomeDataService someDataService;
	
	@InjectMocks
	private SomeBusinessImpl someBusinessImpl;
	
	@Test
	public void calculateSumUsingDataService_basicTest() {
		when(someDataService.retrieveAllData()).thenReturn(new int[] {1,2,3});
		assertEquals(6, someBusinessImpl.calculateSumUsingDataService());
	}
}

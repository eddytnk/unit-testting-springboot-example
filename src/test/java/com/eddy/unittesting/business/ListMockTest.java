package com.eddy.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ListMockTest {
	
	@Mock
	List<String> list; //List list = mock(List.class);
	
	@Test
	public void size_basic() {
		when(list.size()).thenReturn(5);
		assertEquals(5, list.size());
	}
	@Test
	public void size_basic_multipleReturns() {
		when(list.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, list.size());
		assertEquals(10, list.size());
	}

	@Test
	public void returnWithParameters() {
		when(list.get(0)).thenReturn("hello");
		assertEquals("hello", list.get(0));
	}
	
	@Test
	public void returnWithGenericParameters() {
		when(list.get(anyInt())).thenReturn("hello");
		assertEquals("hello", list.get(0));
	}
	
	@Test
	public void verification_basic_test() {
		String value = list.get(0);
		//verify that the get(0) method is called on list obj
		verify(list).get(0);
		
		//verify that the get() method is called on list obj
		verify(list).get(anyInt());
		
		//verify that the get() method is called on list obj 1 time
		verify(list,times(1)).get(anyInt());
		
		//verify that the get() method is called on list obj atleast 1
		verify(list,atLeast(1)).get(anyInt());
	}
	
	@Test
	public void argumentCapturing() {
		list.add("someText");
		
		//Verification that add() method was call and capture the argument passed to the add() method
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(list).add(captor.capture());
		
		assertEquals("someText", captor.getValue());
		
	}
	
	@Test
	public void multipleArgumentCapturing() {
		list.add("someText1");
		list.add("someText2");
		
		//Verification that add() method was call and capture the argument passed to the add() method
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(list,times(2)).add(captor.capture());
		
		List<String> allValues = captor.getAllValues();
		assertEquals("someText1", allValues.get(0));
		assertEquals("someText2", allValues.get(1));
		
	}
	
	
	
	
	
	
	
	
}

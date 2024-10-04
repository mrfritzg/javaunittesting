package com.springpractice.unittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {
    List<String> mockList = mock(List.class);

    @Test
    public void testListSize() {
        when(mockList.size()).thenReturn(5);
        assertEquals(5,mockList.size());
    }

    @Test
    public void testListDiffSize() {
        when(mockList.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mockList.size());
        assertEquals(10,mockList.size());
    }

    @Test
    public void testReturnListWithParameters() {
        when(mockList.get(0)).thenReturn("in28Mins");
        assertEquals("in28Mins", mockList.get(0));
        assertEquals(null, mockList.get(1));
    }

    @Test
    public void testReturnListWithGenericParameters() {
        when(mockList.get(anyInt())).thenReturn("in28Mins");
        assertEquals("in28Mins", mockList.get(0));
        assertEquals("in28Mins", mockList.get(1));
    }

    @Test
    public void verificationBasics() {
        //SUT - System Under Test
        String value1 = mockList.get(0);
        String value2 = mockList.get(1);

        //Verify
        verify(mockList).get(0);
        verify(mockList, times(2)).get(anyInt());
        verify(mockList, atLeast(1)).get(anyInt());
        verify(mockList, atLeastOnce()).get(anyInt());
        verify(mockList, atMost(2)).get(anyInt());
        verify(mockList, never()).get(2);
    }

    @Test
    public void argumentCapturing() {
        //SUT
        mockList.add("Something");

        //Verify
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockList).add(captor.capture());

        assertEquals("Something", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {
        //SUT
        mockList.add("Something0");
        mockList.add("Something1");

        //Verify
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockList,atLeast(1)).add(captor.capture());

        List<String> allValues = captor.getAllValues();

        assertEquals("Something0", allValues.get(0));
        assertEquals("Something1", allValues.get(1));
    }

    @Test
    public void mocking() {
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0));
        System.out.println(arrayListMock.size());
        arrayListMock.add("Test");
        arrayListMock.add("Test2");
        System.out.println(arrayListMock.size());
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());
    }

    @Test
    public void spying() {
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test0");
        System.out.println(arrayListSpy.get(0));

        System.out.println(arrayListSpy.size());
        arrayListSpy.add("Test");
        arrayListSpy.add("Test2");
        System.out.println(arrayListSpy.size());
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size());
    }
}

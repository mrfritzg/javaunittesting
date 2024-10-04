package com.springpractice.unittesting.business;

import com.springpractice.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockTest {

    @InjectMocks
    SomeBusinessImpl business;

    @Mock
    SomeDataService dataServiceMock;

    @Test
    public void TestCalculateSumUsingDataService_basic(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void TestCalculateSumUsingDataService_emptyArray(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        int actualResult = business.calculateSumUsingDataService(); //new int[] {};
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void TestCalculateSum_oneValue(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
        int actualResult = business.calculateSumUsingDataService();//new int[] {5}
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

}
package com.springpractice.unittesting.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessImplTest {

    @Test
    public void TestCalculateSum(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {1,2,3});
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void TestCalculateSum_emptyArray(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {});
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void TestCalculateSum_oneValue(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {5});
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

}
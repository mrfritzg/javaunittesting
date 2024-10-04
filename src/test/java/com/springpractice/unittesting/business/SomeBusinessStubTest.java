package com.springpractice.unittesting.business;

import com.springpractice.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {1,2,3};
    }
}

class SomeDataServiceStubEmptyArray implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {};
    }
}

class SomeDataServiceStubOneValue implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {5};
    }
}

public class SomeBusinessStubTest {

    @Test
    public void TestCalculateSumUsingDataService_basic(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void TestCalculateSumUsingDataService_emptyArray(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStubEmptyArray());
        int actualResult = business.calculateSumUsingDataService(); //new int[] {};
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void TestCalculateSum_oneValue(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStubOneValue());
        int actualResult = business.calculateSumUsingDataService();//new int[] {5}
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

}
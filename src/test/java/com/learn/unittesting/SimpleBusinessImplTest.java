package com.learn.unittesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBusinessImplTest {
    @Test
    public void calculateSum_basic() {
        SimpleBusinessImpl business = new SimpleBusinessImpl();
        int actualResult = business.calculateSum(new int[] {1, 2, 3});
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

}
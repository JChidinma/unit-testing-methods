package com.learn.unittesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockTest {
    @InjectMocks
    SimpleBusinessImpl business;
    @Mock
    SomeDataService dataServiceMock;
    //dataServiceMock

    @Test
    public void calculateSumUsingDataService_basic() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1, 2, 3, 4});
        assertEquals(10, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(0, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_one() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
        assertEquals(5, business.calculateSumUsingDataService());
    }




//    SimpleBusinessImpl business = new SimpleBusinessImpl();
//    SomeDataService dataServiceMock = mock(SomeDataService.class);
//    //dataServiceMock
//
//    @BeforeEach
//    public void initEach() {
//        business.setSomeDataService(dataServiceMock);
//    }
//    @Test
//    public void calculateSumUsingDataService_basic() {
//        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1, 2, 3, 4});
//        assertEquals(11, business.calculateSumUsingDataService());
//    }
//
//    @Test
//    public void calculateSumUsingDataService_empty() {
//        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
//        assertEquals(0, business.calculateSumUsingDataService());
//    }
//
//    @Test
//    public void calculateSumUsingDataService_one() {
//        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
//        assertEquals(5, business.calculateSumUsingDataService());
//    }
}
//

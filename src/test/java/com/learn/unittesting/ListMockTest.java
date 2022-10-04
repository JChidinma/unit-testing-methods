package com.learn.unittesting;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {
    List mock = mock(List.class);

    @Test
    public void size_basic() {
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("learning unit testing");
        assertEquals("learning unit testing", mock.get(0));
        assertEquals("learning unit testing", mock.get(1));

    }

    @Test
    public void verificationBasics() {
        //SUT
        String value1 = (String) mock.get(0);
        String value2 = (String) mock.get(1);

        //Verify
        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void argumentCapturing() {
        //SUT
        mock.add("Some Strings");

        //Verification - capture the arguments that are passed to specific method calls on a mock
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("Some Strings", captor.getValue());

    }

    @Test
    public void multipleArgumentCapturing() {
        //SUT
        mock.add("Some Strings1");
        mock.add("Some Strings2");
        //Verification - capture the arguments that are passed to specific method calls on a mock
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();

        assertEquals("Some Strings1", allValues.get(0));
        assertEquals("Some Strings2", allValues.get(1));

    }

    @Test

    //in mocks, the entire behavior of a class gets lost. With spy we are looking into the main class
    public void spying() {
        ArrayList arrayListMock = mock(ArrayList.class);


    }
}
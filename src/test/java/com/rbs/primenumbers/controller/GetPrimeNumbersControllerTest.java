package com.rbs.primenumbers.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.rbs.primenumbers.service.GetPrimeNumberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;



@SpringBootTest
class GetPrimeNumbersControllerTest {

    @InjectMocks
    private GetPrimeNumbersController getPrimeNumbersController;
    @Mock
    private GetPrimeNumberService getPrimeNumberService;

    @Test
    void testValidInput() {
        List<Integer> primeNumbers = new ArrayList<>();
        primeNumbers.add(2);
        Mockito.when(getPrimeNumberService.getPrimeNumbers(2)).thenReturn(primeNumbers);
        List<Integer> primeNumbersInResponse = getPrimeNumbersController.getPrimeNumbers("2");
        Assertions.assertNotNull(primeNumbersInResponse);
        Assertions.assertEquals(primeNumbers, primeNumbersInResponse);
    }

    @Test
    void testInValidInput() {

        ResponseStatusException thrown = assertThrows(
                ResponseStatusException.class,
                () -> getPrimeNumbersController.getPrimeNumbers("abc"),
                "Expected getPrimeNumbers() to throw exception, but it didn't"
        );

        assertTrue(thrown.getReason().equalsIgnoreCase("Input should be a valid number and less than 10000"));
    }

    @Test
    void testUpperLimitInput() {

        ResponseStatusException thrown = assertThrows(
                ResponseStatusException.class,
                () -> getPrimeNumbersController.getPrimeNumbers("10001"),
                "Expected getPrimeNumbers() to throw exception, but it didn't"
        );

        assertTrue(thrown.getReason().equalsIgnoreCase("Input should be a valid number and less than 10000"));
    }

}

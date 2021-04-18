package com.rbs.primenumbers.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GetPrimeNumberServiceTest {
    @InjectMocks
    private GetPrimeNumberService getPrimeNumberService;

    @Test
    void testGetPrimeNumbers() {
        List<Integer> primeNumbersInResponse = getPrimeNumberService.getPrimeNumbers(5);
        Assertions.assertNotNull(primeNumbersInResponse);
        Assertions.assertEquals(3, primeNumbersInResponse.size());
    }
}

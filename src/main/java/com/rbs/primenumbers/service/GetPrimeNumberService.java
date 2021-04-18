package com.rbs.primenumbers.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetPrimeNumberService {

    public List<Integer> getPrimeNumbers(Integer input) {
        List<Integer> primeNumbers = new ArrayList<>();
        if (input >= 2) {
            primeNumbers.add(2);
            for (int i = 3; i <= input; i++) {
                if (isPrime(i)) {
                    primeNumbers.add(i);
                }
            }
        }
        return primeNumbers;
    }


    /**
     * Checks whether a given number is prime or not.
     *
     * @param number
     * @return true if prime else false
     */
    private boolean isPrime(int number) {
        //check if n is a multiple of 2
        if (number % 2 == 0) {
            return false;
        }
        //if not, then traverse odd numbers up to the square root of n
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}

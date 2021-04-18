package com.rbs.primenumbers.controller;

import com.rbs.primenumbers.service.GetPrimeNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/primenumbers/{input}")
public class GetPrimeNumbersController {

    @Autowired
    private GetPrimeNumberService getPrimeNumberService;

    @GetMapping
    public List<Integer> getPrimeNumbers(@PathVariable final String input) {
        Integer validInputNumber = validateInputNumber(input);
        return getPrimeNumberService.getPrimeNumbers(validInputNumber);
    }

    /**
     * Validates input number.
     *
     * @param input provided by the caller
     * @return valid input number
     */
    private Integer validateInputNumber(String input) {
        Integer inputNumber = null;
        try {
            inputNumber = Integer.valueOf(input);
            if (inputNumber > 10000) { //number should not be greater than upper limit
                throwBadRequestException();
            }

        } catch (NumberFormatException ex) {
            throwBadRequestException();
        }
        return inputNumber;
    }

    /**
     * Throws BAD_REQUEST exception.
     */
    private void throwBadRequestException() {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "Input should be a valid number and less than 10000");
    }

}

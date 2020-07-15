package com.udacity.jdnd.course1.service;

public class FizzBuzzService {

    /**
     * If number is divisible by 3, return "Fizz". If divisible by 5,
     * return "Buzz", and if divisible by both, return "FizzBuzz". Otherwise,
     * return the number itself.
     *
     * @Throws IllegalArgumentException for values < 1
     */
    public String fizzBuzz(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Value must be greater than 0");
        }
        int flag = 0;
        if (number % 3 == 0) {
            flag = 1;
        }
        if (number % 5 == 0) {
            flag = flag | 0x10;
        }
        if (flag == 0x11) {
            return "FizzBuzz";
        } else if (flag == 0x10) {
            return "Buzz";
        } else if (flag == 0x1) {
            return "Fizz";
        }
        return "" + number;
    }
}

package com.example.annotation.advancelevel.customcaching;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ExpensiveComputation {

    private static final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeSquare(int number) {
        if (cache.containsKey(number)) {
            System.out.println("Returning cached result for: " + number);
            return cache.get(number);
        }

        System.out.println("Computing square of: " + number);
        int result = number * number;
        cache.put(number, result);
        return result;
    }

    public static void main(String[] args) {
        ExpensiveComputation obj = new ExpensiveComputation();

        // First call - computation happens
        System.out.println("Result: " + obj.computeSquare(5));

        // Second call - should return cached result
        System.out.println("Result: " + obj.computeSquare(5));

        // Another computation
        System.out.println("Result: " + obj.computeSquare(7));

        // Checking cache again
        System.out.println("Result: " + obj.computeSquare(7));
    }
}

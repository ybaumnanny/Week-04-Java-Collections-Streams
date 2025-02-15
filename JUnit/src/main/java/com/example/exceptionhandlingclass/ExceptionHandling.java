package com.exceptionhandlingclass;

public class ExceptionHandling {
    // Method to divide two integers
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }
}

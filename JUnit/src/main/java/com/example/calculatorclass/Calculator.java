package com.calculatorclass;

public class Calculator {
        public static int add(int a, int b) {
            return a + b;
        }

        public static int subtract(int a, int b) {
            return a - b;
        }

        public static int multiply(int a, int b) {
            return a * b;
        }

        public static int divide(int a, int b) {
            if (b == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            return a / b;
        }
//        public static void main(String[]args){
//            Calculator.add(5,6);
//            Calculator.subtract(10,9);
//            Calculator.multiply(10,5);
//            Calculator.divide(63,9);
//    }
}



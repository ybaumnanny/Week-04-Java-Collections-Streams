package com.example.reflection.invokeprivatemethod;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator();

            for(Method method:calculator.getClass().getDeclaredMethods()){
                if(method.getName().equals("multiply")){
                    method.setAccessible(true);
                    int result = (int) method.invoke(calculator,5,3);
                    System.out.println("The result is : "+result);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

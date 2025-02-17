package com.example.reflection.dynamicmethodinvocation;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        int a =10,b=5;
        System.out.println("add" + "(" + a + ", " + b + ") = " + invokeMethod("add",a,b));
        System.out.println("subtract" + "(" + a + ", " + b + ") = " + invokeMethod("subtract",a,b));
        System.out.println("multiply" + "(" + a + ", " + b + ") = " + invokeMethod("multiply",a,b));
    }

    public static int invokeMethod(String methodName, int a, int b) {
        try {
            Class<?> cls = Class.forName("com.example.reflection.dynamicmethodinvocation.MathOperations");
            Object instance = cls.getDeclaredConstructor().newInstance();

            Method method = cls.getMethod(methodName, int.class, int.class);

            return (int) method.invoke(instance, a, b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
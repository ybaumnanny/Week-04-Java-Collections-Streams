package com.example.annotation.intermediatelevel.loggingmethod;

import java.lang.reflect.Method;

public class ExecutionLogger {

    @LogExecutionTime
    public void fastMethod() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
        }
        System.out.println("Fast method executed.");
    }

    @LogExecutionTime
    public void slowMethod() {
        try {
            Thread.sleep(500); // Simulating a slow process
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Slow method executed.");
    }

    public static void measureExecutionTime(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(obj);
                long endTime = System.nanoTime();
                System.out.println("Execution time of " + methodName + ": " + (endTime - startTime) / 1_000_000.0 + " ms\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutionLogger obj = new ExecutionLogger();
        measureExecutionTime(obj, "fastMethod");
        measureExecutionTime(obj, "slowMethod");
    }
}

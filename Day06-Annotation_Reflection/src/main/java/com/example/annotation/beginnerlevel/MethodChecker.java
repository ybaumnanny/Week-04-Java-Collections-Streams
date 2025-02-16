package com.example.annotation.beginnerlevel;

import java.lang.reflect.Method;

public class MethodChecker {

    @ImportantMethod(level = "MEDIUM")
    public void methodOne() {
        System.out.println("Executing Method One");
    }

    @ImportantMethod
    public void methodTwo() {
        System.out.println("Executing Method Two");
    }

    public void normalMethod() {
        System.out.println("Executing Normal Method");
    }

    public static void printImportantMethods(Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Important Method: " + method.getName() + ", Level: " + annotation.level());
            }
        }
    }

    public static void main(String[] args) {
        MethodChecker obj = new MethodChecker();
        obj.methodOne();
        obj.methodTwo();
        obj.normalMethod();

        System.out.println("\nAnnotated Methods:");
        printImportantMethods(MethodChecker.class);
    }
}

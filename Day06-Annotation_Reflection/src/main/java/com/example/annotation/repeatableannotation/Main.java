package com.example.annotation.repeatableannotation;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        displayBugReports(SoftwareComponent.class);
    }

    public static void displayBugReports(Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BugReports.class)) {
                BugReports bugReports = method.getAnnotation(BugReports.class);
                System.out.println("Method: " + method.getName());
                for (BugReport bug : bugReports.value()) {
                    System.out.println("Bug Description: " + bug.description());
                    System.out.println("Reported By: " + bug.reportedBy());
                    System.out.println("----------------------");
                }
            }
        }
    }
}

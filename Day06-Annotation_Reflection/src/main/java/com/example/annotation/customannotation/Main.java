
package com.example.annotation.customannotation;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        displayTaskInfo(TaskManager.class);
    }

    public static void displayTaskInfo(Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }
        }
    }
}


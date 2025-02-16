package com.example.annotation.beginnerlevel;

import java.lang.reflect.Method;

public class TaskManager {

    @Todo(task = "Implement user authentication", assignedTo = "Alice", priority = "HIGH")
    public void userAuth() {
        System.out.println("User authentication method (pending)");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDB() {
        System.out.println("Database optimization method (pending)");
    }

    @Todo(task = "Enhance UI responsiveness", assignedTo = "Charlie", priority = "LOW")
    public void enhanceUI() {
        System.out.println("UI enhancement method (pending)");
    }

    public static void printPendingTasks(Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo annotation = method.getAnnotation(Todo.class);
                System.out.println("Pending Task: " + annotation.task());
                System.out.println("Assigned To: " + annotation.assignedTo());
                System.out.println("Priority: " + annotation.priority());
                System.out.println("Method: " + method.getName() + "\n");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Pending Tasks in the Project:");
        printPendingTasks(TaskManager.class);
    }
}

package com.example.annotation.customannotation;

public class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Ankit kumar")
    public void criticalTask() {
        System.out.println("Executing a critical task...");
    }
}

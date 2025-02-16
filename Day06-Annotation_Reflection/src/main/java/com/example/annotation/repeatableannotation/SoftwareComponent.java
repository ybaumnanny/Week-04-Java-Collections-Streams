package com.example.annotation.repeatableannotation;

public class SoftwareComponent {

    @BugReport(description = "Null pointer exception in processData", reportedBy = "Ankit")
    @BugReport(description = "Performance issue in data processing", reportedBy = "Aakrati")
    public void processData() {
        System.out.println("Processing data...");
    }
}

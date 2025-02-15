package com.timeoutclass;

public class TimeOut {
    public static String longRunningTask() {
        try {
            // Sleep for 3 seconds (3000 milliseconds)
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Interrupted";
        }
        return "Finished";
    }
}

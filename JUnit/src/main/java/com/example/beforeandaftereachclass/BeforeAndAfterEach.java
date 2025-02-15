package com.beforeandaftereachclass;

public class BeforeAndAfterEach {
    private boolean connected = false;

    // Simulates establishing a connection
    public void connect() {
        connected = true;
        System.out.println("Connected to the database.");
    }

    // Simulates closing the connection
    public void disconnect() {
        connected = false;
        System.out.println("Disconnected from the database.");
    }

    // Helper method to check connection status
    public boolean isConnected() {
        return connected;
    }
}


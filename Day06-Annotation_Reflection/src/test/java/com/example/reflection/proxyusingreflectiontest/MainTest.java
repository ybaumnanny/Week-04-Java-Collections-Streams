package com.example.reflection.proxyusingreflectiontest;
import com.example.reflection.proxyusingreflection.Greeting;
import com.example.reflection.proxyusingreflection.GreetingImpl;
import com.example.reflection.proxyusingreflection.Main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testProxyLogging() {
        Greeting greeting = Main.createLoggingProxy(new GreetingImpl());
        String response = greeting.sayHello("Bob");

        assertEquals("Hello, Bob!", response);
    }
}

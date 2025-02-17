package com.example.reflection.proxyusingreflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Greeting greeting = createLoggingProxy(new GreetingImpl());
        System.out.println(greeting.sayHello("Ankit"));
    }

    public static Greeting createLoggingProxy(Greeting target) {
        return (Greeting) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                new Class[]{Greeting.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("Method called: " + method.getName());
                        return method.invoke(target, args);
                    }
                }
        );
    }
}

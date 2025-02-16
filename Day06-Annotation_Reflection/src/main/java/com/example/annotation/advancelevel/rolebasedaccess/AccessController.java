package com.example.annotation.advancelevel.rolebasedaccess;

import java.lang.reflect.Method;

public class AccessController {

    private String userRole;

    public AccessController(String userRole) {
        this.userRole = userRole;
    }

    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed.");
    }

    @RoleAllowed("USER")
    public void userTask() {
        System.out.println("User task executed.");
    }

    public void executeMethod(String methodName) {
        try {
            Method method = this.getClass().getMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                String requiredRole = method.getAnnotation(RoleAllowed.class).value();
                if (!requiredRole.equals(userRole)) {
                    System.out.println("Access Denied! Required role: " + requiredRole + ", Your role: " + userRole);
                    return;
                }
            }
            method.invoke(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AccessController adminUser = new AccessController("ADMIN");
        AccessController normalUser = new AccessController("USER");

        System.out.println("Admin trying to execute adminTask:");
        adminUser.executeMethod("adminTask"); // Allowed

        System.out.println("\nUser trying to execute adminTask:");
        normalUser.executeMethod("adminTask"); // Denied

        System.out.println("\nUser trying to execute userTask:");
        normalUser.executeMethod("userTask"); // Allowed
    }
}

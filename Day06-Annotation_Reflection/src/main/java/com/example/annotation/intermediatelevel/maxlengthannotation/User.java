
package com.example.annotation.intermediatelevel.maxlengthannotation;

import java.lang.reflect.Field;

public class User {

    @MaxLength(10)
    private String username;

    public User(String username) {
        validateMaxLength(username);
        this.username = username;
    }

    private void validateMaxLength(String username) {

    }

    public String getUsername() {
        return username;
    }

    public static void main(String[] args) {
        try {
            User validUser = new User("Ankit kumar");
            System.out.println("Valid user created: " + validUser.getUsername());

            User invalidUser = new User("ThisUsernameIsTooLong");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public String getDetails() {
        return "Username: " + username;
    }
}


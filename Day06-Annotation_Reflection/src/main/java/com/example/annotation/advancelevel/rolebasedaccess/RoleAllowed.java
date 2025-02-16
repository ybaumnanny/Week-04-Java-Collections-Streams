package com.example.annotation.advancelevel.rolebasedaccess;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RoleAllowed {
    String value();
}

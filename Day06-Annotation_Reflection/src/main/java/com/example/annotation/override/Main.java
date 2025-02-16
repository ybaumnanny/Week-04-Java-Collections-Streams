package com.example.annotation.override;

import com.example.annotation.override.Animal;
import com.example.annotation.override.Dog;

public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound();
    }
}

package com.example.reflection.getclassinformation;

public class SampleClass {
    private int id;
    public String name;

    public SampleClass() {}

    public SampleClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void display() {
        System.out.println("Display method called");
    }

    private void secretMethod() {
        System.out.println("Secret method");
    }
}
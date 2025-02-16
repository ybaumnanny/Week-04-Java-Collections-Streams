package com.example.annotation.supress;

import java.util.ArrayList;
import java.util.List;

public class UncheckedWarningExample {

    @SuppressWarnings("unchecked")
    public void addElements() {
        List rawList = new ArrayList();
        rawList.add("Hello");
        rawList.add(123);

        for (Object obj : rawList) {
            System.out.println(obj);
        }
    }
}

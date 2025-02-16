package com.example.annotation.deprecated;

public class LegacyAPI {

    @Deprecated
    public void oldFeature() {
        System.out.println("This is an old feature and should not be used.");
    }

    public void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}

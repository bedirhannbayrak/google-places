package com.bedirhan.google.places.api.model;

import java.io.IOException;

public enum Scope {
    GOOGLE;

    public String toValue() {
        switch (this) {
            case GOOGLE: return "GOOGLE";
        }
        return null;
    }

    public static Scope forValue(String value) throws IOException {
        if (value.equals("GOOGLE")) return GOOGLE;
        throw new IOException("Cannot deserialize Scope");
    }
}
package com.bedirhan.google.places.api.model;

import java.io.IOException;

public enum BusinessStatus {
    CLOSED_TEMPORARILY, OPERATIONAL;

    public String toValue() {
        switch (this) {
            case CLOSED_TEMPORARILY: return "CLOSED_TEMPORARILY";
            case OPERATIONAL: return "OPERATIONAL";
        }
        return null;
    }

    public static BusinessStatus forValue(String value) throws IOException {
        if (value.equals("CLOSED_TEMPORARILY")) return CLOSED_TEMPORARILY;
        if (value.equals("OPERATIONAL")) return OPERATIONAL;
        throw new IOException("Cannot deserialize BusinessStatus");
    }

}
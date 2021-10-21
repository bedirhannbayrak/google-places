package com.bedirhan.google.places.api.dto;

import java.io.IOException;

public enum IconBackgroundColor {
    FF9_E67, THE_7_B9_EB0, THE_909_CE1;

    public String toValue() {
        switch (this) {
            case FF9_E67: return "#FF9E67";
            case THE_7_B9_EB0: return "#7B9EB0";
            case THE_909_CE1: return "#909CE1";
        }
        return null;
    }

    public static IconBackgroundColor forValue(String value) throws IOException {
        if (value.equals("#FF9E67")) return FF9_E67;
        if (value.equals("#7B9EB0")) return THE_7_B9_EB0;
        if (value.equals("#909CE1")) return THE_909_CE1;
        throw new IOException("Cannot deserialize IconBackgroundColor");
    }
}
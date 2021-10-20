package com.bedirhan.google.places.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Geometry {
    private Location location;
    private Viewport viewport;
}

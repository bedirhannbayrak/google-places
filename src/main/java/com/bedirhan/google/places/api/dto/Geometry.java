package com.bedirhan.google.places.api.dto;

import com.bedirhan.google.places.api.model.Location;
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

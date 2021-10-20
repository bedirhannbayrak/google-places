package com.bedirhan.google.places.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Viewport {
    private Location northeast;
    private Location southwest;
}
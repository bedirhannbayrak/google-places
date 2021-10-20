package com.bedirhan.google.places.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Photo {
    private long height;
    private String[] htmlAttributions;
    private String photoReference;
    private long width;
}
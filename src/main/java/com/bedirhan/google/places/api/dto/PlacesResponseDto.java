package com.bedirhan.google.places.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlacesResponseDto {
    Location location;
    private String icon;
    private String name;
    private Double rating;
    private String vicinity;
}

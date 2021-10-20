package com.bedirhan.google.places.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class Location {
    private Double lat;
    private Double lng;
}
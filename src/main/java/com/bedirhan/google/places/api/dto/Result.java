package com.bedirhan.google.places.api.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Result {
    private Geometry geometry;
    private String name;
    private double rating;
    private String vicinity;

}
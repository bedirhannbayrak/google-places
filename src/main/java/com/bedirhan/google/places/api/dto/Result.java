package com.bedirhan.google.places.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Result {
    private BusinessStatus businessStatus;
    private Geometry geometry;
    private String icon;
    private IconBackgroundColor iconBackgroundColor;
    private String iconMaskBaseURI;
    private String name;
    private Boolean permanentlyClosed;
    private Photo[] photos;
    private String placeID;
    private PlusCode plusCode;
    private double rating;
    private String reference;
    private Scope scope;
    private String[] types;
    @JsonProperty("user_ratings_total")
    private long userRatingsTotal;
    private String vicinity;
    private OpeningHours openingHours;
    private Long priceLevel;

}
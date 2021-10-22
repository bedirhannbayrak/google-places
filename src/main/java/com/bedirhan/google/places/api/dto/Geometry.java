package com.bedirhan.google.places.api.dto;

import com.bedirhan.google.places.api.model.Location;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Geometry {
    private Location location;
}

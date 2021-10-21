package com.bedirhan.google.places.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class PlacesResponseDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    Location location;
    private String icon;
    @Column
    private String name;
    @Column
    private Double rating;
    @Column
    private String vicinity;
}

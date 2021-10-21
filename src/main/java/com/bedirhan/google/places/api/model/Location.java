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
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer id;
    @Column
    private Double lat;
    @Column
    private Double lng;

}
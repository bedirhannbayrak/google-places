package com.bedirhan.google.places.api.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Query {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(unique = true)
    private String name;

    @Column
    @OneToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<PlacesResponseDto> responseList = new HashSet<>();
}

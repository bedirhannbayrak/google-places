package com.bedirhan.google.places.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

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
    @Column
    private String name;
    @Column
    private Double rating;
    @Column
    private String vicinity;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PlacesResponseDto that = (PlacesResponseDto) o;
        return location != null && Objects.equals(location.getLat(), that.location.getLat());
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

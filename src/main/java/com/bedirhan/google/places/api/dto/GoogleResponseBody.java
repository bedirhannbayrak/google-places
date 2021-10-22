package com.bedirhan.google.places.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class GoogleResponseBody {
    @JsonProperty("next_page_token")
    private String nextPageToken;
    private List<Result> results;
    private String status;
}


package com.bedirhan.google.places.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GoogleResponseBody {
    private Object[] htmlAttributions;
    @JsonProperty("next_page_token")
    private String nextPageToken;
    private Result[] results;
    private String status;
}


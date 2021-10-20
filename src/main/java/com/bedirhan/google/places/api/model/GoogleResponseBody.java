package com.bedirhan.google.places.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GoogleResponseBody {
    private Object[] htmlAttributions;
    private String nextPageToken;
    private Result[] results;
    private String status;
}


package com.bedirhan.google.places.api.service;

import com.bedirhan.google.places.api.dto.Geometry;
import com.bedirhan.google.places.api.dto.GoogleResponseBody;
import com.bedirhan.google.places.api.dto.Result;
import com.bedirhan.google.places.api.model.Location;
import com.bedirhan.google.places.api.model.PlacesResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class HttpRequestServiceTest {

    private HttpRequestService httpRequestService;

    @BeforeEach
    void setUp() {
        httpRequestService = new HttpRequestService(WebClient.builder());
    }


/*
    @Test
    void whenGetRequestCalledWithValidRequest_itShouldConvertDataAndReturnSetOfPlacesResponseDto() {

        Set<PlacesResponseDto> request = httpRequestService.getRequest(lat, lng, radius);
        Assertions.assertEquals(request, generateSetOfPlacesResponseDto());
    }
*/


    @Test
    void whenconvertResultToResponseCalledWithValidRequest_itShouldReturnSetOfPlacesResponseDto() {

        Set<PlacesResponseDto> placesResponseDtos = httpRequestService.ConvertResultToResponse(generateGoogleResponseBody());
        Assertions.assertEquals(placesResponseDtos, generateSetOfPlacesResponseDto());
    }


    GoogleResponseBody generateGoogleResponseBody() {
        return GoogleResponseBody.builder()
                .results(List.of(
                        Result.builder()
                                .geometry(Geometry.builder()
                                        .location(Location.builder()
                                                .id(1)
                                                .lat(40.1421)
                                                .lng(35.12312)
                                                .build())
                                        .build())
                                .name("test1")
                                .vicinity("İstanbul")
                                .rating(4.5)
                                .build(),
                        Result.builder()
                                .geometry(Geometry.builder()
                                        .location(Location.builder()
                                                .id(2)
                                                .lat(41.1421)
                                                .lng(33.12312)
                                                .build())
                                        .build())
                                .name("test2")
                                .vicinity("Ankara")
                                .rating(4.0)
                                .build()
                )).build();
    }
    Set<PlacesResponseDto> generateSetOfPlacesResponseDto() {
        return Set.of(PlacesResponseDto.builder()
                        .id(1)
                        .name("test1")
                        .vicinity("İstanbul")
                        .rating(4.5)
                        .location(Location.builder()
                                .id(1)
                                .lat(40.1421)
                                .lng(35.12312)
                                .build())
                        .build(),
                PlacesResponseDto.builder()
                        .id(2)
                        .name("test2")
                        .vicinity("Ankara")
                        .rating(4.0)
                        .location(Location.builder()
                                .id(2)
                                .lat(41.1421)
                                .lng(33.12312)
                                .build())
                        .build());
    }

}

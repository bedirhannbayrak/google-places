package com.bedirhan.google.places.api.service;

import com.bedirhan.google.places.api.dto.Location;
import com.bedirhan.google.places.api.dto.PlacesResponseDto;
import com.bedirhan.google.places.api.model.GoogleResponseBody;
import com.bedirhan.google.places.api.exception.InvalidRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class HttpRequestService {

    private final WebClient.Builder webClientBuilder;

    @Value("${apikey}")
    private String apikey;

    public ArrayList<PlacesResponseDto> getRequest(String lat, String lng, String radius) {
        String URI = "https://maps.googleapis.com/maps/api/place/nearbysearch/json" +
                "?location=" + lat + "," + lng + "&radius=" + radius + "&types=food&key="
                + apikey;

        GoogleResponseBody res = webClientBuilder.build()
                .get()
                .uri(URI)
                .retrieve()
                .bodyToMono(GoogleResponseBody.class).block();

        if (res == null || res.getStatus().equals("INVALID_REQUEST")) {
            throw new InvalidRequestException("INVALID REQUEST");
        }
        return ConvertResultToResponse(res);
    }

    public ArrayList<PlacesResponseDto> ConvertResultToResponse(GoogleResponseBody body) {
        ArrayList<PlacesResponseDto> list = new ArrayList<>();
        Arrays.stream(body.getResults()).forEach(res -> {
            list.add(PlacesResponseDto.builder()
                    .rating(res.getRating())
                    .icon(res.getIcon())
                    .location(Location.builder()
                            .lat(res.getGeometry().getLocation().getLat())
                            .lng(res.getGeometry().getLocation().getLng())
                            .build())
                    .name(res.getName())
                    .vicinity(res.getVicinity())
                    .rating(res.getRating())
                    .build());
        });
        return list;
    }

}

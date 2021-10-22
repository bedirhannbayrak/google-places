package com.bedirhan.google.places.api.service;

import com.bedirhan.google.places.api.dto.GoogleResponseBody;
import com.bedirhan.google.places.api.exception.InvalidRequestException;
import com.bedirhan.google.places.api.model.Location;
import com.bedirhan.google.places.api.model.PlacesResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class HttpRequestService {

    private final WebClient.Builder webClientBuilder;

    @Value("${APIKEY}")
    private String apikey;

    public Set<PlacesResponseDto> getRequest(String lat, String lng, String radius)  {
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

    public Set<PlacesResponseDto> ConvertResultToResponse(GoogleResponseBody body) {
        Set<PlacesResponseDto> list = new HashSet<>();
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

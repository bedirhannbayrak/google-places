package com.bedirhan.google.places.api.controller;

import com.bedirhan.google.places.api.model.PlacesResponseDto;
import com.bedirhan.google.places.api.model.Query;
import com.bedirhan.google.places.api.service.HttpRequestService;
import com.bedirhan.google.places.api.service.QueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final HttpRequestService requestService;
    private final QueryService queryService;

    @GetMapping("")
    @CrossOrigin
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Set<PlacesResponseDto>> getPlaces(@RequestParam(required = false, name = "lat") String lat,
                                                            @RequestParam(required = false, name = "lng") String lng,
                                                            @RequestParam(required = false, name = "radius") String radius) {
        String queryName = lat + lng + radius;
        Set<PlacesResponseDto> res;
        if (queryService.existByName(queryName)) {
            res = queryService.findByName(queryName).getResponseList();
        }else{
            res = requestService.getRequest(lat, lng, radius);
            queryService.save(Query.builder()
                    .name(lat + lng + radius)
                    .responseList(res)
                    .build());
        }

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}

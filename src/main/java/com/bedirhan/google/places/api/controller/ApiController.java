package com.bedirhan.google.places.api.controller;

import com.bedirhan.google.places.api.dto.PlacesResponseDto;
import com.bedirhan.google.places.api.service.HttpRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final HttpRequestService requestService;

    @GetMapping("")
    @CrossOrigin
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<ArrayList<PlacesResponseDto>> getPlaces(@RequestParam(required = false, name = "lat")String lat,
                                                                 @RequestParam(required = false, name = "lng") String lng,
                                                                 @RequestParam(required = false, name = "radius")String radius) {
        return new ResponseEntity<>(requestService.getRequest(lat,lng,radius),HttpStatus.OK);
    }
}

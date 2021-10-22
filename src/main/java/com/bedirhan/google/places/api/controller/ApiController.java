package com.bedirhan.google.places.api.controller;

import com.bedirhan.google.places.api.model.PlacesResponseDto;
import com.bedirhan.google.places.api.model.Query;
import com.bedirhan.google.places.api.service.HttpRequestService;
import com.bedirhan.google.places.api.service.QueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Set;

@RestController
@Validated
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final HttpRequestService requestService;
    private final QueryService queryService;

    @GetMapping()
    @CrossOrigin
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Set<PlacesResponseDto>> getPlaces(@RequestParam(name = "lat") @Max(360)  Double lat,
                                                            @RequestParam(name = "lng") @Max (360) Double lng,
                                                            @RequestParam(name = "radius") @Min(0) @Max(100000) Double radius) {
        String queryName = String.valueOf(lng) + lat + + radius;
        Set<PlacesResponseDto> res;
        if (queryService.existByName(queryName)) {
            res = queryService.findByName(queryName).getResponseList();
        }else{
            res = requestService.getRequest(String.valueOf(lat),String.valueOf(lng),String.valueOf(radius));
            queryService.save(Query.builder()
                    .name(queryName)
                    .responseList(res)
                    .build());
        }

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}

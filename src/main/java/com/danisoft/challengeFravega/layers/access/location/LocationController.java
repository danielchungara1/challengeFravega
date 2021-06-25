package com.danisoft.challengeFravega.layers.access.location;

import com.danisoft.challengeFravega.layers.access.Endpoints;
import com.danisoft.challengeFravega.layers.access.ResponseDto;
import com.danisoft.challengeFravega.layers.business.location.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {

    private final LocationService service;

    @Autowired
    public LocationController(LocationService service) {
        this.service = service;
    }

    @GetMapping(Endpoints.LOCATION_NEAREST_READ_ONE)
    public ResponseDto readNearestLocation(CoordinatesDtoIn dto) {

        return ResponseDto.builder()
                .message("Location fetched.")
                .data(this.service.readNearestLocation(dto), LocationDtoOut.class)
                .build();
    }
}

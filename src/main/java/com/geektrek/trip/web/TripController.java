package com.geektrek.trip.web;

import com.geektrek.trip.domain.Trip;
import com.geektrek.trip.services.TripService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by David on 8/25/2019. Copyright (c) 2019 Bear Creek Consulting LLC.
 *
 * Controller for Trip Restful interface.
 *
 * @author David Heath
 * @version 1.0
 * @since 1.0
 *
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/trip")
public class TripController {

    @Autowired
    private TripService tripService;

    /**
     * Create a new Trip
     * @param trip
     * @return
     */
    @PostMapping("")
    public ResponseEntity<Trip> createNewTrip(@RequestBody Trip trip) {
        Trip t1 = tripService.saveOrUpdateProject(trip);
        return new ResponseEntity<Trip>(t1, HttpStatus.CREATED);
    }
}

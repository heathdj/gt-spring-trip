package com.geektrek.trip.web;

import com.geektrek.trip.domain.Trip;
import com.geektrek.trip.services.MapValidationError;
import com.geektrek.trip.services.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


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

    @Autowired
    private MapValidationError validationError;

    /**
     * Create a new Trip
     * @param trip
     * @return
     */
    @PostMapping("")
    public ResponseEntity<?> createNewTrip(@Valid @RequestBody Trip trip, BindingResult result) {

        if (result.hasErrors()) {
            return validationError.mapValidationError(result);
        }

        Trip t1 = tripService.saveOrUpdateProject(trip);
        return new ResponseEntity<Trip>(t1, HttpStatus.CREATED);
    }
}

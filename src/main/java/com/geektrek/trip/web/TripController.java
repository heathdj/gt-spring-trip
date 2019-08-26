package com.geektrek.trip.web;

import com.geektrek.trip.domain.Trip;
import com.geektrek.trip.services.MapValidationError;
import com.geektrek.trip.services.TripService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
@AllArgsConstructor
@RequestMapping("/api/trip")
public class TripController {

    @SuppressWarnings("Field injection is not reccomended")
    @Autowired
    private TripService tripService;

    @SuppressWarnings("Field injection is not reccomended")
    @Autowired
    private MapValidationError validationError;

    /**
     * Create a new Trip
     * @param trip The Trip object to be saved
     * @return a response object
     */
    @PostMapping("")
    public ResponseEntity<?> createNewTrip(@Valid @RequestBody Trip trip, BindingResult result) {

        if (result.hasErrors()) {
            return validationError.mapValidationError(result);
        }

        Trip t1 = tripService.saveOrUpdateProject(trip);
        return new ResponseEntity<>(t1, HttpStatus.CREATED);
    }

    /**
     * Find a Trip by the Unique Trip Id
     * @param tripId The unique Trip Id
     * @return a response object
     */
    @GetMapping("/{tripId}")
    public ResponseEntity<?> getTripById(@PathVariable String tripId) {

        Trip trip = tripService.findTripByIdentifier(tripId);

        return new ResponseEntity<>(trip, HttpStatus.OK);
    }

    /**
     * Get all Trips
     * TODO: Change to Pageable
     * @return
     */
    @GetMapping("/all")
    public Iterable<Trip> getAllTrips() {
        return tripService.findAllTrips();
    }

    /**
     * Delete the trip by the trip ID.
     * @param tripId
     * @return
     */
    @DeleteMapping("/{tripId}")
    public ResponseEntity<?> deleteTripById(@PathVariable String tripId) {
        tripService.deleteTripByIdentifier(tripId.toUpperCase());

        return new ResponseEntity<String>("Project with id '" +tripId.toUpperCase()+"' was deleted", HttpStatus.NO_CONTENT);
    }
}

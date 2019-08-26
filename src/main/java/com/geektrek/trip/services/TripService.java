package com.geektrek.trip.services;

import com.geektrek.trip.domain.Trip;

/**
 * Created by David on 8/25/2019. Copyright (c) 2019 Bear Creek Consulting LLC.
 *
 * This interface contains the business methods for handling a Trip Object.
 *
 * @author David Heath
 * @version 1.0
 * @since 1.0
 *
 */
public interface TripService {

    /**
     * Saves or Updates a trip using a repository object
     * @param trip the trip to be saved or updated.
     * @return
     */
    public Trip saveOrUpdateProject(Trip trip);

    /**
     * Finds a trip by the Trip ID
     * @param tripId
     * @return
     */
    public Trip findTripByIdentifier(String tripId);


    /**
     * Find all Trips
     * TODO: Change to Pageable
     * @return
     */
    public Iterable<Trip> findAllTrips();

    /**
     * Delete by TripId
     * @param tripId the trip ID to delete
     */
    public void deleteTripByIdentifier(String tripId);

    // TODO: Add in Delete by UUID

}

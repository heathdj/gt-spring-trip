package com.geektrek.trip.repositories;

import com.geektrek.trip.domain.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Locale;
import java.util.UUID;

/**
 * Created by David on 8/25/2019. Copyright (c) 2019 Bear Creek Consulting LLC.
 *
 * This class is the repository for a Trip.  A trip is created by a tour leader or employee of
 *  Geek-Trek and consists of a series of events scheduled over the duration of the tour.
 *
 *  @author David Heath
 *  @version 1.0
 *  @since 1.0
 */
@Repository
public interface TripRepository extends JpaRepository<Trip, UUID> {

    /**
     * Find all Trips with the same name anywhere in the world.
     * @param tripName
     * @param pageable
     * @return
     */
    Page<Trip> findAllByTripName(String tripName, Pageable pageable);

    // TODO: Add Country to Trip domain Object.
    //Page<Trip> findAllByCountry(String countryName, Pageable pageable)
    //Page<Trip> findAllByTripNameAndCountry(String tripName, String countryName, Pageable pageable);

    //TODO: Add City to Trip Domain Object.
    //Page<Trip> findAllByCity(String city, String countryName, Pageable pageable);
    //Page<Trip> findAllByNameAndCity(String tripName, String city, Locale.IsoCountryCode countryName, Pageable pageable);
}

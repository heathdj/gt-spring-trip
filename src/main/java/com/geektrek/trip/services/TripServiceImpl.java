package com.geektrek.trip.services;

import com.geektrek.trip.domain.Trip;
import com.geektrek.trip.repositories.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by David on 8/25/2019. Copyright (c) 2019 Bear Creek Consulting LLC.
 *
 * This is the implentation of the TripService Interface where the business locgic
 * of handling trip objects is implemented. This uses project lombok for common annotations
 *
 * @author David Heath
 * @version 1.0
 * @since 1.0
 */
@RequiredArgsConstructor
@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;


    @Override
    public Trip saveOrUpdateProject(Trip trip) {
        return tripRepository.save(trip);
    }
}

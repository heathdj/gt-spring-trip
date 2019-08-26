package com.geektrek.trip.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Created by David on 8/25/2019. Copyright (c) 2019 Bear Creek Consulting LLC.
 *
 * @author David Heath
 * @version 1.0
 * @since 1.0
 *
 */
@RequiredArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class TripIdExceptionResponse {
    private String TripIdentifier;

}

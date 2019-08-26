package com.geektrek.trip.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by David on 8/25/2019. Copyright (c) 2019 Bear Creek Consulting LLC.
 *
 * @author David Heath
 * @version 1.0
 * @since 1.0
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TripIdException extends RuntimeException{

    /**
     * Constructs a new runtime exception with the specified detail message. The cause is not initialized, and may
     * subsequently be initialized by a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()}
     *                method.
     */
    public TripIdException(String message) {
        super(message);
    }
}

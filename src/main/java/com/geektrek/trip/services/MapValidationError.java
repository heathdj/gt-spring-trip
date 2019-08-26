package com.geektrek.trip.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by David on 8/25/2019. Copyright (c) 2019 Bear Creek Consulting LLC.
 *
 * Helper Service Class to Format Errors from validation
 *
 * @author David Heath
 * @version 1.0
 * @since 1.0
 *
 */
@Service
public class MapValidationError {

    public ResponseEntity<?> mapValidationError(BindingResult result) {
        Map<String,String> errorMap = new HashMap<>();

        for(FieldError err: result.getFieldErrors()) {
            errorMap.put(err.getField(), err.getDefaultMessage());
        }
        return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
    }

}

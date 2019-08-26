package com.geektrek.trip.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geektrek.trip.domain.Trip;
import com.geektrek.trip.services.MapValidationError;
import com.geektrek.trip.services.TripService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by David on 8/25/2019. Copyright (c) 2019 Bear Creek Consulting LLC.
 *
 * Junit 5 Tests for the Trip Controller
 *
 * @author David Heath
 * @version 1.0
 * @since 1.0
 *
 */
@WebMvcTest(TripController.class)
public class TripControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    MapValidationError validationError;

    @MockBean
    TripService tripService;

    @Test
    void saveNewTrip() throws Exception {
        Trip trip = getValidTrip();

        String tripJson = objectMapper.writeValueAsString(trip);

        given(tripService.saveOrUpdateProject(any())).willReturn(getValidTrip());

        mockMvc.perform(post("/api/trip")
        .contentType(MediaType.APPLICATION_JSON)
        .content(tripJson))
        .andExpect(status().isCreated());


    }

    private Trip getValidTrip() {
        return Trip.builder()
                .tripName("Test")
                .tripIdentifier("1234")
                .description("a test")
                .price(BigDecimal.valueOf(1.25))
                .build();
    }
}

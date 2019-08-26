package com.geektrek.trip.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * Created by David on 8/25/2019. Copyright (c) 2019 Bear Creek Consulting LLC.
 *
 * This class is the Domain Model for a Trip.  A trip is created by a tour leader or employee of
 * Geek-Trek and consists of a series of events scheduled over the duration of the tour.  This class uses
 * project lombok to decorate the class and handle a lot of the boilerplate of setting up the class through
 * the class annotations.
 *
 * @author David Heath
 * @version 1.0
 * @since 1.0
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Trip implements Serializable {

    /**
     * Serial Number for this version of the Class
     */
    private static final long serialVersionUID = 19305135984490679L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    @NotBlank(message = "Trip name is required")
    private String tripName;

    @NotBlank(message = "Trip Identifier is required")
    @Size(min=4, max=8, message="Trip Identifier must be between 4 and 8 characters")
    @Column(updatable = false, unique = true, nullable = false)
    private String tripIdentifier;

    @NotBlank(message = "Trip Description is required.")
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:MM")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:MM")
    private Date endDate;

    @NotNull(message = "Price cannot be empty")
    private BigDecimal price;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:MM")
    @Column(name="created_at", updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:MM")
    @Column(name = "updated_at")
    private Date updatedAt;



}

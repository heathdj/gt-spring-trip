package com.geektrek.trip.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
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

    private String tripName;

    private String tripIdentifier;

    private String description;

    private Date startDate;

    private Date endDate;

    private BigDecimal price;

    @CreationTimestamp
    @Column(name="created_at", updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;



}

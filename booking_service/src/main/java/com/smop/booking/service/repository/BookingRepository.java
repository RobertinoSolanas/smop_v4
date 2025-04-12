package com.smop.booking.service.repository;

import com.smop.booking.service.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA Repository for Booking entities.
 * Provides CRUD operations and query methods.
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}

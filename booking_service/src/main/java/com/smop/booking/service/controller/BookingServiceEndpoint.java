package com.smop.booking.service.controller;

import com.smop.booking.service.exception.BookingNotFoundException;
import com.smop.booking.service.model.Booking;
import com.smop.booking.service.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for handling booking-related HTTP requests.
 * Exposes endpoints for CRUD operations on bookings.
 */
@RestController
@RequestMapping("/api/bookings")
public class BookingServiceEndpoint {

    private final BookingService bookingService;

    public BookingServiceEndpoint(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    /**
     * Creates a new booking
     * @param booking the booking to create
     * @return ResponseEntity with created booking and HTTP 201 status
     */
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking createdBooking = bookingService.createBooking(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);
    }

    /**
     * Retrieves a booking by ID
     * @param id the booking ID
     * @return ResponseEntity with found booking and HTTP 200 status
     */
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        Booking booking = bookingService.getBookingById(id);
        return ResponseEntity.ok(booking);
    }

    /**
     * Retrieves all bookings
     * @return ResponseEntity with list of all bookings and HTTP 200 status
     */
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    /**
     * Updates an existing booking
     * @param id the booking ID to update
     * @param bookingDetails the updated booking details
     * @return ResponseEntity with updated booking and HTTP 200 status
     */
    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking bookingDetails) {
        Booking updatedBooking = bookingService.updateBooking(id, bookingDetails);
        return ResponseEntity.ok(updatedBooking);
    }

    /**
     * Deletes a booking
     * @param id the booking ID to delete
     * @return ResponseEntity with no content and HTTP 204 status
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Exception handler for BookingNotFoundException
     * @param ex the exception
     * @return ResponseEntity with error message and HTTP 404 status
     */
    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<String> handleBookingNotFound(BookingNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}

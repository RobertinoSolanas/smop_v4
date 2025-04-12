package com.smop.booking.service.exception;

/**
 * Custom exception thrown when a booking is not found in the system.
 */
public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(String message) {
        super(message);
    }
}

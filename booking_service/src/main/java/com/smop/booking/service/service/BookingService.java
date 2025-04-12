package com.smop.booking.service.service;

import com.smop.booking.service.exception.BookingNotFoundException;
import com.smop.booking.service.model.Booking;
import com.smop.booking.service.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Service layer for handling business logic related to bookings.
 */
@Service
@Transactional
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    /**
     * Creates a new booking
     * @param booking the booking to create
     * @return the created booking
     */
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    /**
     * Retrieves a booking by ID
     * @param id the booking ID
     * @return the found booking
     * @throws BookingNotFoundException if booking not found
     */
    @Transactional(readOnly = true)
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with id: " + id));
    }

    /**
     * Retrieves all bookings
     * @return list of all bookings
     */
    @Transactional(readOnly = true)
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    /**
     * Updates an existing booking
     * @param id the booking ID to update
     * @param bookingDetails the updated booking details
     * @return the updated booking
     * @throws BookingNotFoundException if booking not found
     */
    public Booking updateBooking(Long id, Booking bookingDetails) {
        Booking booking = getBookingById(id);
        booking.setCustomerName(bookingDetails.getCustomerName());
        booking.setBookingDate(bookingDetails.getBookingDate());
        booking.setServiceType(bookingDetails.getServiceType());
        booking.setNotes(bookingDetails.getNotes());
        booking.setStatus(bookingDetails.getStatus());
        return bookingRepository.save(booking);
    }

    /**
     * Deletes a booking
     * @param id the booking ID to delete
     * @throws BookingNotFoundException if booking not found
     */
    public void deleteBooking(Long id) {
        Booking booking = getBookingById(id);
        bookingRepository.delete(booking);
    }
}

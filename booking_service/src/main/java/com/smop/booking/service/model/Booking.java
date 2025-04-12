package com.smop.booking.service.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity class representing a Booking in the system.
 * Maps to the 'bookings' table in the database.
 */
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String customerName;
    
    @Column(nullable = false)
    private LocalDateTime bookingDate;
    
    @Column(nullable = false)
    private String serviceType;
    
    @Column
    private String notes;
    
    // Status can be: PENDING, CONFIRMED, CANCELLED, COMPLETED
    @Column(nullable = false)
    private String status = "PENDING";

    // Constructors
    public Booking() {}

    public Booking(String customerName, LocalDateTime bookingDate, 
                  String serviceType, String notes) {
        this.customerName = customerName;
        this.bookingDate = bookingDate;
        this.serviceType = serviceType;
        this.notes = notes;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public LocalDateTime getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDateTime bookingDate) { this.bookingDate = bookingDate; }
    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

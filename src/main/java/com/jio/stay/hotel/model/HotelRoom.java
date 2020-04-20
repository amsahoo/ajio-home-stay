package com.jio.stay.hotel.model;

import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class HotelRoom {

    private int roomId;
    private int roomNumber;
    private int roomType;
    private Date fromDate;
    private Date toDate;
    private double price;
    private boolean isBooked;
    private String internalAmenities;
    private long hotelId;

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public String getInternalAmenities() {
        return internalAmenities;
    }

    public void setInternalAmenities(String internalAmenities) {
        this.internalAmenities = internalAmenities;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }
}

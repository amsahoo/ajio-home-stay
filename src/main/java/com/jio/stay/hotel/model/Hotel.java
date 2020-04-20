package com.jio.stay.hotel.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("hotel")
public class Hotel {
    private transient int hotelId; // TODO: Its wiser to set the id for logging purpose!
    private String hotelName;
    private Address hotelAddress;
    private String contactMail;
    private String contactNumber;
    private Map<Integer, Integer[]> roomsForEachProfile = new HashMap<>();

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Address getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(Address hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getContactMail() {
        return contactMail;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Map<Integer, Integer[]> getRoomsForEachProfile() {
        return roomsForEachProfile;
    }

    public void setRoomsForEachProfile(Map<Integer, Integer[]> roomsForEachProfile) {
        this.roomsForEachProfile = roomsForEachProfile;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }
}

package com.jio.stay.hotel.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="ROOM")
public class RoomEntity implements Serializable {


    @Id
    @GeneratedValue
    @Column(name="ROOM_ID")
    private int roomId;

    @Column(name="ROOM_NO")
    private int roomNumber;

    @Column(name="FROM_DATE")
    private Date fromDate;

    @Column(name="TO_DATE")
    private Date toDate;

    @Column(name="ROOM_PRICE")
    private double roomPrice;

    @Column(name="IS_BOOKED")
    private boolean isBooked;

    // Join columns says, Hey create a column "HOTEL_ID" referencing to Hotel table
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HOTEL_ID")
    private HotelEntity hotelEntity;

    // Join columns says, Hey create two columns "ROOM_PROFILE_ID" and "ROOM_TYPE" in the Room table referencing to RoomProfile table
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="ROOM_PROFILE_ID", referencedColumnName="ROOM_PROFILE_ID" ),
            @JoinColumn(name="ROOM_TYPE", referencedColumnName="ROOM_TYPE")
    })
    private RoomProfileEntity roomProfileEntity;

    @Column(name="INTERNAL_AMENITIES")
    private String internalAmenities;



    public String getInternalAmenities() {
        return internalAmenities;
    }

    public void setInternalAmenities(String internalAmenities) {
        this.internalAmenities = internalAmenities;
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

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public HotelEntity getHotelEntity() {
        return hotelEntity;
    }

    public void setHotelEntity(HotelEntity hotelEntity) {
        this.hotelEntity = hotelEntity;
    }

    public RoomProfileEntity getRoomProfileEntity() {
        return roomProfileEntity;
    }

    public void setRoomProfileEntity(RoomProfileEntity roomProfileEntity) {
        this.roomProfileEntity = roomProfileEntity;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    @Override
    public String toString() {
        return "RoomEntity{" +
                "roomId=" + roomId +
                ", roomNumber=" + roomNumber +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", price=" + roomPrice +
                ", isBooked=" + isBooked +
                ", hotelEntity=" + hotelEntity +
                ", roomProfileEntity=" + roomProfileEntity +
                ", internalAmenities='" + internalAmenities + '\'' +
                '}';
    }
}

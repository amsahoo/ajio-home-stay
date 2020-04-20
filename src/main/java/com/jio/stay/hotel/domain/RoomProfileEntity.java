package com.jio.stay.hotel.domain;

import javax.persistence.*;
import java.io.*;
import java.util.List;

@Entity
@Table(name="ROOM_PROFILE")
public class RoomProfileEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="ROOM_PROFILE_ID")
    private int roomProfileId;

    @ManyToOne
    @JoinColumn(name = "HOTEL_ID")
    private HotelEntity hotelEntity;

    //When we say Mapped by that means that this foreign key will be referenced by other class which has the mapping,
    // Which means that Current Entity i.e. RoomProfileEntity will not create any column containing the mapping
    //TODO: Rename the roomEntity to roomEntities
    @OneToMany(mappedBy = "roomProfileEntity")
    private List<RoomEntity> roomEntity;

    //TODO: We Dont need this, as this is the raw starting class and we dont need multiple mappings
    //@OneToMany(mappedBy = "roomProfileEntity")
    @Column(name="ROOM_TYPE")
    private int roomType;

    @Column(name="TOTAL_ROOM_COUNT")
    private int totalRoomCount;

    @Column(name="ROOM_PRICE")
    private double room_price;

    public double getRoom_price() {
        return room_price;
    }

    public void setRoom_price(double room_price) {
        this.room_price = room_price;
    }

    public int getRoomProfileId() {
        return roomProfileId;
    }

    public void setRoomProfileId(int roomProfileId) {
        this.roomProfileId = roomProfileId;
    }

    public HotelEntity getHotelEntity() {
        return hotelEntity;
    }

    public void setHotelEntity(HotelEntity hotelEntity) {
        this.hotelEntity = hotelEntity;
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public int getTotalRoomCount() {
        return totalRoomCount;
    }

    public void setTotalRoomCount(int totalRoomCount) {
        this.totalRoomCount = totalRoomCount;
    }

    public List<RoomEntity> getRoomEntity() {
        return roomEntity;
    }

    public void setRoomEntity(List<RoomEntity> roomEntity) {
        this.roomEntity = roomEntity;
    }

}

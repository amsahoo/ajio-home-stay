package com.jio.stay.hotel.controller;

import com.jio.stay.hotel.domain.RoomEntity;
import com.jio.stay.hotel.model.Hotel;
import com.jio.stay.hotel.model.HotelRoom;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * This is a contract
 *
 * @author asburnwa
 */
public interface HotelAdminController {

    /**
     * This API is used to create hotel's account, which internally creates the room profile and the number of room.
     *
     * @param hotel
     * @return ResponseEntity
     */
    ResponseEntity<Hotel> createAccount(Hotel hotel);

    boolean allocateRoom(HotelRoom hotelRoom);

    List<HotelRoom> getRooms(long hotelId);

    int updatePriceOfAvailableRooms(long hotelId, int roomType, double price);

}
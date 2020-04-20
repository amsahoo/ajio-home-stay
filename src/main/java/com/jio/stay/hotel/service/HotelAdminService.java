package com.jio.stay.hotel.service;

import com.jio.stay.hotel.domain.RoomEntity;
import com.jio.stay.hotel.model.Hotel;
import com.jio.stay.hotel.model.HotelRoom;

import java.util.List;

public interface HotelAdminService {

    Hotel createHotelAccount(Hotel hotel);

    boolean bookRoom(HotelRoom hotelRoom);

    List<HotelRoom> fetchAvailableRoomList(long hotelId);

    int modifyPriceOfAvailableRooms(long hotelId, int roomType, double price);
}

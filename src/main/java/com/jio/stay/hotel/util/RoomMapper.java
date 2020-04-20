package com.jio.stay.hotel.util;

import com.jio.stay.hotel.domain.RoomEntity;
import com.jio.stay.hotel.model.HotelRoom;

import java.util.ArrayList;
import java.util.List;

public class RoomMapper {

    public static List<HotelRoom> convertRoomEntityToHotelRoom(  List<RoomEntity> roomEntities) {

        List<HotelRoom> hotelRooms=new ArrayList<>();
        roomEntities.forEach(roomEntity -> {
            HotelRoom hotelRoom=new HotelRoom();
            hotelRoom.setBooked(roomEntity.isBooked());
            hotelRoom.setHotelId(roomEntity.getHotelEntity().getId());
            hotelRoom.setRoomId(roomEntity.getRoomId());
            hotelRoom.setPrice(roomEntity.getRoomPrice());
            hotelRoom.setInternalAmenities(roomEntity.getInternalAmenities());
            hotelRooms.add(hotelRoom);
        });
        return hotelRooms;
    }

}

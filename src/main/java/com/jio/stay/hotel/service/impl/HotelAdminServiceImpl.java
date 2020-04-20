package com.jio.stay.hotel.service.impl;

import com.jio.stay.hotel.domain.HotelEntity;
import com.jio.stay.hotel.domain.RoomEntity;
import com.jio.stay.hotel.model.Hotel;
import com.jio.stay.hotel.model.HotelRoom;
import com.jio.stay.hotel.repo.HotelEntityRepository;
import com.jio.stay.hotel.repo.RoomRepo;
import com.jio.stay.hotel.service.HotelAdminService;
import com.jio.stay.hotel.util.HotelEntityMapper;
import com.jio.stay.hotel.util.RoomMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class HotelAdminServiceImpl implements HotelAdminService {
    Logger LOGGER = LoggerFactory.getLogger(HotelAdminServiceImpl.class);

    @Autowired
    private HotelEntityRepository hotelRepo;

    @Autowired
    private RoomRepo roomRepo;

    @Override
    public Hotel createHotelAccount(Hotel hotel) {

        HotelEntity createdHotelEntity = null;
        if (!isHotelPresent(hotel.getHotelName(), hotel.getHotelAddress().getPinCode())) {
            createdHotelEntity = hotelRepo.save(HotelEntityMapper.convertHotelToEntity(hotel));
        }
        return HotelEntityMapper.convertHotelEntityToHotel(createdHotelEntity);
    }


    @Override
    public boolean bookRoom(HotelRoom hotelRoom) {
        boolean result = false;

        Optional<RoomEntity> fetchedHotelRoom = roomRepo.findById(5);
        if (isRoomAvailableOfRoomType(hotelRoom.getRoomType(), hotelRoom.getHotelId())) {
            fetchedHotelRoom.get().setBooked(true);
            roomRepo.save(fetchedHotelRoom.get());
            result = true;
        }

        return result;
    }


    @Override
    public List<HotelRoom> fetchAvailableRoomList(long hotelId) {
        List<RoomEntity> roomEntities=roomRepo.findAllAvailableRooms(hotelId);
        return RoomMapper.convertRoomEntityToHotelRoom(roomEntities);
    }


    @Override
    public int modifyPriceOfAvailableRooms(long hotelId, int roomType, double price) {

        int count = roomRepo.updatePriceOfAvailableRooms(hotelId, roomType, price);
        if (count > 0){
            LOGGER.info("Successfully updated " + count + "no of records.");
        }
        return count;
    }

    private boolean isRoomAvailableOfRoomType(int roomType, long hotelId) {
        boolean result;
        List<RoomEntity> room = findAvailableRoomByRoomType(roomType, hotelId);
        if (room.size() > 0) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public List<RoomEntity> findAvailableRoomByRoomType(int roomTypeId, long hotelId) {
        List<RoomEntity> roomEntities = roomRepo.fetchAllAvailableRoomsByType(roomTypeId, hotelId);
        LOGGER.info(String.format("No of available rooms  %d of type %d", roomTypeId, roomEntities.size()));
        return roomEntities;
    }

    public boolean isHotelPresent(String hotelName, int pinCode) {
        boolean flag = false;
        try {
            List<HotelEntity> fetchedHotels = hotelRepo.getHotelByNameAndPin(hotelName, pinCode);
            if (fetchedHotels != null && fetchedHotels.size() > 0) {
                LOGGER.info("Hotel With the Name: " + hotelName + " already exists in the given pincode "+pinCode);
                flag = true;
            }
        } catch (Exception e) {
            LOGGER.warn("Caught exception while fetching hotel details " + e);
        }
        return flag;
    }
}

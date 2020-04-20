package com.jio.stay.hotel.controller.impl;

import com.jio.stay.hotel.controller.HotelAdminController;
import com.jio.stay.hotel.domain.HotelEntity;
import com.jio.stay.hotel.domain.RoomEntity;
import com.jio.stay.hotel.model.Hotel;
import com.jio.stay.hotel.model.HotelRoom;
import com.jio.stay.hotel.repo.HotelEntityRepository;
import com.jio.stay.hotel.service.HotelAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotel")
public class HotelAdminControllerImpl implements HotelAdminController {
    Logger LOGGER = LoggerFactory.getLogger(HotelAdminControllerImpl.class);

    @Autowired
    private HotelAdminService hotelAdminService;

    @Autowired
    private HotelEntityRepository hotelEntityRepository;

    /**
     * @inheritDoc
     */
    @Override
    @PostMapping(path = "/account", consumes = "application/json")
    public ResponseEntity<Hotel> createAccount(@RequestBody Hotel hotel) {
        ResponseEntity<Hotel> result;
        ResponseEntity response = null;
        Hotel createdHotel = hotelAdminService.createHotelAccount(hotel);
        if (null != createdHotel) {
            LOGGER.info("Hotel created with name::  " + createdHotel.getHotelName());
            result = new ResponseEntity<>(createdHotel, HttpStatus.OK);
        } else {
            result = new ResponseEntity<>((Hotel) null, HttpStatus.BAD_REQUEST);
        }
        return result;
    }

    /**
     * @param hotelRoom
     * @return booking of a room
     */
    @Override
    @PostMapping(path = "/booking", consumes = "application/json")
    public boolean allocateRoom(@RequestBody HotelRoom hotelRoom) {
        return hotelAdminService.bookRoom(hotelRoom);
    }

    /**
     * @param hotelId
     * @return list of all available rooms
     */
    @Override
    @GetMapping(path = "/{hotelId}/rooms", produces = "application/json")
    public List<HotelRoom> getRooms(@PathVariable long hotelId) {
        return hotelAdminService.fetchAvailableRoomList(hotelId);
    }

    /**
     * Update price for rooms of specific profile which are not booked
     * @param hotelId
     * @param roomType
     * @param price

     */
    @Override
    @GetMapping(path = "/price")
    public int updatePriceOfAvailableRooms(@RequestParam(name = "hotelId") long hotelId,
                                           @RequestParam(name = "roomType") int roomType,
                                           @RequestParam(name = "price") double price) {
        return hotelAdminService.modifyPriceOfAvailableRooms(hotelId, roomType, price);

    }

    @GetMapping("/all")
    public List<HotelEntity> getHotel() {
        return hotelEntityRepository.findAll();
    }
}

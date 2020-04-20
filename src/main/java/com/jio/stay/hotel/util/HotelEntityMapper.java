package com.jio.stay.hotel.util;

import com.jio.stay.hotel.domain.AddressEntity;
import com.jio.stay.hotel.domain.HotelEntity;
import com.jio.stay.hotel.domain.RoomEntity;
import com.jio.stay.hotel.domain.RoomProfileEntity;
import com.jio.stay.hotel.enums.RoomProfileEnum;
import com.jio.stay.hotel.model.Address;
import com.jio.stay.hotel.model.Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class HotelEntityMapper {
    public static HotelEntity convertHotelToEntity(Hotel hotel) {
        HotelEntity hotelEntity = null;
        if (hotel != null) {
            hotelEntity = new HotelEntity();

            //Get HotelEntity out of Hotel Object
            hotelEntity.setHotelName(hotel.getHotelName());
            hotelEntity.setContactMail(hotel.getContactMail());
            hotelEntity.setContactNumber(hotel.getContactNumber());

            //Get Address out of Hotel object
            AddressEntity address = new AddressEntity();
            address.setCountry(hotel.getHotelAddress().getCountry());
            address.setAddress1(hotel.getHotelAddress().getAddress1());
            address.setPinCode(hotel.getHotelAddress().getPinCode());

            //Get Room Profile From hotel object which contains detail like
            //  How Many rooms we need create for a specific type
            Map<Integer, Integer[]> roomProfileMap = hotel.getRoomsForEachProfile();
            List<RoomEntity> roomEntities = new ArrayList<>();

            //Get Room Profile From "Hotel" Object, We will get this value from Map object
            List<RoomProfileEntity> roomProfileEntities = new ArrayList<>();

            for (Map.Entry<Integer, Integer[]> entry : roomProfileMap.entrySet()) {
                RoomProfileEntity roomProfileEntity = new RoomProfileEntity();
                roomProfileEntity.setHotelEntity(hotelEntity);
                roomProfileEntity.setRoomType(entry.getKey());
                roomProfileEntity.setTotalRoomCount(entry.getValue()[0]);
                roomProfileEntity.setRoom_price(entry.getValue()[1]);
                roomProfileEntities.add(roomProfileEntity);

                //This will hold details like "DELUX, |"TV","PARKING",FRIDGE"
                List<String> roomProfile = RoomProfileEnum.getRoomTypeByRoomTypeId(entry.getKey());

                //Extract internalAmenties if size of roomProfile>1
                if (roomProfile.size() > 1) {
                    // Will give the internal amenities of a room type, e.g. TV, Fridge, Parking etc...
                    createNnumberOfRoomsAndAddToRoomEntityList(entry.getKey(), entry.getValue(), roomEntities, hotelEntity, roomProfile.get(1), roomProfileEntity);
                } else {
                    createNnumberOfRoomsAndAddToRoomEntityList(entry.getKey(), entry.getValue(), roomEntities, hotelEntity, null, roomProfileEntity);
                }
            }

            hotelEntity.setRoomProfileEntity(roomProfileEntities);
            hotelEntity.setRoomEntity(roomEntities);
            hotelEntity.setAddressEntity(address);
        }
        return hotelEntity;
    }

    /**
     * This method which will create 'n' number of room of a particular type say xyz type and add to List<RoomEntity>
     * which will be persisted later on to DB.
     *
     * @param roomType
     * @param roomCountAndPrice
     * @param hotelEntity
     * @param internalAmenties
     * @return
     */
    private static List<RoomEntity> createNnumberOfRoomsAndAddToRoomEntityList(int roomType, Integer[] roomCountAndPrice, List<RoomEntity> roomEntities, HotelEntity hotelEntity, String internalAmenties, RoomProfileEntity roomProfileEntity) {
        for (int i = 0; i < roomCountAndPrice[0]; i++) {
            RoomEntity tmpRoomEntity = new RoomEntity();
            tmpRoomEntity.setHotelEntity(hotelEntity);
            tmpRoomEntity.setInternalAmenities(internalAmenties);
            tmpRoomEntity.setRoomProfileEntity(roomProfileEntity);
            tmpRoomEntity.setBooked(false);
            tmpRoomEntity.setRoomPrice(roomCountAndPrice[1]);
            roomEntities.add(tmpRoomEntity);
        }
        return roomEntities;
    }

    public static Hotel convertHotelEntityToHotel(HotelEntity hotelEntity) {
        Hotel hotel = null;
        if (hotelEntity != null) {
            hotel = new Hotel();
            hotel.setHotelName(hotelEntity.getHotelName());
            hotel.setContactMail(hotelEntity.getContactMail());
            hotel.setContactNumber(hotelEntity.getContactNumber());

            Address address = new Address();
            address.setCountry(hotelEntity.getAddressEntity().getCountry());
            address.setAddress1(hotelEntity.getAddressEntity().getAddress1());
            address.setAddress2(hotelEntity.getAddressEntity().getAddress2());
            address.setPinCode(hotelEntity.getAddressEntity().getPinCode());
            address.setState(hotelEntity.getAddressEntity().getPlotNumber());

            hotel.setHotelAddress(address);

        }
        return hotel;
    }

    private HotelEntityMapper() {
        throw new AssertionError("This should be invoked");
    }
}
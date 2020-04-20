package com.jio.stay.hotel.enums;

import com.jio.stay.hotel.domain.RoomProfileEntity;

import java.util.*;
import java.util.stream.Collectors;

public enum RoomProfileEnum {
    DELUX(1, "Delux Room", "TV", "Sofa", "Minibar", "Parking"),
    LUXURY(2, "Luxury Room", "TV", "Sofa"),
    ECONOMY(3, "Economy");

    private int id;
    private String roomTypeName;
    private List<String> internalAmenties;
    private static Map<Integer, List<String>> roomProfileMap = new HashMap<>();



    //Using the static block we will add all the fields to Map
    static {
        for(RoomProfileEnum roomProfileEnum: RoomProfileEnum.values()){
            String roomType = roomProfileEnum.getRoomTypeName();
            List<String> enumEquivalentOfRoomProfileInList = new ArrayList<>();

            enumEquivalentOfRoomProfileInList.add(0,roomType);
            if(null != roomProfileEnum.getInternalAmenties(roomProfileEnum.getId())){
                String roomTypeTmp= enumEquivalentOfRoomProfileInList.get(0).concat(",");
                enumEquivalentOfRoomProfileInList.clear();
                enumEquivalentOfRoomProfileInList.add(0,roomTypeTmp);
                String internalAmentiesInString= String.join(",", roomProfileEnum.getInternalAmenties(roomProfileEnum.getId()));
                enumEquivalentOfRoomProfileInList.add(1,internalAmentiesInString);
                roomProfileMap.put(roomProfileEnum.getId(),enumEquivalentOfRoomProfileInList);
            }else{
                roomProfileMap.put(roomProfileEnum.getId(),enumEquivalentOfRoomProfileInList);
            }


        }

    }

    //TODO: Need to think if we should make it publically accessible.
    private static Map<Integer, List<String>> getRoomProfileMap() {
        return roomProfileMap;
    }

    public List<String> getInternalAmenties(int roomTypeId) {
            return internalAmenties;
    }

    public static List<String> getRoomTypeByRoomTypeId(int roomTypeId) {
        return roomProfileMap.containsKey(roomTypeId) ? roomProfileMap.get(roomTypeId) : null;
    }

    public static boolean isValidRoomTypeId(int roomTypeId) {
        return roomProfileMap.containsKey(roomTypeId);
    }

    RoomProfileEnum(int id, String roomTypeName, String... internalAmenties) {
        this.id = id;
        this.roomTypeName = roomTypeName;
        this.internalAmenties = new ArrayList<>();
        for (String amenity : internalAmenties) {
            this.internalAmenties.add(amenity);
        }


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

}

package com.jio.stay.hotel.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum UsersRoleEnum {

    SUPER_ADMIN(1, "Super Administrator"),
    HOTEL_ADMIN(2, "Hotel Administrator"),
    GUEST(3, "Guest");

    private int id;
    private String userRole;
    private static Map<Integer, String> userRoleMap = new HashMap<>();


    static {
        Arrays.stream(UsersRoleEnum.values()).map(role -> (userRoleMap.put(role.getId(), role.getUserRole())));
    }

    public static String getUserRole(int userId) {
        return userRoleMap.containsKey(userId) ? userRoleMap.get(userId) : null;
    }

    UsersRoleEnum(int id, String userRole) {
        this.id = id;
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }


}

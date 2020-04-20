package com.jio.stay.hotel.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "HOTEL")
public class HotelEntity implements Serializable {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "hotelName")
    private String hotelName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true,name = "ADDRESS_ID")
    private AddressEntity addressEntity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotelEntity")
    private List<RoomProfileEntity> roomProfileEntity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotelEntity")
    private List<RoomEntity> roomEntity;

    @Column(name = "CONTACT_MAIL")
    private String contactMail;

    @Column(name = "HOTEL_CONTACT_NUMBER")
    private String contactNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }


    public String getContactMail() {
        return contactMail;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public List<RoomProfileEntity> getRoomProfileEntity() {
        return roomProfileEntity;
    }

    public void setRoomProfileEntity(List<RoomProfileEntity> roomProfileEntity) {
        this.roomProfileEntity = roomProfileEntity;
    }

    public List<RoomEntity> getRoomEntity() {
        return roomEntity;
    }

    public void setRoomEntity(List<RoomEntity> roomEntity) {
        this.roomEntity = roomEntity;
    }

}

package com.jio.stay.hotel.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ADDRESS")
public class AddressEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="pinCode")
    private int pinCode;

    @Column(name="PLOT_NUMBER")
    private String plotNumber;

    @Column(name="ADDRESS1")
    private String address1;

    @Column(name="ADDRESS2")
    private String address2;

    @Column(name="STATE")
    private String state;

    @Column(name="COUNTRY")
    private String country;

    public HotelEntity getHotelEntity() {
        return hotelEntity;
    }

    public void setHotelEntity(HotelEntity hotelEntity) {
        this.hotelEntity = hotelEntity;
    }

    @OneToOne(mappedBy = "addressEntity")
    private HotelEntity hotelEntity;

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getPlotNumber() {
        return plotNumber;
    }

    public void setPlotNumber(String plotNumber) {
        this.plotNumber = plotNumber;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}


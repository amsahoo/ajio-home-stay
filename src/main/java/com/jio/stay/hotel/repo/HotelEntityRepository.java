package com.jio.stay.hotel.repo;

import com.jio.stay.hotel.domain.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelEntityRepository extends JpaRepository<HotelEntity, Long> {

    /*@Query(value="SELECT * FROM hotel h where h.address_id IN (SELECT a.id from address a WHERE a.pin_code = :pinCode) AND h.hotel_name = :hotelName",nativeQuery = true)
    HotelEntity getHotelByNameAndPin(@Param("hotelName") String hotelName, @Param("pinCode") int pinCode);*/

    @Query(value="SELECT * FROM hotel h where h.address_id IN (SELECT a.id from address a WHERE a.pin_code = :pinCode) AND h.hotel_name = :hotelName",nativeQuery = true)
    List<HotelEntity> getHotelByNameAndPin(@Param("hotelName") String hotelName, @Param("pinCode") int pinCode);

}

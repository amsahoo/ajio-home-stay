package com.jio.stay.hotel.repo;

import com.jio.stay.hotel.domain.RoomEntity;
import com.jio.stay.hotel.model.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RoomRepo extends JpaRepository<RoomEntity, Integer> {

    @Query(value = " SELECT * FROM public.room rm WHERE rm.room_type =:roomTypeId and rm.hotel_id=:hotelId",nativeQuery = true)
    List<RoomEntity> fetchAllAvailableRoomsByType(int roomTypeId,long hotelId);

    @Query(value="SELECT * from public.room r  where r.is_booked=false and r.hotel_id=:hotelId",nativeQuery = true)
    List<RoomEntity> findAllAvailableRooms(long hotelId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value="UPDATE room SET  room_price=:price WHERE  hotel_id=:hotelId and room_type=:roomType and is_booked=false",nativeQuery = true)
    int updatePriceOfAvailableRooms(long hotelId,int roomType,double price);

}

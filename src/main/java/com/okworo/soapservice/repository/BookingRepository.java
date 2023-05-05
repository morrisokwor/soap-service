package com.okworo.soapservice.repository;

import com.okworo.soapservice.entities.BookingEntity;
import com.okworo.soapservice.entities.ClientEntity;
import com.okworo.soapservice.entities.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author Morris.Okworo on 04/05/2023
 */

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

    Optional<BookingEntity> findByRoomAndAndCheckoutDateIsBefore(RoomEntity room, LocalDate date);

    List<BookingEntity> findByClient(ClientEntity client);
}

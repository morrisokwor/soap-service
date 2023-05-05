package com.okworo.soapservice.services;

import com.okworo.soapservice.entities.BookingEntity;
import com.okworo.soapservice.entities.ClientEntity;
import com.okworo.soapservice.entities.RoomEntity;
import com.okworo.soapservice.interfaces.*;
import com.okworo.soapservice.repository.BookingRepository;
import com.okworo.soapservice.repository.ClientRepository;
import com.okworo.soapservice.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * @author Morris.Okworo on 03/05/2023
 */
@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ClientRepository clientRepository;
    private final RoomRepository roomRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public BookingResponse addBooking(BookingRequest bookingRequest) {
        BigDecimal bookingCost = new BigDecimal(0);
        ClientEntity client = clientRepository.findById(bookingRequest.getClientId()).get();
        List<BookingRequest.Booking> bookings = bookingRequest.getBooking();
        List<BookingResponse.Booking> _bookings = new ArrayList<>();

        StringBuilder msg = new StringBuilder();
        for (BookingRequest.Booking booking : bookings) {
            BookingEntity bookingEntity = new BookingEntity();
            RoomEntity room = roomRepository.findById(booking.getRoomId()).get();
            bookingEntity.setClient(client);
            bookingEntity.setRoom(room);
            bookingEntity.setCheckoutDate(LocalDate.of(
                    booking.getCheckoutDate().getYear(),
                    booking.getCheckoutDate().getMonth(),
                    booking.getCheckoutDate().getDay()));
            bookingEntity.setCheckinDate(LocalDate.of(
                    booking.getCheckinDate().getYear(),
                    booking.getCheckinDate().getMonth(),
                    booking.getCheckinDate().getDay()));
            BigDecimal cost = room.getPrice().multiply(new BigDecimal(DAYS.between(bookingEntity.getCheckinDate(), bookingEntity.getCheckoutDate())));
            bookingEntity.setCost(cost);
            bookingRepository.save(bookingEntity);
            bookingCost = bookingCost.add(cost);
            msg.append(room.getRoomNumber() + ",");

            BookingResponse.Booking _booking = new BookingResponse.Booking();
            _booking.setCost(cost);
            _booking.setRoom(modelMapper.map(room, Room.class));
            _booking.setCheckinDate(booking.getCheckinDate());
            _booking.setCheckoutDate(booking.getCheckoutDate());
            _bookings.add(_booking);

            room.setIsBooked(1);
            roomRepository.save(room);
        }
        BookingResponse bookingResponse = new BookingResponse();

        ResponseStatus responseStatus = new ResponseStatus();
        bookingResponse.getBooking().addAll(_bookings);
        responseStatus.setStatus("SUCCESS");
        responseStatus.setMessage("Booking for room(s) " + msg.deleteCharAt(msg.length() - 1) + " placed successfully");
        bookingResponse.setResponseStatus(responseStatus);
        bookingResponse.setTotalPrice(bookingCost);
        return bookingResponse;
    }

    public BookingResponse getClientBookings(BookingConfirmationRequest bookingRequest) {
        BigDecimal bookingCost = new BigDecimal(0);
        ClientEntity client = clientRepository.findById(bookingRequest.getClientId()).get();
        List<BookingEntity> clientBookings = bookingRepository.findByClient(client);
        List<BookingResponse.Booking> _bookings = new ArrayList<>();
        for (BookingEntity booking : clientBookings) {
            BookingResponse.Booking _booking = new BookingResponse.Booking();
            _booking.setCost(booking.getCost());
            _booking.setRoom(modelMapper.map(booking.getRoom(), Room.class));
            _bookings.add(_booking);
            bookingCost = bookingCost.add(booking.getCost());
        }

        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.getBooking().addAll(_bookings);

        bookingResponse.setTotalPrice(bookingCost);
        return bookingResponse;
    }


}

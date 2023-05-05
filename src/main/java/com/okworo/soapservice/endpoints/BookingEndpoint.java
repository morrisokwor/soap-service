package com.okworo.soapservice.endpoints;

import com.okworo.soapservice.interfaces.BookingConfirmationRequest;
import com.okworo.soapservice.interfaces.BookingRequest;
import com.okworo.soapservice.interfaces.BookingResponse;
import com.okworo.soapservice.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * @author Morris.Okworo on 05/05/2023
 */
@Endpoint
@RequiredArgsConstructor
public class BookingEndpoint {

    private static final String NAMESPACE_URI = "http://interfaces.soapservice.okworo.com";

    private final BookingService bookingService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "BookingRequest")
    @ResponsePayload
    public BookingResponse addBooking(@RequestPayload BookingRequest bookingRequest) {

        return bookingService.addBooking(bookingRequest);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "BookingConfirmationRequest")
    @ResponsePayload
    public BookingResponse addBooking(@RequestPayload BookingConfirmationRequest request) {

        return bookingService.getClientBookings(request);
    }
}

package com.okworo.soapservice.endpoints;

import com.okworo.soapservice.interfaces.CelsiusToFahrenheitRequest;
import com.okworo.soapservice.interfaces.CelsiusToFahrenheitResponse;
import com.okworo.soapservice.interfaces.FahrenheitToCelsiusRequest;
import com.okworo.soapservice.interfaces.FahrenheitToCelsiusResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Morris.Okworo on 03/05/2023
 */
@Endpoint
public class TemperatureConversion {

    private static final String NAMESPACE_URI = "http://interfaces.soapservice.okworo.com";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CelsiusToFahrenheitRequest")
    @ResponsePayload
    public CelsiusToFahrenheitResponse celsiusToFahrenheit(@RequestPayload CelsiusToFahrenheitRequest request) {
        //°F=(°C×9/5)+32

        BigDecimal nineFifths = new BigDecimal(9).divide(new BigDecimal(5));
        BigDecimal multipRes = request.getCelsius().multiply(nineFifths);
        BigDecimal result = multipRes.add(new BigDecimal(32)).setScale(2, RoundingMode.FLOOR);

        CelsiusToFahrenheitResponse response = new CelsiusToFahrenheitResponse();
        response.setFahrenheit(result);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "FahrenheitToCelsiusRequest")
    @ResponsePayload
    public FahrenheitToCelsiusResponse fahrenheitToCelsius(@RequestPayload FahrenheitToCelsiusRequest request) {
        //°C=(°F−32)×5/9
        BigDecimal subtRes = request.getFahrenheit().subtract(new BigDecimal(32));
        BigDecimal result = subtRes.multiply(new BigDecimal(0.555555556)).setScale(2, RoundingMode.FLOOR);

        FahrenheitToCelsiusResponse response = new FahrenheitToCelsiusResponse();
        response.setCelsius(result);

        return response;
    }
}

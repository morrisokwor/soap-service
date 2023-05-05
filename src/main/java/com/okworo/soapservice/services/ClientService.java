package com.okworo.soapservice.services;

import com.okworo.soapservice.entities.ClientEntity;
import com.okworo.soapservice.interfaces.*;
import com.okworo.soapservice.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * @author Morris.Okworo on 03/05/2023
 */
@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;

    public ClientResponse addClient(ClientRequest clientRequest) {

        ClientEntity client = modelMapper.map(clientRequest.getClient(), ClientEntity.class);
        ClientEntity savedClient = clientRepository.save(client);

        ClientResponse response = new ClientResponse();
        ResponseStatus responseStatus = new ResponseStatus();
        if (savedClient.getId() > 0) {
            responseStatus.setStatus("SUCCESS");
            responseStatus.setMessage("Client Saved Successfully");
            response.setClient(modelMapper.map(savedClient, Client.class));
            response.setResponseStatus(responseStatus);
        } else {
            responseStatus.setStatus("FAILED");
            responseStatus.setMessage("Client Not Saved!..Kindly check and try again");
            response.setResponseStatus(responseStatus);
        }
        return response;
    }

    public ClientResponse getClientByIdRequest(ClientByIdRequest request) {
        ClientEntity client = clientRepository.findById(request.getClientId()).get();

        ClientResponse response = new ClientResponse();
        response.setClient(modelMapper.map(client, Client.class));
        return response;
    }
}

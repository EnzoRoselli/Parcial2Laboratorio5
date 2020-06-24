package com.example.ParcialRestIntegration.Controllers;


import com.example.ParcialRestIntegration.Domains.Call;
import com.example.ParcialRestIntegration.Services.IntegrationService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class CallsControllerTest {

    @Autowired
    @InjectMocks
    CallsController callsController;
    @Mock
    IntegrationService integrationService;

    @Before
    public void setUp(){
        initMocks(this);
    }

    @Test
    public void getAllByDestinationPhoneOk(){
        String destinationPhone = "2253333333";
        List<Call> callList = new ArrayList<>();
        Call auxCall = Call.builder().id(1).originPhone("2236960257").destinationPhone(destinationPhone).build();
        callList.add(auxCall);
        auxCall = Call.builder().id(2).originPhone("2237561234").destinationPhone(destinationPhone).build();
        callList.add(auxCall);

        when(integrationService.getCallsByDestinationPhone(destinationPhone)).thenReturn((ResponseEntity<List<Call>>) callList);

        ResponseEntity<List<Call>> responseEntity = callsController.getCallsByDestinationPhone(destinationPhone);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(callList, responseEntity.getBody());
    }

    @Test
    public void getAllByDestinationPhoneNoContent() {
        String destinationPhone = "2253333333";
        List<Call> callList = new ArrayList<>();

        when(integrationService.getCallsByDestinationPhone(destinationPhone)).thenReturn((ResponseEntity<List<Call>>) callList);

        ResponseEntity<List<Call>> responseEntity = callsController.getCallsByDestinationPhone(destinationPhone);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }
}

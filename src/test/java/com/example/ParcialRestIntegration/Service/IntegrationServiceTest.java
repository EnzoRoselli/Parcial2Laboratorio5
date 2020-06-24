package com.example.ParcialRestIntegration.Service;

import com.example.ParcialRestIntegration.Domains.Call;
import com.example.ParcialRestIntegration.Services.IntegrationService;
import com.example.ParcialRestIntegration.Services.integration.IntegrationComponent;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class IntegrationServiceTest {

    @Autowired
    @InjectMocks
    IntegrationService integrationService;
    @Mock
    IntegrationComponent integrationComponent;

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

        when(integrationComponent.getCallsByDestinationPhoneFromApi(destinationPhone)).thenReturn((ResponseEntity<List<Call>>) callList);

        ResponseEntity<List<Call>> responseEntity = integrationService.getCallsByDestinationPhone(destinationPhone);

        assertEquals(callList, responseEntity);
    }
}

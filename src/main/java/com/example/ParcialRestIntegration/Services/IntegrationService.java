package com.example.ParcialRestIntegration.Services;

import com.example.ParcialRestIntegration.Domains.Call;
import com.example.ParcialRestIntegration.Services.integration.IntegrationComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegrationService {
    @Autowired
    IntegrationComponent integrationComponent;

    public ResponseEntity<List<Call>> getCallsByDestinationPhone(String destinationPhone) {
        return integrationComponent.getCallsByDestinationPhoneFromApi(destinationPhone);
    }

}

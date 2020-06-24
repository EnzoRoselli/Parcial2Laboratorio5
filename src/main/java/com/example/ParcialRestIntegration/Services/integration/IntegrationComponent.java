package com.example.ParcialRestIntegration.Services.integration;

import com.example.ParcialRestIntegration.Domains.Call;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class IntegrationComponent {

    private RestTemplate rest;
    private static String getCallsByDestinationPhoneURL = "http://localhost:8080/callsManagement/calls";

    @PostConstruct
    private void init() {
        rest = new RestTemplateBuilder()
                .build();
    }

    public ResponseEntity<List<Call>> getCallsByDestinationPhoneFromApi(String destinationPhone){
        String url = getCallsByDestinationPhoneURL + "/" + destinationPhone;
        ResponseEntity<List<Call>> list;

        list = rest.exchange(url, HttpMethod.GET,null, new ParameterizedTypeReference<List<Call>>(){});

        return list;
    }
}

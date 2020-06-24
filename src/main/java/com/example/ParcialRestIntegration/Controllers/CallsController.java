package com.example.ParcialRestIntegration.Controllers;

import com.example.ParcialRestIntegration.Domains.Call;
import com.example.ParcialRestIntegration.Services.IntegrationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calls")
public class CallsController {

    @Autowired
    IntegrationService integrationService;

    @ApiOperation(value = "View all the calls for an specific destination phone",response = List.class,responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200 , message = "Complete list of calls"),
            @ApiResponse(code = 204 , message = "The calls's list is empty")
    })
    @GetMapping("/{destinationPhone}")
    public ResponseEntity<List<Call>> getCallsByDestinationPhone(@PathVariable("destinationPhone") String destinationPhone){
        return  integrationService.getCallsByDestinationPhone(destinationPhone);
    }
}

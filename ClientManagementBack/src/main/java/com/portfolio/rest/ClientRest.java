package com.portfolio.rest;

import com.portfolio.api.ClientApi;
import com.portfolio.api.models.Client;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@AllArgsConstructor
public class ClientRest {

    private final ClientApi clientApi;

    @Operation(
            summary = "Creates a client",
            description = "Creates a client with the body loaded in the request"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client created correctly"),
            @ApiResponse(responseCode = "404", description = "Client couldn't be created"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/createClient")
    public void createClient(@RequestBody Client client) {
        clientApi.createClient(client);
    }

    @ApiResponse(responseCode = "200", description = "Tasks returned correctly")
    @GetMapping("/getTasks")
    public Stream<Client> getTasks() {
        return clientApi.getClients();
    }
}

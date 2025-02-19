package com.portfolio.rest;

import com.portfolio.api.ClientApi;
import com.portfolio.api.models.Client;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void createClient(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Object Client that will be created",
            required = true,
            content = @Content(mediaType = "application/json"))@RequestBody Client client) {
        clientApi.createClient(client);
    }

    @Operation(
            summary = "Gets all the clients",
            description = "Gets all the clients from the database PostgresSQL"
    )
    @ApiResponse(responseCode = "200", description = "Tasks returned correctly")
    @GetMapping("/getClients")
    public List<Client> getClients() {
        return clientApi.getClients();
    }

    @Operation(
            summary = "Updates a client",
            description = "Updates a client with the body loaded in the request"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client updated correctly"),
            @ApiResponse(responseCode = "404", description = "Client not found with the id indicated"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/updateClient")
    public void updateClient(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Object Client with the fields to update",
            required = true,
            content = @Content(mediaType = "application/json")) @RequestBody Client client) {
        clientApi.updateClient(client);
    }

    @Operation(
            summary = "Removes a client",
            description = "Removes an existing client from the data base using the ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client removed correctly"),
            @ApiResponse(responseCode = "404", description = "Client not found with the id indicated"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/deleteClient/{idClient}")
    public void deleteClient(@Parameter(description = "ID from the client to be eliminated",
            example = "123e4567-e89b-12d3-a456-426614174000") @PathVariable("idClient") String idClient) {
        clientApi.deleteClient(idClient);
    }

    @Operation(
            summary = "Gets an specific client",
            description = "Get the client with the id indicated in the parameter"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client found correctly"),
            @ApiResponse(responseCode = "404", description = "Client not found with the id indicated"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/getClientById/{idClient}")
    public Client getClientById(@Parameter(description = "ID from the client to find",
            example = "123e4567-e89b-12d3-a456-426614174000") @PathVariable("idClient") String idClient) {
        return clientApi.getClient(idClient);
    }
}

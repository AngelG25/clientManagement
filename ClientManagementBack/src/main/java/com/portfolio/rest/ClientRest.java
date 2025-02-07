package com.portfolio.rest;

import com.portfolio.api.ClientApi;
import com.portfolio.api.models.Client;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ClientRest {

    private final ClientApi clientApi;

    @PostMapping("/createClient")
    public void createClient(@RequestBody Client client) {
        clientApi.createClient(client);
    }
}

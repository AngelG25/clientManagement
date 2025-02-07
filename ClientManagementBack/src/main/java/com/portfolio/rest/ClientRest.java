package com.portfolio.rest;

import com.portfolio.api.ClientApi;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ClientRest {

    private final ClientApi clientApi;
}

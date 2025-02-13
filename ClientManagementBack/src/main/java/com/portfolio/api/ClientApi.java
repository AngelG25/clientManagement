package com.portfolio.api;

import com.portfolio.api.models.Client;

import java.util.stream.Stream;

public interface ClientApi {

    void createClient(Client client);

    Stream<Client> getClients();
}

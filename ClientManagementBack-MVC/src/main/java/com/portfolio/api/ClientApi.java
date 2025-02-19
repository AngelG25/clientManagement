package com.portfolio.api;

import com.portfolio.api.models.Client;

import java.util.List;

public interface ClientApi {

    void createClient(Client client);

    List<Client> getClients();

    Client getClient(String clientId);

    void updateClient(Client client);

    void deleteClient(String idClient);
}

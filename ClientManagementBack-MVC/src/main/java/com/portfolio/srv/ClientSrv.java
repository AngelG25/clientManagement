package com.portfolio.srv;

import com.portfolio.api.ClientApi;
import com.portfolio.api.exceptions.ClientNotFoundException;
import com.portfolio.api.models.Client;
import com.portfolio.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
@Log4j2
public class ClientSrv implements ClientApi {

    private final ClientRepository clientRepository;

    private static final String CLIENT_ID = "Client with id: ";
    private static final String NOT_FOUND = " couldn't be found";

    @Override
    public void createClient(Client client) {
        log.info("Creating user...");
        clientRepository.save(client);
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClient(String clientId) {
        return clientRepository.findById(UUID.fromString(clientId))
                .orElseThrow(() -> new ClientNotFoundException(CLIENT_ID + clientId + NOT_FOUND));
    }

    @Override
    public void updateClient(Client client) {
        log.info("Updating client..");
        clientRepository.findById(client.getIdClient())
                .orElseThrow(() -> new ClientNotFoundException(CLIENT_ID + client.getIdClient() + NOT_FOUND));
        clientRepository.save(client);
    }

    @Override
    public void deleteClient(String idClient) {
        clientRepository.findById(UUID.fromString(idClient))
                .orElseThrow(() -> new ClientNotFoundException(CLIENT_ID + idClient + NOT_FOUND));
        clientRepository.deleteById(UUID.fromString(idClient));
    }
}

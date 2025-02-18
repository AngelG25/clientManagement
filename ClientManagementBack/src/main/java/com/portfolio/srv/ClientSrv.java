package com.portfolio.srv;

import com.portfolio.api.ClientApi;
import com.portfolio.api.exceptions.ClientNotFoundException;
import com.portfolio.api.models.Client;
import com.portfolio.dao.ClientDao;
import com.portfolio.repositories.ClientRepository;
import com.portfolio.srv.utils.ClientMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ClientSrv implements ClientApi {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    private static final String CLIENT_ID = "Client with id: ";
    private static final String NOT_FOUND = " couldn't be found";

    @Override
    public void createClient(Client client) {
        final ClientDao clientDao = clientMapper.toClientDao(client);
        clientRepository.save(clientDao);
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toClientDto)
                .toList();
    }

    @Override
    public Client getClient(String clientId) {
        final ClientDao clientDao = clientRepository.findById(UUID.fromString(clientId))
                .orElseThrow(() -> new ClientNotFoundException(CLIENT_ID + clientId + NOT_FOUND));
        return clientMapper.toClientDto(clientDao);
    }

    @Override
    public void updateClient(Client client) {

    }
}

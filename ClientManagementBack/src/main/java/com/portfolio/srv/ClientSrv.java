package com.portfolio.srv;

import com.portfolio.api.ClientApi;
import com.portfolio.api.models.Client;
import com.portfolio.dao.ClientDao;
import com.portfolio.repositories.ClientRepository;
import com.portfolio.srv.utils.ClientMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@AllArgsConstructor
@Service
public class ClientSrv implements ClientApi {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public void createClient(Client client) {
        final ClientDao clientDao = clientMapper.toClientDao(client);
        clientRepository.save(clientDao);
    }

    @Override
    public Stream<Client> getClients() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toClientDto);
    }
}

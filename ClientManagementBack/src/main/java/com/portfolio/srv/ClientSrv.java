package com.portfolio.srv;

import com.portfolio.api.ClientApi;
import com.portfolio.api.models.Client;
import com.portfolio.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClientSrv implements ClientApi {

    private final ClientRepository clientRepository;

    @Override
    public void createClient(Client client) {
        clientRepository.save(client);
    }
}

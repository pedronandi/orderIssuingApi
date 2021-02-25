package com.challenge.orderIssuingApi.services;

import com.challenge.orderIssuingApi.models.Client;
import com.challenge.orderIssuingApi.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getById(Integer id) {
        return clientRepository.findById(id);
    }

    @Override
    public boolean exists(Client newClient) {
        for (Client client : getAll()) {
            if(client.equals(newClient))
                return true;
        }

        return false;
    }
}

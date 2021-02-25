package com.challenge.orderIssuingApi.services;

import com.challenge.orderIssuingApi.models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    public Client save(Client client);

    public List<Client> getAll();

    public Optional<Client> getById(Integer id);

    public boolean exists(Client newClient);
}
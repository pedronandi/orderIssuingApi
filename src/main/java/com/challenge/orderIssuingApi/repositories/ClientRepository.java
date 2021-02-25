package com.challenge.orderIssuingApi.repositories;

import com.challenge.orderIssuingApi.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}

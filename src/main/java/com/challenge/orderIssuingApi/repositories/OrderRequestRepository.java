package com.challenge.orderIssuingApi.repositories;

import com.challenge.orderIssuingApi.models.OrderRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRequestRepository extends JpaRepository<OrderRequest, Integer> {

}
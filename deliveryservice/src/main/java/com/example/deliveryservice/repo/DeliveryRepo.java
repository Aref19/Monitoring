package com.example.deliveryservice.repo;


import com.example.deliveryservice.model.DeliveryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DeliveryRepo extends JpaRepository<DeliveryDetails, UUID> {
    List<DeliveryDetails> findByDriverId(UUID id);
}

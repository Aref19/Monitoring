package com.example.user_service.repository;

import com.example.user_service.model.Receiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReceiverRepo extends JpaRepository<Receiver, UUID> {
}

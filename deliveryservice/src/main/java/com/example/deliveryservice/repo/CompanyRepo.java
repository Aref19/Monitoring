package com.example.deliveryservice.repo;

import com.example.deliveryservice.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface CompanyRepo extends JpaRepository<Company, UUID> {
    Optional<Company> findByCompanyName(String name);
}

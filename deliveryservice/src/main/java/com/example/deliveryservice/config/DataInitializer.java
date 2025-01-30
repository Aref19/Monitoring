package com.example.deliveryservice.config;

import com.example.deliveryservice.model.Companies;
import com.example.deliveryservice.model.Company;
import com.example.deliveryservice.repo.CompanyRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {

    CompanyRepo companyRepo;

    public DataInitializer(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Company company = new Company();
        Company company1 = new Company();
        Company company2 = new Company();
        company.setCompanyId(UUID.randomUUID());
        company.setCompanyName(Companies.DHL.toString());
        company1.setCompanyId(UUID.randomUUID());
        company1.setCompanyName(Companies.UPS.toString());
        company2.setCompanyId(UUID.randomUUID());
        company2.setCompanyName(Companies.HERMES.toString());
        companyRepo.saveAll(List.of(company, company1, company2));


    }
}

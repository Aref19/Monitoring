package com.example.deliveryservice.services;


import com.example.deliveryservice.dto.*;
import com.example.deliveryservice.feigenConfig.DriverFeign;
import com.example.deliveryservice.feigenConfig.TracingFeign;
import com.example.deliveryservice.feigenConfig.UserFeign;
import com.example.deliveryservice.model.Company;
import com.example.deliveryservice.model.DeliveryDetails;
import com.example.deliveryservice.repo.CompanyRepo;
import com.example.deliveryservice.repo.DeliveryRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DeliveryService {

    DeliveryRepo deliveryRepo;
    CompanyRepo companyRepo;
    DriverFeign driverFeign;
    TracingFeign tracingFeign;
    UserFeign userFeign;

    public DeliveryService(DeliveryRepo deliveryRepo, CompanyRepo companyRepo, DriverFeign driverFeign, TracingFeign tracingFeign, UserFeign userFeign) {
        this.deliveryRepo = deliveryRepo;
        this.companyRepo = companyRepo;
        this.driverFeign = driverFeign;
        this.tracingFeign = tracingFeign;
        this.userFeign = userFeign;
    }


    public UUID saveDelivery(DataFromUser dataFromUser) throws Exception {
        Company company = companyRepo.findByCompanyName(dataFromUser.getDeliveryCompany()).get();
        return saveDeliveryDetails(company, dataFromUser);
    }

    private UUID saveDeliveryDetails(Company company, DataFromUser dataFromUser) {
        UUID driverId = getDriver();
        UUID tracingId = tracingFeign.getTracingId();
        UUID deliveryId = UUID.randomUUID();
        DeliveryDetails deliveryDetails = new DeliveryDetails(deliveryId,
                dataFromUser.getReceiver(),
                dataFromUser.getSender(),
                tracingId,
                driverId,
                dataFromUser.getPackageDetails());
        deliveryDetails.setCompany(company);
        //  company.getDeliveryDetails().add(deliveryDetails);
        deliveryRepo.save(deliveryDetails);
        //  companyRepo.save(company);
        sendDeliveryToDriver(deliveryId, driverId);
        return tracingId;

    }

    private UUID getDriver() {
        return driverFeign.findFree();
    }

    private void sendDeliveryToDriver(UUID deliveryId, UUID driverID) {
        driverFeign.assignDriver(new AssignDriverRequest(deliveryId, driverID));
    }

    public List<DriverResponse> getAllDriverOrders(UUID driverId) {
        List<DriverResponse> driverResponses = new ArrayList<>();
        List<DeliveryDetails> deliveryDetails = deliveryRepo.findByDriverId(driverId);
        deliveryDetails.forEach(detail -> {
            SenderAndReceiver sender = userFeign.user(detail.getSenderId());
            ReceiverDto receiver = sender.getReceiver();
            DriverResponse driverResponse = new DriverResponse(detail.getDriverId(), detail.getTrackingId(), sender);
            driverResponses.add(driverResponse);
        });

        return driverResponses;

    }

    public List<DeliveryDetails> getDeliveryDetails() {
        return deliveryRepo.findAll();
    }
}

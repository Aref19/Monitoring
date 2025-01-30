package com.example.deliveryservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeliveryDetails {

    @Id
    UUID uuid;
    UUID receiverId;
    UUID senderId;
    UUID trackingId;
    UUID driverId;
    String packageDetails;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    Company company;

    public DeliveryDetails(UUID uuid, UUID receiverId, UUID senderId, UUID trackingId, UUID driverId, String packageDetails) {
        this.uuid = uuid;
        this.receiverId = receiverId;
        this.senderId = senderId;
        this.trackingId = trackingId;
        this.driverId = driverId;
        this.packageDetails = packageDetails;
    }
}

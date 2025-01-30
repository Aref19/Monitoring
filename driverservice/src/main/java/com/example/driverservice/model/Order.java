package com.example.driverservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "`order`")
public class Order {
    @Id
    UUID id;
    UUID orderId;
    @ManyToOne
    @JsonIgnore
    Driver driver;

    public Order(UUID uuid, UUID orderId) {
        this.orderId = orderId;
        this.id = uuid;
    }
}

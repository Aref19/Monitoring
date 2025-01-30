package com.example.driverservice.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Driver {

    @Id
    UUID driverId;
    String email;
    Boolean status;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    List<Order> orders = new ArrayList<>();
}

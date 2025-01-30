package com.example.deliveryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
public class AssignDriverRequest {

    private UUID deliveryId;
    private UUID driverID;
}

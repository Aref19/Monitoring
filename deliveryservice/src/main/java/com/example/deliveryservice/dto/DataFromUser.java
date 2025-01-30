package com.example.deliveryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class DataFromUser {

    UUID sender;
    UUID receiver;
    String packageDetails;
    String deliveryCompany;
}

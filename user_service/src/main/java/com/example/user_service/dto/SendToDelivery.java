package com.example.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class SendToDelivery {
    UUID sender;
    UUID receiver;
    String packageDetails;
    String deliveryCompany;
}

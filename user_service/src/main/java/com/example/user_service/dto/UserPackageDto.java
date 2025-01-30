package com.example.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserPackageDto {

    private ReceiverDto receiver;
    private SenderDto sender;
    private String packageDetails;
    private String deliveryCompany;

}

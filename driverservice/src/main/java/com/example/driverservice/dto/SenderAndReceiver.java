package com.example.driverservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SenderAndReceiver {

    private String name;
    private String city;
    private String plz;
    private String street;
    private ReceiverDto receiver;

}

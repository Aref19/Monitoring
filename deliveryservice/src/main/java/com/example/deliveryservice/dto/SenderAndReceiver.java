package com.example.deliveryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SenderAndReceiver {
    private String name;
    private String city;
    private String plz;
    private String street;
    private ReceiverDto receiver;

}

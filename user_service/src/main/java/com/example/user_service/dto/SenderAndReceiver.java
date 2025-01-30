package com.example.user_service.dto;

import lombok.*;

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

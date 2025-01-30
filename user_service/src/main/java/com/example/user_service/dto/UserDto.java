package com.example.user_service.dto;


import com.example.user_service.model.Receiver;
import com.example.user_service.model.Sender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private String name;
    private String email;
    private String city;
    private String street;
    private String plz;

    public static Sender senderDtoTOSender(SenderDto senderDTo, ReceiverDto receiverDto, UUID senderId, UUID receiverId) {


        return Sender.builder()
                .id(senderId)
                .city(senderDTo.getCity())
                .plz(senderDTo.getPlz())
                .name(senderDTo.getName())
                .email(senderDTo.getEmail())
                .street(senderDTo.getStreet())
                .receiver(Receiver.builder()
                        .id(receiverId)
                        .plz(receiverDto.getPlz())
                        .street(receiverDto.getStreet())
                        .email(receiverDto.getEmail())
                        .city(receiverDto.getCity())
                        .name(receiverDto.getName())
                        .build())
                .build();
    }


}

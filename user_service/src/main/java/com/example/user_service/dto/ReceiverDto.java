package com.example.user_service.dto;


import com.example.user_service.model.Receiver;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
public class ReceiverDto extends UserDto {

    public static ReceiverDto fromUserToReceiverDto(Receiver receiver) {
        return ReceiverDto.builder().city(receiver.getCity())
                .plz(receiver.getPlz())
                .email(receiver.getEmail())
                .street(receiver.getStreet())

                .name(receiver.getName())
                .build();

    }
}

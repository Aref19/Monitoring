package com.example.deliveryservice.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReceiverDto {

    private String name;
    private String email;
    private String city;
    private String street;
    private String plz;


}

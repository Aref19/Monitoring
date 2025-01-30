package com.example.user_service.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@SuperBuilder
@NoArgsConstructor
public class Receiver extends User {

    @Id
    private UUID id;

}

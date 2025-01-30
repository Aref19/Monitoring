package com.example.user_service.service;

import com.example.user_service.dto.*;
import com.example.user_service.model.Sender;
import com.example.user_service.openFeign.DeliveryFeign;
import com.example.user_service.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final DeliveryFeign deliveryFeign;

    public UserService(UserRepo userRepo, DeliveryFeign deliveryFeign) {
        this.userRepo = userRepo;
        this.deliveryFeign = deliveryFeign;
    }

    @Transactional
    public ResponseEntity<ResponseToUser> saveUserDetails(UserPackageDto userPackageDto) {
        UUID senderUUid = UUID.randomUUID();
        UUID receiverUUid = UUID.randomUUID();
        userRepo.save(UserDto.senderDtoTOSender(userPackageDto.getSender(), userPackageDto.getReceiver(), senderUUid, receiverUUid));
        UUID tracing = deliveryFeign.createDelivery(new SendToDelivery(senderUUid, receiverUUid, userPackageDto.getPackageDetails(), userPackageDto.getDeliveryCompany()));
        Logger logger = LoggerFactory.getLogger(UserService.class);
        logger.warn(tracing.toString());
        return ResponseEntity.ok(new ResponseToUser(List.of("sie können Ihr Packet mit der ID : " + tracing + " verfolgen ",
                "Ihre ID lautet: " + senderUUid
        )));
    }

    public SenderAndReceiver getUserInfo(UUID uuid) {
        SenderAndReceiver senderAndReceiver = new SenderAndReceiver();
        Optional<Sender> senderOptional = userRepo.findById(uuid);
        // deliveryFeign.createDelivery(null);
        if (senderOptional.isPresent()) {
            // If sender is found, populate SenderAndReceiver with sender details
            Sender sender = senderOptional.get();
            senderAndReceiver.setCity(sender.getCity());
            senderAndReceiver.setName(sender.getName());
            senderAndReceiver.setStreet(sender.getStreet());
            senderAndReceiver.setPlz(sender.getPlz());
            senderAndReceiver.setReceiver(ReceiverDto.fromUserToReceiverDto(sender.getReceiver()));
        }

        return senderAndReceiver;
    }

    public List<SenderAndReceiver> getAllUsers() {
        List<SenderAndReceiver> senderAndReceivers = userRepo.findAll().stream().map(allUsers -> {
            return new SenderAndReceiver();
        }).toList();

        return senderAndReceivers;
    }


}

package com.halal.notification.service;

import com.halal.clients.notification.NotificationRequest;
import com.halal.notification.model.Notification;
import com.halal.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record NotificationService(NotificationRepository notificationRepository) {

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerName())
                        .sender("MyShop")
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}

package com.halal.notification.controller;

import com.halal.clients.notification.NotificationRequest;
import com.halal.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/notification")
@Slf4j
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("New notification... {}", notificationRequest);
        notificationService.send(notificationRequest);
    }
}

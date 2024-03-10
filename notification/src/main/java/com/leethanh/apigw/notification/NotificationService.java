package com.leethanh.notification;

import com.leethanh.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record NotificationService(NotificationRepository notificationRepository) {
    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(Notification.builder()
                        .customerId(notificationRequest.customerId())
                        .customerEmail(notificationRequest.customerEmail())
                        .sender("Lee Thanh")
                        .message(notificationRequest.message())
                        .sendAt(LocalDateTime.now())
                .build());
    }
}

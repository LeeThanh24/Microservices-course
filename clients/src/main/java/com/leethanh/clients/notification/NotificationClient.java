package com.leethanh.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "NOTIFICATION") // Feign will look for a service with this name so we have to specify proper name
public interface NotificationClient {

    @PostMapping(path = "api/v1/notification")
    void  sendNotification (NotificationRequest notificationRequest);
}

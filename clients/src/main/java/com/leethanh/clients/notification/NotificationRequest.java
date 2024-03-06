package com.leethanh.clients.notification;

import java.time.LocalDateTime;

public record NotificationRequest(Integer customerId, String customerEmail , String message ) {
}

package com.leethanh.notification;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Notification {

    @Id
    @SequenceGenerator(name = "notification_sequence",
            sequenceName = "notification_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "notification_sequence")
    private Integer id ;
    private Integer  customerId;
    private String  customerEmail;
    private String sender;
    private String message;
    private LocalDateTime sendAt;
}


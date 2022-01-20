package com.halal.notification.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_id_sequence")
    @SequenceGenerator(name = "notification_id_sequence", sequenceName = "notification_id_sequence")
    private Integer notificationId;
    private Integer toCustomerId;
    private String toCustomerEmail;
    private String sender;
    private String message;
    private LocalDateTime sentAt;
}



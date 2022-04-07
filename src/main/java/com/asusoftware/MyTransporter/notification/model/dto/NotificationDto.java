package com.asusoftware.MyTransporter.notification.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class NotificationDto {

    private UUID id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private List<NotificationActionDto> notificationActionDto;
}

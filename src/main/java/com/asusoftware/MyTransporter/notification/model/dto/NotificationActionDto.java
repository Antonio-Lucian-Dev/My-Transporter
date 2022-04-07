package com.asusoftware.MyTransporter.notification.model.dto;

import com.asusoftware.MyTransporter.user.model.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class NotificationActionDto {
    private UUID id;
    private boolean isRead;
    private boolean isNew;
   // private Notification notification;
    private UserDto user;
}

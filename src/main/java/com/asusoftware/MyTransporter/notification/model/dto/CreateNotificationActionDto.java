package com.asusoftware.MyTransporter.notification.model.dto;

import com.asusoftware.MyTransporter.notification.model.Notification;
import com.asusoftware.MyTransporter.user.model.User;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateNotificationActionDto {

    private Notification notification;
    private User user;
}

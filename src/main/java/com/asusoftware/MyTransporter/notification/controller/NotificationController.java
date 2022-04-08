package com.asusoftware.MyTransporter.notification.controller;

import com.asusoftware.MyTransporter.notification.model.dto.NotificationDto;
import com.asusoftware.MyTransporter.notification.model.dto.UpdateNotificationActionDto;
import com.asusoftware.MyTransporter.notification.service.NotificationActionService;
import com.asusoftware.MyTransporter.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/notification")
public class NotificationController {

     private final NotificationService notificationService;
     private final NotificationActionService notificationActionService;

    @GetMapping(path = "/findAll")
    public List<NotificationDto> findAll() {
        return notificationService.findAll();
    }

    @PutMapping(path = "/update/{id}/{userId}")
    public void updateNotificationAction(@PathVariable(name = "id") UUID notificationUuid,
                                         @PathVariable(name = "userId") UUID userId,
                                         @RequestBody UpdateNotificationActionDto updateNotificationActionDto) {
        notificationActionService.update(notificationUuid, userId, updateNotificationActionDto);
    }
}

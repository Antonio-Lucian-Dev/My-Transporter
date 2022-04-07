package com.asusoftware.MyTransporter.notification.controller;

import com.asusoftware.MyTransporter.notification.model.dto.NotificationDto;
import com.asusoftware.MyTransporter.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/notification")
public class NotificationController {

     private final NotificationService notificationService;

    @GetMapping(path = "/findAll")
    public List<NotificationDto> findAll() {
        return notificationService.findAll();
    }
}

package com.asusoftware.MyTransporter.notification.service;

import com.asusoftware.MyTransporter.notification.mappers.NotificationActionDtoEntity;
import com.asusoftware.MyTransporter.notification.model.Notification;
import com.asusoftware.MyTransporter.notification.model.NotificationAction;
import com.asusoftware.MyTransporter.notification.model.dto.CreateNotificationActionDto;
import com.asusoftware.MyTransporter.notification.model.dto.NotificationActionDto;
import com.asusoftware.MyTransporter.notification.model.dto.UpdateNotificationActionDto;
import com.asusoftware.MyTransporter.notification.repository.NotificationActionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NotificationActionService {

    private final NotificationActionRepository notificationActionRepository;
    private final NotificationActionDtoEntity notificationActionDtoEntity;

    public void create(CreateNotificationActionDto createNotificationActionDto) {
        NotificationAction notificationAction = new NotificationAction();
        notificationAction.setNew(true);
        notificationAction.setRead(false);
        notificationAction.setNotification(createNotificationActionDto.getNotification());
        notificationAction.setUser(createNotificationActionDto.getUser());
        notificationActionRepository.save(notificationAction);
    }

    public void update(UUID notificationUuid, UUID userId, UpdateNotificationActionDto updateNotificationActionDto) {
        System.out.println(updateNotificationActionDto.getIsRead());
        notificationActionRepository.findAll()
                .stream()
                .filter(notificationAction -> notificationAction.getNotification().getId().equals(notificationUuid))
                .findFirst().stream().filter(notificationAction -> notificationAction.getUser().getId().equals(userId))
                .findFirst()
                .ifPresent(notificationActionFinded -> {
                    notificationActionFinded.setRead(updateNotificationActionDto.getIsRead());
                    notificationActionFinded.setNew(false);
                    notificationActionRepository.save(notificationActionFinded);
                });
    }

    public List<NotificationActionDto> findAll() {
       return notificationActionRepository.findAll().stream().map(notificationActionDtoEntity::notificationActionToDto).collect(Collectors.toList());
    }
}

package com.asusoftware.MyTransporter.notification.service;

import com.asusoftware.MyTransporter.notification.mappers.NotificationDtoEntity;
import com.asusoftware.MyTransporter.notification.model.Notification;
import com.asusoftware.MyTransporter.notification.model.NotificationAction;
import com.asusoftware.MyTransporter.notification.model.dto.CreateNotificationActionDto;
import com.asusoftware.MyTransporter.notification.model.dto.CreateNotificationDto;
import com.asusoftware.MyTransporter.notification.model.dto.NotificationDto;
import com.asusoftware.MyTransporter.notification.repository.NotificationRepository;
import com.asusoftware.MyTransporter.user.model.User;
import com.asusoftware.MyTransporter.user.model.UserRole;
import com.asusoftware.MyTransporter.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserService userService;
    private final NotificationDtoEntity notificationDtoEntity;
    private final NotificationActionService notificationActionService;

    public void create(CreateNotificationDto createNotificationDto, UUID adminId) {
        Notification notification = new Notification();
        User admin = userService.findUserById(adminId);
        notification.setTitle(admin.getFirstName() + " " + admin.getLastName() + " a postat");
        notification.setDescription(createNotificationDto.getDescription());
        notification.setCreatedAt(LocalDateTime.now(ZoneOffset.UTC));
        notificationRepository.save(notification);

        // Per ogni user crea una notification action
        findAllUsersWithRoleUser().forEach(user -> {
            CreateNotificationActionDto createNotificationActionDto = new CreateNotificationActionDto();
            createNotificationActionDto.setNotification(notification);
            createNotificationActionDto.setUser(user);
            notificationActionService.create(createNotificationActionDto);
        });
    }

    public List<NotificationDto> findAll() {
        return notificationRepository.findAll().stream().map(notificationDtoEntity::notificationToDto).collect(Collectors.toList());
    }

    private List<User> findAllUsersWithRoleUser() {
        return userService.findAllEntity().stream().filter(user -> user.getUserRole().equals(UserRole.USER)).collect(Collectors.toList());
    }
}

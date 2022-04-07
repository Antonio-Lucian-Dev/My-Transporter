package com.asusoftware.MyTransporter.notification.mappers;

import com.asusoftware.MyTransporter.notification.model.Notification;
import com.asusoftware.MyTransporter.notification.model.dto.NotificationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {NotificationActionDtoEntity.class}, componentModel = "spring")
public interface NotificationDtoEntity {

    @Mapping(source = "notification.notificationAction", target = "notificationActionDto")
    NotificationDto notificationToDto(Notification notification);
}

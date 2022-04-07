package com.asusoftware.MyTransporter.notification.mappers;

import com.asusoftware.MyTransporter.notification.model.NotificationAction;
import com.asusoftware.MyTransporter.notification.model.dto.NotificationActionDto;
import com.asusoftware.MyTransporter.user.mappers.UserDtoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {UserDtoEntity.class}, componentModel = "spring")
public interface NotificationActionDtoEntity {

    @Mapping(source = "notificationAction.user", target = "user")
    NotificationActionDto notificationActionToDto(NotificationAction notificationAction);
}

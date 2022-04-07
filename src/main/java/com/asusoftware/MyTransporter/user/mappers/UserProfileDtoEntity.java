package com.asusoftware.MyTransporter.user.mappers;

import com.asusoftware.MyTransporter.user.model.User;
import com.asusoftware.MyTransporter.user.model.dto.UserProfileDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileDtoEntity {

    UserProfileDto userProfileToDto(User user);
}

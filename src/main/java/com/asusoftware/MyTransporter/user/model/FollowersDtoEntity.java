package com.asusoftware.MyTransporter.user.model;

import com.asusoftware.MyTransporter.user.model.dto.FollowersDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FollowersDtoEntity {
    FollowersDto userToDto(User user);
}

package com.asusoftware.MyTransporter.user.model;

import com.asusoftware.MyTransporter.user.model.dto.CreateUserDto;
import com.asusoftware.MyTransporter.user.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {FollowersDtoEntity.class}, componentModel = "spring")
public interface UserDtoEntity {

    @Mapping(source = "user.followers", target = "followersDtos")
    UserDto userToDto(User user);
    User userToEntity(CreateUserDto userDto);
}
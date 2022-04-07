package com.asusoftware.MyTransporter.user.mappers;

import com.asusoftware.MyTransporter.user.model.User;
import com.asusoftware.MyTransporter.user.model.dto.CreateUserDto;
import com.asusoftware.MyTransporter.user.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserDtoEntity {

    UserDto userToDto(User user);
    User userToEntity(CreateUserDto userDto);
}
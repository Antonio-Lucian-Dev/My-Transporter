package com.asusoftware.MyTransporter.user.mappers;

import com.asusoftware.MyTransporter.user.model.User;
import com.asusoftware.MyTransporter.user.model.dto.UserAdminProfileDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {FollowersDtoEntity.class}, componentModel = "spring")
public interface UserAdminProfileDtoEntity {

    @Mapping(source = "user.followers", target = "followersDtos")
    UserAdminProfileDto userProfileAdminEntityToDto(User user);
}

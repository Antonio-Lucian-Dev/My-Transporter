package com.asusoftware.MyTransporter.user.mappers;

import com.asusoftware.MyTransporter.user.model.User;
import com.asusoftware.MyTransporter.user.model.dto.UserProfileDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {FollowersDtoEntity.class}, componentModel = "spring")
public interface UserProfileDtoEntity {

    @Mapping(source = "user.followers", target = "followersDtos")
    UserProfileDto userProfileToDto(User user);
}

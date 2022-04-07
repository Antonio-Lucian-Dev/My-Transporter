package com.asusoftware.MyTransporter.user.model;

import org.mapstruct.Mapper;

@Mapper(uses = {FollowersDtoEntity.class}, componentModel = "spring")
public interface UserAdminProfileDtoEntity {
}

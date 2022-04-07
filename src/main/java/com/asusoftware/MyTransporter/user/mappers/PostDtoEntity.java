package com.asusoftware.MyTransporter.user.mappers;

import com.asusoftware.MyTransporter.user.model.Post;
import com.asusoftware.MyTransporter.user.model.dto.CreatePostDto;
import com.asusoftware.MyTransporter.user.model.dto.PostDto;
import com.asusoftware.MyTransporter.user.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {UserDto.class}, componentModel = "spring")
public interface PostDtoEntity {

    @Mapping(source = "post.user", target = "userDto")
    PostDto postToDto(Post post);
    Post postToEntity(CreatePostDto createPostDto);
}

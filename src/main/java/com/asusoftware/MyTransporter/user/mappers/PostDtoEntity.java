package com.asusoftware.MyTransporter.user.mappers;

import com.asusoftware.MyTransporter.user.model.Post;
import com.asusoftware.MyTransporter.user.model.dto.CreatePostDto;
import com.asusoftware.MyTransporter.user.model.dto.PostDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostDtoEntity {
    PostDto postToDto(Post post);
    Post postToEntity(CreatePostDto createPostDto);
}

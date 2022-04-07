package com.asusoftware.MyTransporter.user.service;

import com.asusoftware.MyTransporter.user.model.Post;
import com.asusoftware.MyTransporter.user.model.PostDtoEntity;
import com.asusoftware.MyTransporter.user.model.User;
import com.asusoftware.MyTransporter.user.model.dto.CreatePostDto;
import com.asusoftware.MyTransporter.user.model.dto.PostDto;
import com.asusoftware.MyTransporter.user.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;
    private final PostDtoEntity postDtoEntity;

    public void create(UUID id, CreatePostDto createPostDto) {
        User user = userService.findUserById(id);
        Post post = postDtoEntity.postToEntity(createPostDto);
        post.setCreatedAt(LocalDateTime.now(ZoneOffset.UTC));
        post.setUser(user);
        postRepository.save(post);
    }

    public List<PostDto> findAll() {
        return postRepository.findAll().stream().map(postDtoEntity::postToDto).collect(Collectors.toList());
    }
}

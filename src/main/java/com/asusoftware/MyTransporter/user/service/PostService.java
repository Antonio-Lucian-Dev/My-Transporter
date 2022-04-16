package com.asusoftware.MyTransporter.user.service;

import com.asusoftware.MyTransporter.notification.model.dto.CreateNotificationDto;
import com.asusoftware.MyTransporter.notification.service.NotificationService;
import com.asusoftware.MyTransporter.user.model.Post;
import com.asusoftware.MyTransporter.user.mappers.PostDtoEntity;
import com.asusoftware.MyTransporter.user.model.User;
import com.asusoftware.MyTransporter.user.model.dto.CreatePostDto;
import com.asusoftware.MyTransporter.user.model.dto.PostDto;
import com.asusoftware.MyTransporter.user.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    private final NotificationService notificationService;

    public void create(UUID id, CreatePostDto createPostDto) {
        User user = userService.findUserById(id);
        Post post = postDtoEntity.postToEntity(createPostDto);
        post.setCreatedAt(LocalDateTime.now(ZoneOffset.UTC));
        post.setUser(user);
        postRepository.save(post);
        CreateNotificationDto createNotificationDto = new CreateNotificationDto();
        createNotificationDto.setDescription(createPostDto.getDescription());
        notificationService.create(createNotificationDto, id);
    }

    public List<PostDto> findAll(int pageNumber) {
        PageRequest pageRequest = PageRequest.of(pageNumber, 5, Sort.by("createdAt").ascending());
        return postRepository.findAll(pageRequest).stream().map(postDtoEntity::postToDto).collect(Collectors.toList());
    }
}

package com.asusoftware.MyTransporter.user.model.dto;

import com.asusoftware.MyTransporter.user.model.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class PostDto {

    private UUID id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private String currentCity;
    private User user;
}

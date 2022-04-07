package com.asusoftware.MyTransporter.user.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "Post")
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;


    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "current_city", nullable = false)
    private String currentCity;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
}

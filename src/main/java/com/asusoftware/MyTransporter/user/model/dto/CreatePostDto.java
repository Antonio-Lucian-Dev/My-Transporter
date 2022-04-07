package com.asusoftware.MyTransporter.user.model.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreatePostDto {
    private String title;
    private String description;
    private String currentCity;
}

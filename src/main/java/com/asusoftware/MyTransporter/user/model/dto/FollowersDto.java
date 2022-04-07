package com.asusoftware.MyTransporter.user.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class FollowersDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String currentCity;
    private String email;
    private String phoneNumber;
    private LocalDate birthday;
}

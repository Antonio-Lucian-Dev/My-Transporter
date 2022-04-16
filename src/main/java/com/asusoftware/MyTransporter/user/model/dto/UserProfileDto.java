package com.asusoftware.MyTransporter.user.model.dto;

import com.asusoftware.MyTransporter.user.model.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserProfileDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String country;
    private String city;
    private String email;
    private String phoneNumber;
    private LocalDate birthday;
    private UserRole userRole;
    // urmarit
    private UserDto followed;
    // urmaritori
    private List<FollowersDto> followersDtos;
}

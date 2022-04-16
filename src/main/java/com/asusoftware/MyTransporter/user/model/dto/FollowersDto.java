package com.asusoftware.MyTransporter.user.model.dto;

import com.asusoftware.MyTransporter.user.model.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class FollowersDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String country;
    private String city;
    //private String email;
    private String phoneNumber;
    //private LocalDate birthday;
    private UserRole userRole;
}

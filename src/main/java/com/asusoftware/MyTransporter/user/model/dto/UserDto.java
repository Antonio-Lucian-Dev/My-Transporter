package com.asusoftware.MyTransporter.user.model.dto;

import com.asusoftware.MyTransporter.user.model.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String currentCity;
    //private String email;
    //private String phoneNumber;
   // private String password;
    //private LocalDate birthday;
   // private UserRole userRole;
    // urmarit
    //private UserDto followed;
    // urmaritori
    //private List<FollowersDto> followersDtos;
}

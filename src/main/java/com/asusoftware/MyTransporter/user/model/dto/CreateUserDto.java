package com.asusoftware.MyTransporter.user.model.dto;

import com.asusoftware.MyTransporter.user.model.UserRole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class CreateUserDto {

    private String firstName;
    private String lastName;
    private String country;
    private String city;
    private String email;
    private String phoneNumber;
    private String password;
    private LocalDate birthday;
    private UserRole userRole;
}

package com.asusoftware.MyTransporter.user.controller;

import com.asusoftware.MyTransporter.user.model.dto.CreateUserDto;
import com.asusoftware.MyTransporter.user.model.dto.UserDto;
import com.asusoftware.MyTransporter.user.model.dto.UserProfileDto;
import com.asusoftware.MyTransporter.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/user")
public class UserController {


    private final UserService userService;

    @PostMapping(path = "/create")
    public void create(@RequestBody CreateUserDto createUserDto) {
        userService.create(createUserDto);
    }

    @GetMapping(path = "/findAll")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    /*
     * Retrieve user profile
     */
    @GetMapping(path = "/userProfile/{id}")
    public UserProfileDto findUserProfile(@PathVariable(name = "id") UUID id) {
        return userService.findUserProfileById(id);
    }

    /* @GetMapping(path = "/findUserByCity/{cityName}")
    public void findUserByCity(@PathVariable(name = "cityName") String city) {} */

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable(name = "id") UUID id) {
        userService.delete(id);
    }
}

package com.asusoftware.MyTransporter.user.controller;

import com.asusoftware.MyTransporter.user.model.dto.CreateUserDto;
import com.asusoftware.MyTransporter.user.model.dto.UserDto;
import com.asusoftware.MyTransporter.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(path = "/findUserByCity/{cityName}")
    public void findUserByCity(@PathVariable(name = "cityName") String city) {}

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable(name = "id") UUID id) {}
}

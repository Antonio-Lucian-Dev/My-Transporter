package com.asusoftware.MyTransporter.user.controller;

import com.asusoftware.MyTransporter.jwt.JWTUtility;
import com.asusoftware.MyTransporter.user.model.dto.*;
import com.asusoftware.MyTransporter.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/user")
public class UserController {


    private final UserService userService;
    private final JWTUtility jwtUtility;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    @PostMapping(path = "/create")
    public void create(@RequestBody CreateUserDto createUserDto) {
        userService.create(createUserDto);
    }

    @GetMapping(path = "/findAll")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @PostMapping(path = "/login")
    public JwtResponse authenticate(@RequestBody Login login) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            login.getUsername(),
                            login.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw  new Exception("Invalid credentials", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(login.getUsername());
        final String token = jwtUtility.generateToken(userDetails);
        return new JwtResponse(token);

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

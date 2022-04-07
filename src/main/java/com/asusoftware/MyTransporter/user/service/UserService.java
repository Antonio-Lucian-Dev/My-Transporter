package com.asusoftware.MyTransporter.user.service;

import com.asusoftware.MyTransporter.user.model.FollowersDtoEntity;
import com.asusoftware.MyTransporter.user.model.User;
import com.asusoftware.MyTransporter.user.model.UserDtoEntity;
import com.asusoftware.MyTransporter.user.model.UserRole;
import com.asusoftware.MyTransporter.user.model.dto.CreateUserDto;
import com.asusoftware.MyTransporter.user.model.dto.UserDto;
import com.asusoftware.MyTransporter.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoEntity userDtoEntity;

    public void create(CreateUserDto createUserDto) {
        User user = userDtoEntity.userToEntity(createUserDto);
        if(user.getUserRole().equals(UserRole.ADMIN)) {
            userRepository.save(user);
        } else {
            User userAdmin = userRepository.findUserByUserRoleAdmin();
            if(userAdmin != null) {
                List<User> followers = userRepository.findUserByUserRoleUser();
                followers.add(user);
                userAdmin.setFollowers(followers);
                user.setFollowed(userAdmin);
                userRepository.save(user);
            }
        }
    }

    public User findUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(userDtoEntity::userToDto).collect(Collectors.toList());
    }
}

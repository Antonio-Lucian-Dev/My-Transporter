package com.asusoftware.MyTransporter.auth;

import com.asusoftware.MyTransporter.user.model.User;

import java.util.Optional;

public interface ApplicationUserDao {
    Optional<User> selectApplicationUserByUsername(String username);
}

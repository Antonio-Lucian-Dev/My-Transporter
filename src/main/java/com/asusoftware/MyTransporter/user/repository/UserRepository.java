package com.asusoftware.MyTransporter.user.repository;

import com.asusoftware.MyTransporter.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("SELECT u FROM Users u WHERE u.userRole = com.asusoftware.MyTransporter.user.model.UserRole.ADMIN")
    User findUserByUserRoleAdmin();

    @Query("SELECT u FROM Users u WHERE u.userRole = com.asusoftware.MyTransporter.user.model.UserRole.USER")
    List<User> findUserByUserRoleUser();

    Optional<User> findByEmail(String email);
}

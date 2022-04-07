package com.asusoftware.MyTransporter.notification.repository;

import com.asusoftware.MyTransporter.notification.model.NotificationAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NotificationActionRepository extends JpaRepository<NotificationAction, UUID> {
}

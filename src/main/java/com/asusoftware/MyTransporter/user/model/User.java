package com.asusoftware.MyTransporter.user.model;

import com.asusoftware.MyTransporter.notification.model.NotificationAction;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "Users")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private UserRole userRole;

    // Un user poatea avea mai multi urmaritori
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "follower_id", referencedColumnName = "id")
    public List<User> followers;

    // Mai multi useri au doar un urmarit
    @ManyToOne
    @JoinColumn(name = "follower_id", referencedColumnName = "id")
    public User followed;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<NotificationAction> notificationAction;


    /*
    @OneToMany(mappedBy = "user")
    private List<Post> posts; */

}

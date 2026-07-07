package com.docs.user.entity;

import com.docs.common.entity.BaseEntity;
import com.docs.user.enums.UserRole;
import com.docs.user.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "users" ,
        indexes = {@Index(name = "idx_user_email",
                columnList = "email")}
        )
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(length = 100)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String profileImageUrl;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

}

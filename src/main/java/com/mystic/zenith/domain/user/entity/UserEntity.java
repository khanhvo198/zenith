package com.mystic.zenith.domain.user.entity;

import com.mystic.zenith.shared.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "users")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String password;

    private String bio;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @OneToMany(mappedBy = "follower")
    private Set<FollowEntity> follower;

    @OneToMany(mappedBy = "following")
    private Set<FollowEntity> following;

}

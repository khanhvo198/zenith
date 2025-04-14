package com.mystic.zenith.shared.entity;

import com.mystic.zenith.domain.user.entity.UserEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "follows")
public class FollowEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "follower_id", nullable = false)
    private UserEntity follower;

    @ManyToOne
    @JoinColumn(name = "following_id", nullable = false)
    private UserEntity following;
}


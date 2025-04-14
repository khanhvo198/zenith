package com.mystic.zenith.domain.post.entity;

import com.mystic.zenith.domain.comment.entity.CommentEntity;
import com.mystic.zenith.shared.entity.BaseEntity;
import com.mystic.zenith.domain.user.entity.UserEntity;
import com.mystic.zenith.shared.entity.FavoriteEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "posts")
public class PostEntity extends BaseEntity {

    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity author;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentEntity> comments;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FavoriteEntity> favorites;
}

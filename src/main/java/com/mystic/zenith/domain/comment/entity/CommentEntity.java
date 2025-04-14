package com.mystic.zenith.domain.comment.entity;

import com.mystic.zenith.domain.post.entity.PostEntity;
import com.mystic.zenith.shared.entity.BaseEntity;
import com.mystic.zenith.domain.user.entity.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class CommentEntity extends BaseEntity {

    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity author;
}

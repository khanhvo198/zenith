package com.mystic.zenith.domain.image.entity;


import com.mystic.zenith.domain.post.entity.PostEntity;
import com.mystic.zenith.domain.user.entity.UserEntity;
import com.mystic.zenith.shared.entity.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class ImageEntity extends BaseEntity {

    private String url;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity author;

}

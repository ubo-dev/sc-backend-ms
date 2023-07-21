package com.ubo.scmicroservices.postservice.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "post")
@Data
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "description")
    private String description;

    @Column(name = "number_of_likes")
    private int likeNumber;

    @OneToMany
    @JoinColumn(name = "user_id", nullable = false,insertable=false, updatable=false)
    private Set<Comment> comment;

}

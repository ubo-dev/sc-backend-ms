package com.ubo.scmicroservices.postservice.model.entity;

import jakarta.persistence.*;

@Entity(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private String description;
}

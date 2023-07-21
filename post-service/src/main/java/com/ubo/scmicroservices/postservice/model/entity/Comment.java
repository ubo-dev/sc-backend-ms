package com.ubo.scmicroservices.postservice.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "comment")
@Data
public class Comment extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "comment_description")
    private String commentDescription;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false,insertable=false, updatable=false)
    private Post post;


}

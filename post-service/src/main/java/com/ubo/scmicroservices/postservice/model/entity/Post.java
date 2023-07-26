package com.ubo.scmicroservices.postservice.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "post")
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @Column(name = "description")
    private String description;

    @Column(name = "number_of_likes")
    private int likeNumber;

    @OneToMany(mappedBy = "post")
    private List<Comment> comment;

}

package com.ubo.scmicroservices.postservice.repository;

import com.ubo.scmicroservices.postservice.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    public List<Post> getPostByUserId(Long userId);
}

package com.ubo.scmicroservices.postservice.repository;

import com.ubo.scmicroservices.postservice.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}

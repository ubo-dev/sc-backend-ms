package com.ubo.scmicroservices.postservice.repository;

import com.ubo.scmicroservices.postservice.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    void deleteAllByPostIdAfter(Long id);
}

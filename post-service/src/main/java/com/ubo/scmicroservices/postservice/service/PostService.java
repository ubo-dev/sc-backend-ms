package com.ubo.scmicroservices.postservice.service;

import com.ubo.scmicroservices.postservice.constants.ScConstants;
import com.ubo.scmicroservices.postservice.exception.PostNotFoundException;
import com.ubo.scmicroservices.postservice.model.entity.Post;
import com.ubo.scmicroservices.postservice.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PostService
{
    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void createPost(Post post)
    {
        post.setCreatedAt(LocalDateTime.now());
        post.setCreatedBy(ScConstants.USER_ROLE);
        postRepository.save(post);
    }

    public Post getPostById(Long id) {
        Optional<Post> optional = postRepository.findById(id);

        if (optional.isPresent())
        {
            log.info("Post with Id: " + id + " is listed.");
            return optional.get();
        }


        throw new PostNotFoundException("Post not found with ID: " + id);
    }

    public List<Post> getAllPosts()
    {
        log.info("All Posts are listed.");
        return postRepository.findAll();
    }


    public Post updatePost(Post post) {
        post.setUpdatedAt(LocalDateTime.now());
        post.setUpdatedBy(ScConstants.USER_ROLE);
        return postRepository.save(post);
    }

    public void deletePostsAfterId(Long id)
    {
        postRepository.deleteAllByPostIdAfter(id);
    }

    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }






}

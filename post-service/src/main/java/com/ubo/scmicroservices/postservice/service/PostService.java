package com.ubo.scmicroservices.postservice.service;

import com.ubo.scmicroservices.postservice.constants.ScConstants;
import com.ubo.scmicroservices.postservice.exception.PostNotFoundException;
import com.ubo.scmicroservices.postservice.model.entity.Post;
import com.ubo.scmicroservices.postservice.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

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

    public List<Post> getAllPostOfUser(Long userId) {

        List<Post> list = getAllPosts();

        Predicate<? super Post> predicate = post -> list.stream().map(post1 -> post.getUserId().equals(userId)).isParallel();
        Optional<Post> optional = list.stream().filter(predicate).findFirst();

        if (optional.isPresent())
        {
            log.info("All posts of the user with ID: " + userId + " are listed.");
            return postRepository.getPostByUserId(userId);
        }

        throw new PostNotFoundException("User with ID: " + userId + " has no post.");
    }


    public Post updatePost(Post postObject, Post post) {

        postObject.setUserId(post.getUserId());
        postObject.setDescription(post.getDescription());
        postObject.setLikeNumber(post.getLikeNumber());
        postObject.setComment(post.getComment());
        postObject.setUpdatedAt(LocalDateTime.now());
        postObject.setUpdatedBy(ScConstants.USER_ROLE);

        return postRepository.save(postObject);
    }

    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }






}

package com.ubo.scmicroservices.postservice.controller;

import com.ubo.scmicroservices.postservice.model.Response;
import com.ubo.scmicroservices.postservice.model.entity.Post;
import com.ubo.scmicroservices.postservice.service.PostService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post")
    public List<Post> getAllPost() {
        return postService.getAllPosts();
    }

    @GetMapping("/post/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }



    @PostMapping("/post")
    public ResponseEntity<Response> createPost(@Valid @RequestBody Post post)
    {
        postService.createPost(post);

        Response response = new Response();

        response.setStatusCode("200");
        response.setStatusMessage("Post created successfully.");

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("isPostCreated", "true")
                .body(response);
    }


    @PutMapping("/post/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post)
    {
        Post postObject = postService.getPostById(id);

        if (postObject != null) return new ResponseEntity<>(postService.updatePost(postObject,post),HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<Response> deletePost(@PathVariable Long id) {
        postService.deletePostById(id);

        Response response = new Response();
        response.setStatusCode("200");
        response.setStatusMessage("Post with ID: " + id + " successfully deleted.");

        return ResponseEntity
                .status(HttpStatus.OK)
                .header("isPostDeleted","true")
                .body(response);
    }

    @DeleteMapping("post/deleteAfter/{id}")
    @Transactional
    public ResponseEntity<Post> deleteAfterId(@PathVariable Long id)
    {
        postService.deletePostsAfterId(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

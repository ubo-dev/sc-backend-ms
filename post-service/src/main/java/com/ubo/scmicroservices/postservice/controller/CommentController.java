package com.ubo.scmicroservices.postservice.controller;

import com.ubo.scmicroservices.postservice.model.entity.Comment;
import com.ubo.scmicroservices.postservice.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CommentController
{
    private CommentService commentService;

    public CommentController(CommentService commentService)
    {
        this.commentService = commentService;
    }

    @GetMapping("/comment")
    public List<Comment> getAllComments()
    {
        return commentService.getAllComments();
    }

    @GetMapping("/comment/{id}")
    public Comment getCommentById(@PathVariable Long id)
    {
        return commentService.getCommentById(id);
    }

    @PostMapping("/comment")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment)
    {
        commentService.createComment(comment);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/comment/update")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment)
    {
        commentService.createComment(comment);

        return new ResponseEntity<>(HttpStatus.OK);
    }





}

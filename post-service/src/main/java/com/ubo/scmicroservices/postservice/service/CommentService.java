package com.ubo.scmicroservices.postservice.service;

import com.ubo.scmicroservices.postservice.constants.ScConstants;
import com.ubo.scmicroservices.postservice.exception.CommentNotFoundException;
import com.ubo.scmicroservices.postservice.model.entity.Comment;
import com.ubo.scmicroservices.postservice.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService
{
    private CommentRepository commentRepository;
    private PostService postService;

    public CommentService(CommentRepository commentRepository,PostService postService) {
        this.commentRepository = commentRepository;
        this.postService = postService;
    }


    public List<Comment> getAllComments()
    {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long id)
    {
        Optional<Comment> optional = commentRepository.findById(id);

        if (optional.isPresent()) optional.get();

        throw new CommentNotFoundException("Comment not found with ID: " + id);
    }

    public void createComment(Comment comment)
    {
        comment.setPost(postService.getPostById(comment.getPost().getPostId()));
        comment.setCreatedBy(ScConstants.USER_ROLE);
        comment.setCreatedAt(LocalDateTime.now());
        commentRepository.save(comment);
    }

    public void updateComment(Comment comment)
    {
        comment.setUpdatedAt(LocalDateTime.now());
        comment.setUpdatedBy(ScConstants.USER_ROLE);
        createComment(comment);
    }

    public void deleteComment(Long id)
    {
        commentRepository.deleteById(id);
    }
}

package com.ubo.scmicroservices.postservice.service;

import com.ubo.scmicroservices.postservice.exception.CommentNotFoundException;
import com.ubo.scmicroservices.postservice.model.entity.Comment;
import com.ubo.scmicroservices.postservice.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService
{
    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
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
        commentRepository.save(comment);
    }

    public void updateComment(Comment comment)
    {
        createComment(comment);
    }
}

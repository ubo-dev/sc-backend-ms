package com.ubo.scmicroservices.postservice.exception;

public class CommentNotFoundException extends RuntimeException
{
    public CommentNotFoundException(String message) {
        super(message);
    }
}

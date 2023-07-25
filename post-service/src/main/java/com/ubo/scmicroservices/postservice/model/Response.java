package com.ubo.scmicroservices.postservice.model;

import com.ubo.scmicroservices.postservice.model.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response
{
    private String statusCode;
    private String statusMessage;
}

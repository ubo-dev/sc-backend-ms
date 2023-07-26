package com.ubo.scmicroservices.postservice.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Response
{
    private String statusCode;
    private String statusMessage;
}

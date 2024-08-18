package com.webservice.server.vo;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorVO {
    @NotEmpty
    private String name;
    @NotEmpty
    private String url;
    @NotEmpty
    private String bio;
}

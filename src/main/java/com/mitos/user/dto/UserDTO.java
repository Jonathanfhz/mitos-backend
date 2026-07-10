package com.mitos.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "User information")
public class UserDTO {

    @Schema(
            description = "Unique identifier of the user",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "User's full name",
            example = "Jon Snow"
    )
    private String name;

    @Schema(
            description = "User's email address",
            example = "jon.snow@winterfell.com"
    )
    private String email;

    public UserDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
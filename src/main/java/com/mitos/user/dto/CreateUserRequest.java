package com.mitos.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Request to create a new user")
public class CreateUserRequest {

    @Schema(
            description = "User's full name",
            example = "Jon Snow"
    )
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must contain between 2 and 50 characters")
    private String name;

    @Schema(
            description = "User's email address",
            example = "jon.snow@winterfell.com"
    )
    @NotBlank(message = "Email is required")
    @Email(message = "Email is not valid")
    private String email;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
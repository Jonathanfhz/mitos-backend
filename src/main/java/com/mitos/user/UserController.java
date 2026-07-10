package com.mitos.user;

import com.mitos.user.dto.CreateUserRequest;
import com.mitos.user.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "Operations related to user management")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
            summary = "Create a new user",
            description = "Creates a new user in the system."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User created successfully"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request",
                    content = @Content(schema = @Schema(hidden = true))
            )
    })
    @PostMapping
    public UserDTO createUser(
            @Parameter(description = "User information", required = true)
            @Valid @RequestBody CreateUserRequest request) {

        return userService.createUser(request);
    }

    @Operation(
            summary = "Get all users",
            description = "Returns the list of all registered users."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Users retrieved successfully")
    })
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }
}
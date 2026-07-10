package com.mitos.relationship;

import com.mitos.relationship.dto.RelationshipDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relationships")
@Tag(name = "Relationships", description = "Operations related to relationship management")
public class RelationshipController {

    private final RelationshipService relationshipService;

    public RelationshipController(RelationshipService relationshipService) {
        this.relationshipService = relationshipService;
    }

    @Operation(
            summary = "Create a relationship request",
            description = "Creates a new relationship request between two users."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Relationship request created successfully"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "One or both users were not found",
                    content = @Content(schema = @Schema(hidden = true))
            )
    })
    @PostMapping("/request")
    public RelationshipDTO createRequest(
            @Parameter(description = "ID of the first user", required = true)
            @RequestParam Long user1Id,

            @Parameter(description = "ID of the second user", required = true)
            @RequestParam Long user2Id) {

        return relationshipService.createRequest(user1Id, user2Id);
    }

    @Operation(
            summary = "Accept a relationship",
            description = "Accepts a pending relationship request."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Relationship accepted successfully"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Relationship not found",
                    content = @Content(schema = @Schema(hidden = true))
            )
    })
    @PutMapping("/{id}/accept")
    public RelationshipDTO acceptRelationship(
            @Parameter(description = "Relationship ID", required = true)
            @PathVariable Long id) {

        return relationshipService.acceptRelationship(id);
    }

    @Operation(
            summary = "Reject a relationship",
            description = "Rejects a pending relationship request."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Relationship rejected successfully"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Relationship not found",
                    content = @Content(schema = @Schema(hidden = true))
            )
    })
    @PutMapping("/{id}/reject")
    public RelationshipDTO rejectRelationship(
            @Parameter(description = "Relationship ID", required = true)
            @PathVariable Long id) {

        return relationshipService.rejectRelationship(id);
    }

    @Operation(
            summary = "End a relationship",
            description = "Ends an active relationship."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Relationship ended successfully"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Relationship not found",
                    content = @Content(schema = @Schema(hidden = true))
            )
    })
    @PutMapping("/{id}/end")
    public RelationshipDTO endRelationship(
            @Parameter(description = "Relationship ID", required = true)
            @PathVariable Long id) {

        return relationshipService.endRelationship(id);
    }
}
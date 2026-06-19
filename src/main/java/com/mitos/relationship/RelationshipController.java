package com.mitos.relationship;

import com.mitos.user.User;
import com.mitos.user.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relationships")
public class RelationshipController {

    private final RelationshipService relationshipService;
    private final UserRepository userRepository;

    public RelationshipController(RelationshipService relationshipService,
                                  UserRepository userRepository) {
        this.relationshipService = relationshipService;
        this.userRepository = userRepository;
    }

    @PostMapping("/request")
    public Relationship createRequest(@RequestParam Long user1Id,
                                       @RequestParam Long user2Id) {

        User user1 = userRepository.findById(user1Id)
                .orElseThrow(() -> new RuntimeException("User1 not found"));

        User user2 = userRepository.findById(user2Id)
                .orElseThrow(() -> new RuntimeException("User2 not found"));

        return relationshipService.createRequest(user1, user2);
    }
}
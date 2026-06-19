package com.mitos.relationship;

import com.mitos.user.User;
import org.springframework.stereotype.Service;

@Service
public class RelationshipService {

    private final RelationshipRepository relationshipRepository;

    public RelationshipService(RelationshipRepository relationshipRepository) {
        this.relationshipRepository = relationshipRepository;
    }

    public Relationship createRequest(User userFrom, User userTo) {

        Relationship relationship = new Relationship(
                userFrom,
                userTo,
                "PENDING"
        );

        return relationshipRepository.save(relationship);
    }
}
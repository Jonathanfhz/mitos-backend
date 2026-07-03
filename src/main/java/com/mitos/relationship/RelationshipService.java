package com.mitos.relationship;

import com.mitos.relationship.dto.RelationshipDTO;
import com.mitos.user.User;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RelationshipService {

    private final RelationshipRepository relationshipRepository;

    public RelationshipService(RelationshipRepository relationshipRepository) {
        this.relationshipRepository = relationshipRepository;
    }

    public Relationship createRequest(User userFrom, User userTo) {

        relationshipRepository
                .findByUserFromIdAndUserToIdOrUserFromIdAndUserToId(
                        userFrom.getId(),
                        userTo.getId(),
                        userTo.getId(),
                        userFrom.getId()
                )
                .ifPresent(r -> {
                    throw new RelationshipAlreadyExistsException("Relationship already exists");
                });

        Relationship relationship = new Relationship(
                userFrom,
                userTo,
                RelationshipStatus.PENDING
        );

        return relationshipRepository.save(relationship);
    }

 public Relationship acceptRelationship(Long id) {

    Relationship relationship = relationshipRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Relationship not found"));

    if (relationship.getStatus() != RelationshipStatus.PENDING) {
        throw new IllegalStateException("Only PENDING relationships can be accepted");
    }

    relationship.setStatus(RelationshipStatus.ACTIVE);

    return relationshipRepository.save(relationship);
}

public Relationship rejectRelationship(Long id) {

    Relationship relationship = relationshipRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Relationship not found"));

    if (relationship.getStatus() != RelationshipStatus.PENDING) {
        throw new IllegalStateException("Only PENDING relationships can be rejected");
    }

    relationship.setStatus(RelationshipStatus.REJECTED);

    return relationshipRepository.save(relationship);
}

 public Relationship endRelationship(Long id) {

    Relationship relationship = relationshipRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Relationship not found"));

    if (relationship.getStatus() != RelationshipStatus.ACTIVE) {
        throw new IllegalStateException("Only ACTIVE relationships can be ended");
    }

    relationship.setStatus(RelationshipStatus.ENDED);

    return relationshipRepository.save(relationship);
}

}
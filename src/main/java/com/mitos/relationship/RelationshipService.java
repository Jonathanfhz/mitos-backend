package com.mitos.relationship;

import com.mitos.relationship.dto.RelationshipDTO;
import com.mitos.user.User;
import com.mitos.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RelationshipService {

    private final RelationshipRepository relationshipRepository;
    private final UserRepository userRepository;

    public RelationshipService(RelationshipRepository relationshipRepository,
                               UserRepository userRepository) {
        this.relationshipRepository = relationshipRepository;
        this.userRepository = userRepository;
    }

    public RelationshipDTO createRequest(Long userFromId, Long userToId) {

        User userFrom = userRepository.findById(userFromId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        User userTo = userRepository.findById(userToId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

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

        return toDTO(relationshipRepository.save(relationship));
    }

    public RelationshipDTO acceptRelationship(Long id) {

        Relationship relationship = relationshipRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Relationship not found"));

        if (relationship.getStatus() != RelationshipStatus.PENDING) {
            throw new IllegalStateException("Only PENDING relationships can be accepted");
        }

        relationship.setStatus(RelationshipStatus.ACTIVE);

        return toDTO(relationshipRepository.save(relationship));
    }

    public RelationshipDTO rejectRelationship(Long id) {

        Relationship relationship = relationshipRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Relationship not found"));

        if (relationship.getStatus() != RelationshipStatus.PENDING) {
            throw new IllegalStateException("Only PENDING relationships can be rejected");
        }

        relationship.setStatus(RelationshipStatus.REJECTED);

        return toDTO(relationshipRepository.save(relationship));
    }

    public RelationshipDTO endRelationship(Long id) {

        Relationship relationship = relationshipRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Relationship not found"));

        if (relationship.getStatus() != RelationshipStatus.ACTIVE) {
            throw new IllegalStateException("Only ACTIVE relationships can be ended");
        }

        relationship.setStatus(RelationshipStatus.ENDED);

        return toDTO(relationshipRepository.save(relationship));
    }

    private RelationshipDTO toDTO(Relationship relationship) {
        return new RelationshipDTO(
                relationship.getId(),
                relationship.getUserFrom().getId(),
                relationship.getUserTo().getId(),
                relationship.getStatus()
        );
    }
}
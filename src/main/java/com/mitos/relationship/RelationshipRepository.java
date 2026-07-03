package com.mitos.relationship;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RelationshipRepository extends JpaRepository<Relationship, Long> {

    Optional<Relationship> findByUserFromIdAndUserToId(Long userFromId, Long userToId);

    Optional<Relationship> findByUserFromIdAndUserToIdOrUserFromIdAndUserToId(
            Long userFromId,
            Long userToId,
            Long userToIdReverse,
            Long userFromIdReverse
    );
}
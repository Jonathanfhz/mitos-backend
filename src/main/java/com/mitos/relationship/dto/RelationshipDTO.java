package com.mitos.relationship.dto;

import com.mitos.relationship.RelationshipStatus;

public class RelationshipDTO {

    private Long id;
    private Long fromUserId;
    private Long toUserId;
    private RelationshipStatus status;

    public RelationshipDTO(Long id, Long fromUserId, Long toUserId, RelationshipStatus status) {
        this.id = id;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public RelationshipStatus getStatus() {
        return status;
    }
}
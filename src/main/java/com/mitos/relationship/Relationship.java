package com.mitos.relationship;

import com.mitos.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "relationships")
public class Relationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User userFrom;

    @ManyToOne
    private User userTo;

    @Enumerated(EnumType.STRING)
    private RelationshipStatus status;

    public Relationship() {}

    public Relationship(User userFrom, User userTo, RelationshipStatus status) {
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public User getUserFrom() {
        return userFrom;
    }

    public User getUserTo() {
        return userTo;
    }

    public RelationshipStatus getStatus() {
        return status;
    }

    public void setUserFrom(User userFrom) {
        this.userFrom = userFrom;
    }

    public void setUserTo(User userTo) {
        this.userTo = userTo;
    }

    public void setStatus(RelationshipStatus status) {
        this.status = status;
    }
}
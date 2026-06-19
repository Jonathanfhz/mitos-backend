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

    private String type;

    public Relationship() {}

    public Relationship(User userFrom, User userTo, String type) {
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setUserFrom(User userFrom) {
        this.userFrom = userFrom;
    }

    public void setUserTo(User userTo) {
        this.userTo = userTo;
    }

    public void setType(String type) {
        this.type = type;
    }
}
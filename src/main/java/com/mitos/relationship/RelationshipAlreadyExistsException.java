package com.mitos.relationship;

public class RelationshipAlreadyExistsException extends RuntimeException {

    public RelationshipAlreadyExistsException(String message) {
        super(message);
    }
}
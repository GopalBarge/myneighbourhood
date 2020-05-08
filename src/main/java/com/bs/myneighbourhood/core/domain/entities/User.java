package com.bs.myneighbourhood.core.domain.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@NodeEntity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private User() {
        // Empty constructor required as of Neo4j API 2.0.5
    };

    public User(String name) {
        this.name = name;
    }


    @Relationship(type = "TEAMMATE", direction = Relationship.OUTGOING)
    public Set<User> teammates;

    public void worksWith(User person) {
        if (teammates == null) {
            teammates = new HashSet<>();
        }
        teammates.add(person);
    }

    public String toString() {

        return this.name + "'s teammates => "
                + Optional.ofNullable(this.teammates).orElse(
                Collections.emptySet()).stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
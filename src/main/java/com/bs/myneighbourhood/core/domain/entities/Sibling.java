package com.bs.myneighbourhood.core.domain.entities;

import com.bs.myneighbourhood.api.dto.RelationshipType;
import org.jetbrains.annotations.NotNull;
import org.neo4j.ogm.annotation.RelationshipEntity;

@RelationshipEntity("SIBLING_OF")
public final class Sibling extends Relationship {
    public Sibling(@NotNull String uuid, @NotNull Person from, @NotNull Person to, @NotNull RelationshipType relationshipType) {
        super(uuid, from, to, relationshipType);
    }
}



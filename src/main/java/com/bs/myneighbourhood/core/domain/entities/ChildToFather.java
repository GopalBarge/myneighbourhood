package com.bs.myneighbourhood.core.domain.entities;

import com.bs.myneighbourhood.api.dto.RelationshipType;
import org.jetbrains.annotations.NotNull;
import org.neo4j.ogm.annotation.RelationshipEntity;

@RelationshipEntity("HAS_FATHER")
public final class ChildToFather extends Relationship {
    public ChildToFather(@NotNull String uuid, @NotNull Person from, @NotNull Person to, @NotNull RelationshipType relationshipType) {
        super(uuid, from, to, relationshipType);
    }
}



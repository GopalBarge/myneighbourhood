package com.bs.myneighbourhood.core.domain.entities;


import com.bs.myneighbourhood.api.dto.RelationshipDTO;
import com.bs.myneighbourhood.api.dto.RelationshipType;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.StartNode;

public abstract class Relationship extends Entity {
    @StartNode
    @NotNull
    private final Person from;
    @EndNode
    @NotNull
    private final Person to;
    @NotNull
    private final RelationshipType relationshipType;

    public boolean equals(@Nullable Object other) {
        return other == null ? false : (Intrinsics.areEqual(other, (Relationship)this) ? true : (other instanceof Relationship ? Intrinsics.areEqual(this.getUuid(), ((Relationship)other).getUuid()) : false));
    }

    public int hashCode() {
        return this.getUuid().hashCode();
    }

   /* @NotNull
    public final RelationshipDTO toRelationship() {
        return new RelationshipDTO(this.getUuid(), this.from.toPersonDTO(), this.to.toPersonDTO(), this.relationshipType);
    }*/

    @NotNull
    public final Person getFrom() {
        return this.from;
    }

    @NotNull
    public final Person getTo() {
        return this.to;
    }

    @NotNull
    public final RelationshipType getRelationshipType() {
        return this.relationshipType;
    }

    public Relationship(@NotNull String uuid, @NotNull Person from, @NotNull Person to, @NotNull RelationshipType relationshipType) {
        super(uuid);
        this.from = from;
        this.to = to;
        this.relationshipType = relationshipType;
    }
}
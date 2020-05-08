package com.bs.myneighbourhood.core.domain.entities;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

public abstract class Entity {
    @Id
    @GeneratedValue
    @NotNull
    private final String uuid;

    @NotNull
    public final String getUuid() {
        return this.uuid;
    }

    public Entity(@NotNull String uuid) {
        super();
        this.uuid = uuid;
    }
}
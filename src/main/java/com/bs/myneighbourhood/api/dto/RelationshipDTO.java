package com.bs.myneighbourhood.api.dto;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.neo4j.annotation.QueryResult;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

@QueryResult
public final class RelationshipDTO {
    private final String uuid;
    private final PersonDTO from;
    private final PersonDTO to;
    private final RelationshipType relationshipType;

    public RelationshipDTO(@Nullable String uuid, @NotNull PersonDTO from, @NotNull PersonDTO to, @NotNull RelationshipType relationshipType) {

        this.uuid = uuid;
        this.from = from;
        this.to = to;
        this.relationshipType = relationshipType;
    }

    private final String component1() {
        return this.uuid;
    }

    private final PersonDTO component2() {
        return this.from;
    }

    private final PersonDTO component3() {
        return this.to;
    }

    private final RelationshipType component4() {
        return this.relationshipType;
    }


    public final RelationshipDTO copy(@Nullable String uuid, @NotNull PersonDTO from, @NotNull PersonDTO to, @NotNull RelationshipType relationshipType) {

        return new RelationshipDTO(uuid, from, to, relationshipType);
    }
    public String toString() {
        return "RelationshipDTO(uuid=" + this.uuid + ", from=" + this.from + ", to=" + this.to + ", relationshipType=" + this.relationshipType + ")";
    }
    public int hashCode() {
        String var10000 = this.uuid;
        int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
        PersonDTO var10001 = this.from;
        var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
        var10001 = this.to;
        var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
        RelationshipType var2 = this.relationshipType;
        return var1 + (var2 != null ? var2.hashCode() : 0);
    }

    public boolean equals(@Nullable Object var1) {
        if (this != var1) {
            if (var1 instanceof RelationshipDTO) {
                RelationshipDTO var2 = (RelationshipDTO) var1;
                if (StringUtils.equals(this.uuid, var2.uuid) && this.from.equals(var2.from) && this.to.equals(var2.to) && this.relationshipType.equals(var2.relationshipType)) {
                    return true;
                }
            }

            return false;
        } else {
            return true;
        }
    }
}

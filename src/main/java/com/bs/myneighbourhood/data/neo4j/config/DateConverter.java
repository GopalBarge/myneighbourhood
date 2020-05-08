package com.bs.myneighbourhood.data.neo4j.config;



import org.neo4j.ogm.typeconversion.AttributeConverter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public final class DateConverter implements AttributeConverter {
    @NotNull
    public LocalDate toGraphProperty(@NotNull LocalDate value) {
        return value;
    }

    public Object toGraphProperty(Object var1) {
        return this.toGraphProperty((LocalDate)var1);
    }

    @NotNull
    public LocalDate toEntityAttribute(@NotNull LocalDate value) {
        return value;
    }

    public Object toEntityAttribute(Object var1) {
        return this.toEntityAttribute((LocalDate)var1);
    }
}


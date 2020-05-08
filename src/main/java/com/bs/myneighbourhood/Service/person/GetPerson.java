package com.bs.myneighbourhood.Service.person;


import com.bs.myneighbourhood.api.dto.PersonDTO;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public interface GetPerson {
    @Nullable
    PersonDTO byUuid(@NotNull String var1);

    @NotNull
    Collection byFirstname(@NotNull String var1);

    @NotNull
    Collection byLastname(@NotNull String var1);

    @NotNull
    Collection all(@Nullable Integer var1);

    @NotNull
    Collection siblings(@NotNull String var1);

    @NotNull
    Collection friends(@NotNull String var1);

    @Nullable
    PersonDTO mother(@NotNull String var1);

    @Nullable
    PersonDTO father(@NotNull String var1);

    @Nullable
    PersonDTO spouse(@NotNull String var1);
}

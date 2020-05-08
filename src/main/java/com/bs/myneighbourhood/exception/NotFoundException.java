package com.bs.myneighbourhood.exception;

import org.jetbrains.annotations.NotNull;

public final class NotFoundException extends RuntimeException {
    public NotFoundException(@NotNull String message) {
        super(message);
    }
}


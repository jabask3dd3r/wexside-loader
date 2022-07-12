/*
 * Decompiled with CFR 0.152.
 */
package com.eclipsesource.json;

import com.eclipsesource.json.SourceFile11;

public class SourceFile13
extends RuntimeException {
    private final SourceFile11 location;

    SourceFile13(String string, SourceFile11 sourceFile11) {
        super(string + " at " + sourceFile11);
        this.location = sourceFile11;
    }

    public SourceFile11 getLocation() {
        return this.location;
    }

    @Deprecated
    public int getOffset() {
        return this.location.offset;
    }

    @Deprecated
    public int getLine() {
        return this.location.line;
    }

    @Deprecated
    public int getColumn() {
        return this.location.column;
    }
}


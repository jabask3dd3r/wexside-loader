/*
 * Decompiled with CFR 0.152.
 */
package com.eclipsesource.json;

import com.eclipsesource.json.SourceFile10;
import com.eclipsesource.json.SourceFile8;

class SourceFile6
extends SourceFile8 {
    private final String string;

    SourceFile6(String string) {
        if (string == null) {
            throw new NullPointerException("string is null");
        }
        this.string = string;
    }

    @Override
    void write(SourceFile10 sourceFile10) {
        sourceFile10.writeString(this.string);
    }

    @Override
    public boolean isString() {
        return true;
    }

    @Override
    public String asString() {
        return this.string;
    }

    @Override
    public int hashCode() {
        return this.string.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        SourceFile6 sourceFile6 = (SourceFile6)object;
        return this.string.equals(sourceFile6.string);
    }
}


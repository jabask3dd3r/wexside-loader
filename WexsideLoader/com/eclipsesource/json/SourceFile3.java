/*
 * Decompiled with CFR 0.152.
 */
package com.eclipsesource.json;

import com.eclipsesource.json.SourceFile10;
import com.eclipsesource.json.SourceFile8;

class SourceFile3
extends SourceFile8 {
    private final String string;

    SourceFile3(String string) {
        if (string == null) {
            throw new NullPointerException("string is null");
        }
        this.string = string;
    }

    @Override
    public String toString() {
        return this.string;
    }

    @Override
    void write(SourceFile10 sourceFile10) {
        sourceFile10.writeNumber(this.string);
    }

    @Override
    public boolean isNumber() {
        return true;
    }

    @Override
    public int asInt() {
        return Integer.parseInt(this.string, 10);
    }

    @Override
    public long asLong() {
        return Long.parseLong(this.string, 10);
    }

    @Override
    public float asFloat() {
        return Float.parseFloat(this.string);
    }

    @Override
    public double asDouble() {
        return Double.parseDouble(this.string);
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
        SourceFile3 sourceFile3 = (SourceFile3)object;
        return this.string.equals(sourceFile3.string);
    }
}


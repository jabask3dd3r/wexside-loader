/*
 * Decompiled with CFR 0.152.
 */
package com.eclipsesource.json;

import com.eclipsesource.json.SourceFile10;
import com.eclipsesource.json.SourceFile8;

class SourceFile
extends SourceFile8 {
    private final String value;
    private final boolean isNull;
    private final boolean isTrue;
    private final boolean isFalse;

    SourceFile(String string) {
        this.value = string;
        this.isNull = "null".equals(string);
        this.isTrue = "true".equals(string);
        this.isFalse = "false".equals(string);
    }

    @Override
    void write(SourceFile10 sourceFile10) {
        sourceFile10.writeLiteral(this.value);
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    public boolean isNull() {
        return this.isNull;
    }

    @Override
    public boolean isTrue() {
        return this.isTrue;
    }

    @Override
    public boolean isFalse() {
        return this.isFalse;
    }

    @Override
    public boolean isBoolean() {
        return this.isTrue || this.isFalse;
    }

    @Override
    public boolean asBoolean() {
        return this.isNull ? super.asBoolean() : this.isTrue;
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
        SourceFile sourceFile = (SourceFile)object;
        return this.value.equals(sourceFile.value);
    }
}


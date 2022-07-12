/*
 * Decompiled with CFR 0.152.
 */
package com.eclipsesource.json;

public class SourceFile11 {
    public final int offset;
    public final int line;
    public final int column;

    SourceFile11(int n, int n2, int n3) {
        this.offset = n;
        this.column = n3;
        this.line = n2;
    }

    public String toString() {
        return this.line + ":" + this.column;
    }

    public int hashCode() {
        return this.offset;
    }

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
        SourceFile11 sourceFile11 = (SourceFile11)object;
        return this.offset == sourceFile11.offset && this.column == sourceFile11.column && this.line == sourceFile11.line;
    }
}


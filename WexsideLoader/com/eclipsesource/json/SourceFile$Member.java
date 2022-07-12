/*
 * Decompiled with CFR 0.152.
 */
package com.eclipsesource.json;

import com.eclipsesource.json.SourceFile8;

public class SourceFile$Member {
    private final String name;
    private final SourceFile8 value;

    SourceFile$Member(String string, SourceFile8 sourceFile8) {
        this.name = string;
        this.value = sourceFile8;
    }

    public String getName() {
        return this.name;
    }

    public SourceFile8 getValue() {
        return this.value;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.name.hashCode();
        n = 31 * n + this.value.hashCode();
        return n;
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
        SourceFile$Member sourceFile$Member = (SourceFile$Member)object;
        return this.name.equals(sourceFile$Member.name) && this.value.equals(sourceFile$Member.value);
    }

    static /* synthetic */ String access$000(SourceFile$Member sourceFile$Member) {
        return sourceFile$Member.name;
    }

    static /* synthetic */ SourceFile8 access$100(SourceFile$Member sourceFile$Member) {
        return sourceFile$Member.value;
    }
}


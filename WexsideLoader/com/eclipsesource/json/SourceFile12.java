/*
 * Decompiled with CFR 0.152.
 */
package com.eclipsesource.json;

import com.eclipsesource.json.SourceFile$12;
import com.eclipsesource.json.SourceFile10;
import com.eclipsesource.json.SourceFile7;
import com.eclipsesource.json.SourceFile8;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SourceFile12
extends SourceFile8
implements Iterable {
    private final List values;

    public SourceFile12() {
        this.values = new ArrayList();
    }

    public SourceFile12(SourceFile12 sourceFile12) {
        this(sourceFile12, false);
    }

    private SourceFile12(SourceFile12 sourceFile12, boolean bl) {
        if (sourceFile12 == null) {
            throw new NullPointerException("array is null");
        }
        this.values = bl ? Collections.unmodifiableList(sourceFile12.values) : new ArrayList(sourceFile12.values);
    }

    @Deprecated
    public static SourceFile12 readFrom(Reader reader) {
        return SourceFile8.readFrom(reader).asArray();
    }

    @Deprecated
    public static SourceFile12 readFrom(String string) {
        return SourceFile8.readFrom(string).asArray();
    }

    public static SourceFile12 unmodifiableArray(SourceFile12 sourceFile12) {
        return new SourceFile12(sourceFile12, true);
    }

    public SourceFile12 add(int n) {
        this.values.add(SourceFile7.value(n));
        return this;
    }

    public SourceFile12 add(long l) {
        this.values.add(SourceFile7.value(l));
        return this;
    }

    public SourceFile12 add(float f) {
        this.values.add(SourceFile7.value(f));
        return this;
    }

    public SourceFile12 add(double d) {
        this.values.add(SourceFile7.value(d));
        return this;
    }

    public SourceFile12 add(boolean bl) {
        this.values.add(SourceFile7.value(bl));
        return this;
    }

    public SourceFile12 add(String string) {
        this.values.add(SourceFile7.value(string));
        return this;
    }

    public SourceFile12 add(SourceFile8 sourceFile8) {
        if (sourceFile8 == null) {
            throw new NullPointerException("value is null");
        }
        this.values.add(sourceFile8);
        return this;
    }

    public SourceFile12 set(int n, int n2) {
        this.values.set(n, SourceFile7.value(n2));
        return this;
    }

    public SourceFile12 set(int n, long l) {
        this.values.set(n, SourceFile7.value(l));
        return this;
    }

    public SourceFile12 set(int n, float f) {
        this.values.set(n, SourceFile7.value(f));
        return this;
    }

    public SourceFile12 set(int n, double d) {
        this.values.set(n, SourceFile7.value(d));
        return this;
    }

    public SourceFile12 set(int n, boolean bl) {
        this.values.set(n, SourceFile7.value(bl));
        return this;
    }

    public SourceFile12 set(int n, String string) {
        this.values.set(n, SourceFile7.value(string));
        return this;
    }

    public SourceFile12 set(int n, SourceFile8 sourceFile8) {
        if (sourceFile8 == null) {
            throw new NullPointerException("value is null");
        }
        this.values.set(n, sourceFile8);
        return this;
    }

    public SourceFile12 remove(int n) {
        this.values.remove(n);
        return this;
    }

    public int size() {
        return this.values.size();
    }

    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    public SourceFile8 get(int n) {
        return (SourceFile8)this.values.get(n);
    }

    public List values() {
        return Collections.unmodifiableList(this.values);
    }

    public Iterator iterator() {
        Iterator iterator = this.values.iterator();
        return new SourceFile$12(this, iterator);
    }

    @Override
    void write(SourceFile10 sourceFile10) {
        sourceFile10.writeArrayOpen();
        Iterator iterator = this.iterator();
        if (iterator.hasNext()) {
            ((SourceFile8)iterator.next()).write(sourceFile10);
            while (iterator.hasNext()) {
                sourceFile10.writeArraySeparator();
                ((SourceFile8)iterator.next()).write(sourceFile10);
            }
        }
        sourceFile10.writeArrayClose();
    }

    @Override
    public boolean isArray() {
        return true;
    }

    @Override
    public SourceFile12 asArray() {
        return this;
    }

    @Override
    public int hashCode() {
        return this.values.hashCode();
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
        SourceFile12 sourceFile12 = (SourceFile12)object;
        return this.values.equals(sourceFile12.values);
    }
}


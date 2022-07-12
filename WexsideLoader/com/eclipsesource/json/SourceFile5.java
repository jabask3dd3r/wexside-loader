/*
 * Decompiled with CFR 0.152.
 */
package com.eclipsesource.json;

import com.eclipsesource.json.SourceFile$13;
import com.eclipsesource.json.SourceFile$HashIndexTable;
import com.eclipsesource.json.SourceFile$Member;
import com.eclipsesource.json.SourceFile10;
import com.eclipsesource.json.SourceFile7;
import com.eclipsesource.json.SourceFile8;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SourceFile5
extends SourceFile8
implements Iterable {
    private final List names;
    private final List values;
    private transient SourceFile$HashIndexTable table;

    public SourceFile5() {
        this.names = new ArrayList();
        this.values = new ArrayList();
        this.table = new SourceFile$HashIndexTable();
    }

    public SourceFile5(SourceFile5 sourceFile5) {
        this(sourceFile5, false);
    }

    private SourceFile5(SourceFile5 sourceFile5, boolean bl) {
        if (sourceFile5 == null) {
            throw new NullPointerException("object is null");
        }
        if (bl) {
            this.names = Collections.unmodifiableList(sourceFile5.names);
            this.values = Collections.unmodifiableList(sourceFile5.values);
        } else {
            this.names = new ArrayList(sourceFile5.names);
            this.values = new ArrayList(sourceFile5.values);
        }
        this.table = new SourceFile$HashIndexTable();
        this.updateHashIndex();
    }

    @Deprecated
    public static SourceFile5 readFrom(Reader reader) {
        return SourceFile8.readFrom(reader).asObject();
    }

    @Deprecated
    public static SourceFile5 readFrom(String string) {
        return SourceFile8.readFrom(string).asObject();
    }

    public static SourceFile5 unmodifiableObject(SourceFile5 sourceFile5) {
        return new SourceFile5(sourceFile5, true);
    }

    public SourceFile5 add(String string, int n) {
        this.add(string, SourceFile7.value(n));
        return this;
    }

    public SourceFile5 add(String string, long l) {
        this.add(string, SourceFile7.value(l));
        return this;
    }

    public SourceFile5 add(String string, float f) {
        this.add(string, SourceFile7.value(f));
        return this;
    }

    public SourceFile5 add(String string, double d) {
        this.add(string, SourceFile7.value(d));
        return this;
    }

    public SourceFile5 add(String string, boolean bl) {
        this.add(string, SourceFile7.value(bl));
        return this;
    }

    public SourceFile5 add(String string, String string2) {
        this.add(string, SourceFile7.value(string2));
        return this;
    }

    public SourceFile5 add(String string, SourceFile8 sourceFile8) {
        if (string == null) {
            throw new NullPointerException("name is null");
        }
        if (sourceFile8 == null) {
            throw new NullPointerException("value is null");
        }
        this.table.add(string, this.names.size());
        this.names.add(string);
        this.values.add(sourceFile8);
        return this;
    }

    public SourceFile5 set(String string, int n) {
        this.set(string, SourceFile7.value(n));
        return this;
    }

    public SourceFile5 set(String string, long l) {
        this.set(string, SourceFile7.value(l));
        return this;
    }

    public SourceFile5 set(String string, float f) {
        this.set(string, SourceFile7.value(f));
        return this;
    }

    public SourceFile5 set(String string, double d) {
        this.set(string, SourceFile7.value(d));
        return this;
    }

    public SourceFile5 set(String string, boolean bl) {
        this.set(string, SourceFile7.value(bl));
        return this;
    }

    public SourceFile5 set(String string, String string2) {
        this.set(string, SourceFile7.value(string2));
        return this;
    }

    public SourceFile5 set(String string, SourceFile8 sourceFile8) {
        if (string == null) {
            throw new NullPointerException("name is null");
        }
        if (sourceFile8 == null) {
            throw new NullPointerException("value is null");
        }
        int n = this.indexOf(string);
        if (n != -1) {
            this.values.set(n, sourceFile8);
        } else {
            this.table.add(string, this.names.size());
            this.names.add(string);
            this.values.add(sourceFile8);
        }
        return this;
    }

    public SourceFile5 remove(String string) {
        if (string == null) {
            throw new NullPointerException("name is null");
        }
        int n = this.indexOf(string);
        if (n != -1) {
            this.table.remove(n);
            this.names.remove(n);
            this.values.remove(n);
        }
        return this;
    }

    public SourceFile5 merge(SourceFile5 sourceFile5) {
        if (sourceFile5 == null) {
            throw new NullPointerException("object is null");
        }
        for (SourceFile$Member sourceFile$Member : sourceFile5) {
            this.set(SourceFile$Member.access$000(sourceFile$Member), SourceFile$Member.access$100(sourceFile$Member));
        }
        return this;
    }

    public SourceFile8 get(String string) {
        if (string == null) {
            throw new NullPointerException("name is null");
        }
        int n = this.indexOf(string);
        return n != -1 ? (SourceFile8)this.values.get(n) : null;
    }

    public int getInt(String string, int n) {
        SourceFile8 sourceFile8 = this.get(string);
        return sourceFile8 != null ? sourceFile8.asInt() : n;
    }

    public long getLong(String string, long l) {
        SourceFile8 sourceFile8 = this.get(string);
        return sourceFile8 != null ? sourceFile8.asLong() : l;
    }

    public float getFloat(String string, float f) {
        SourceFile8 sourceFile8 = this.get(string);
        return sourceFile8 != null ? sourceFile8.asFloat() : f;
    }

    public double getDouble(String string, double d) {
        SourceFile8 sourceFile8 = this.get(string);
        return sourceFile8 != null ? sourceFile8.asDouble() : d;
    }

    public boolean getBoolean(String string, boolean bl) {
        SourceFile8 sourceFile8 = this.get(string);
        return sourceFile8 != null ? sourceFile8.asBoolean() : bl;
    }

    public String getString(String string, String string2) {
        SourceFile8 sourceFile8 = this.get(string);
        return sourceFile8 != null ? sourceFile8.asString() : string2;
    }

    public int size() {
        return this.names.size();
    }

    public boolean isEmpty() {
        return this.names.isEmpty();
    }

    public List names() {
        return Collections.unmodifiableList(this.names);
    }

    public Iterator iterator() {
        Iterator iterator = this.names.iterator();
        Iterator iterator2 = this.values.iterator();
        return new SourceFile$13(this, iterator, iterator2);
    }

    @Override
    void write(SourceFile10 sourceFile10) {
        sourceFile10.writeObjectOpen();
        Iterator iterator = this.names.iterator();
        Iterator iterator2 = this.values.iterator();
        if (iterator.hasNext()) {
            sourceFile10.writeMemberName((String)iterator.next());
            sourceFile10.writeMemberSeparator();
            ((SourceFile8)iterator2.next()).write(sourceFile10);
            while (iterator.hasNext()) {
                sourceFile10.writeObjectSeparator();
                sourceFile10.writeMemberName((String)iterator.next());
                sourceFile10.writeMemberSeparator();
                ((SourceFile8)iterator2.next()).write(sourceFile10);
            }
        }
        sourceFile10.writeObjectClose();
    }

    @Override
    public boolean isObject() {
        return true;
    }

    @Override
    public SourceFile5 asObject() {
        return this;
    }

    @Override
    public int hashCode() {
        int n = 1;
        n = 31 * n + this.names.hashCode();
        n = 31 * n + this.values.hashCode();
        return n;
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
        SourceFile5 sourceFile5 = (SourceFile5)object;
        return this.names.equals(sourceFile5.names) && this.values.equals(sourceFile5.values);
    }

    int indexOf(String string) {
        int n = this.table.get(string);
        if (n != -1 && string.equals(this.names.get(n))) {
            return n;
        }
        return this.names.lastIndexOf(string);
    }

    private synchronized void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.table = new SourceFile$HashIndexTable();
        this.updateHashIndex();
    }

    private void updateHashIndex() {
        int n = this.names.size();
        for (int i = 0; i < n; ++i) {
            this.table.add((String)this.names.get(i), i);
        }
    }
}


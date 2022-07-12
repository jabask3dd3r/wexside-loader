/*
 * Decompiled with CFR 0.152.
 */
package com.eclipsesource.json;

import com.eclipsesource.json.SourceFile;
import com.eclipsesource.json.SourceFile1;
import com.eclipsesource.json.SourceFile10;
import com.eclipsesource.json.SourceFile12;
import com.eclipsesource.json.SourceFile4;
import com.eclipsesource.json.SourceFile5;
import com.eclipsesource.json.SourceFile7;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;

public abstract class SourceFile8
implements Serializable {
    @Deprecated
    public static final SourceFile8 TRUE = new SourceFile("true");
    @Deprecated
    public static final SourceFile8 FALSE = new SourceFile("false");
    @Deprecated
    public static final SourceFile8 NULL = new SourceFile("null");

    SourceFile8() {
    }

    @Deprecated
    public static SourceFile8 readFrom(Reader reader) {
        return SourceFile7.parse(reader);
    }

    @Deprecated
    public static SourceFile8 readFrom(String string) {
        return SourceFile7.parse(string);
    }

    @Deprecated
    public static SourceFile8 valueOf(int n) {
        return SourceFile7.value(n);
    }

    @Deprecated
    public static SourceFile8 valueOf(long l) {
        return SourceFile7.value(l);
    }

    @Deprecated
    public static SourceFile8 valueOf(float f) {
        return SourceFile7.value(f);
    }

    @Deprecated
    public static SourceFile8 valueOf(double d) {
        return SourceFile7.value(d);
    }

    @Deprecated
    public static SourceFile8 valueOf(String string) {
        return SourceFile7.value(string);
    }

    @Deprecated
    public static SourceFile8 valueOf(boolean bl) {
        return SourceFile7.value(bl);
    }

    public boolean isObject() {
        return false;
    }

    public boolean isArray() {
        return false;
    }

    public boolean isNumber() {
        return false;
    }

    public boolean isString() {
        return false;
    }

    public boolean isBoolean() {
        return false;
    }

    public boolean isTrue() {
        return false;
    }

    public boolean isFalse() {
        return false;
    }

    public boolean isNull() {
        return false;
    }

    public SourceFile5 asObject() {
        throw new UnsupportedOperationException("Not an object: " + this.toString());
    }

    public SourceFile12 asArray() {
        throw new UnsupportedOperationException("Not an array: " + this.toString());
    }

    public int asInt() {
        throw new UnsupportedOperationException("Not a number: " + this.toString());
    }

    public long asLong() {
        throw new UnsupportedOperationException("Not a number: " + this.toString());
    }

    public float asFloat() {
        throw new UnsupportedOperationException("Not a number: " + this.toString());
    }

    public double asDouble() {
        throw new UnsupportedOperationException("Not a number: " + this.toString());
    }

    public String asString() {
        throw new UnsupportedOperationException("Not a string: " + this.toString());
    }

    public boolean asBoolean() {
        throw new UnsupportedOperationException("Not a boolean: " + this.toString());
    }

    public void writeTo(Writer writer) {
        this.writeTo(writer, SourceFile4.MINIMAL);
    }

    public void writeTo(Writer writer, SourceFile4 sourceFile4) {
        if (writer == null) {
            throw new NullPointerException("writer is null");
        }
        if (sourceFile4 == null) {
            throw new NullPointerException("config is null");
        }
        SourceFile1 sourceFile1 = new SourceFile1(writer, 128);
        this.write(sourceFile4.createWriter(sourceFile1));
        sourceFile1.flush();
    }

    public String toString() {
        return this.toString(SourceFile4.MINIMAL);
    }

    public String toString(SourceFile4 sourceFile4) {
        StringWriter stringWriter = new StringWriter();
        try {
            this.writeTo(stringWriter, sourceFile4);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return stringWriter.toString();
    }

    public boolean equals(Object object) {
        return super.equals(object);
    }

    public int hashCode() {
        return super.hashCode();
    }

    abstract void write(SourceFile10 var1);
}


/*
 * Decompiled with CFR 0.152.
 */
package com.eclipsesource.json;

import com.eclipsesource.json.SourceFile11;
import com.eclipsesource.json.SourceFile2;

public abstract class SourceFile14 {
    SourceFile2 parser;

    protected SourceFile11 getLocation() {
        return this.parser.getLocation();
    }

    public void startNull() {
    }

    public void endNull() {
    }

    public void startBoolean() {
    }

    public void endBoolean(boolean bl) {
    }

    public void startString() {
    }

    public void endString(String string) {
    }

    public void startNumber() {
    }

    public void endNumber(String string) {
    }

    public Object startArray() {
        return null;
    }

    public void endArray(Object object) {
    }

    public void startArrayValue(Object object) {
    }

    public void endArrayValue(Object object) {
    }

    public Object startObject() {
        return null;
    }

    public void endObject(Object object) {
    }

    public void startObjectName(Object object) {
    }

    public void endObjectName(Object object, String string) {
    }

    public void startObjectValue(Object object, String string) {
    }

    public void endObjectValue(Object object, String string) {
    }
}


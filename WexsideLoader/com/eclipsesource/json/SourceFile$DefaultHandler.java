/*
 * Decompiled with CFR 0.152.
 */
package com.eclipsesource.json;

import com.eclipsesource.json.SourceFile12;
import com.eclipsesource.json.SourceFile14;
import com.eclipsesource.json.SourceFile3;
import com.eclipsesource.json.SourceFile5;
import com.eclipsesource.json.SourceFile6;
import com.eclipsesource.json.SourceFile7;
import com.eclipsesource.json.SourceFile8;

class SourceFile$DefaultHandler
extends SourceFile14 {
    protected SourceFile8 value;

    SourceFile$DefaultHandler() {
    }

    @Override
    public SourceFile12 startArray() {
        return new SourceFile12();
    }

    @Override
    public SourceFile5 startObject() {
        return new SourceFile5();
    }

    @Override
    public void endNull() {
        this.value = SourceFile7.NULL;
    }

    @Override
    public void endBoolean(boolean bl) {
        this.value = bl ? SourceFile7.TRUE : SourceFile7.FALSE;
    }

    @Override
    public void endString(String string) {
        this.value = new SourceFile6(string);
    }

    @Override
    public void endNumber(String string) {
        this.value = new SourceFile3(string);
    }

    public void endArray(SourceFile12 sourceFile12) {
        this.value = sourceFile12;
    }

    public void endObject(SourceFile5 sourceFile5) {
        this.value = sourceFile5;
    }

    public void endArrayValue(SourceFile12 sourceFile12) {
        sourceFile12.add(this.value);
    }

    public void endObjectValue(SourceFile5 sourceFile5, String string) {
        sourceFile5.add(string, this.value);
    }

    SourceFile8 getValue() {
        return this.value;
    }
}


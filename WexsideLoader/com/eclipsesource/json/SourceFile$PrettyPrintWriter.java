/*
 * Decompiled with CFR 0.152.
 */
package com.eclipsesource.json;

import com.eclipsesource.json.SourceFile10;
import java.io.Writer;

class SourceFile$PrettyPrintWriter
extends SourceFile10 {
    private final char[] indentChars;
    private int indent;

    private SourceFile$PrettyPrintWriter(Writer writer, char[] cArray) {
        super(writer);
        this.indentChars = cArray;
    }

    @Override
    protected void writeArrayOpen() {
        ++this.indent;
        this.writer.write(91);
        this.writeNewLine();
    }

    @Override
    protected void writeArrayClose() {
        --this.indent;
        this.writeNewLine();
        this.writer.write(93);
    }

    @Override
    protected void writeArraySeparator() {
        this.writer.write(44);
        if (!this.writeNewLine()) {
            this.writer.write(32);
        }
    }

    @Override
    protected void writeObjectOpen() {
        ++this.indent;
        this.writer.write(123);
        this.writeNewLine();
    }

    @Override
    protected void writeObjectClose() {
        --this.indent;
        this.writeNewLine();
        this.writer.write(125);
    }

    @Override
    protected void writeMemberSeparator() {
        this.writer.write(58);
        this.writer.write(32);
    }

    @Override
    protected void writeObjectSeparator() {
        this.writer.write(44);
        if (!this.writeNewLine()) {
            this.writer.write(32);
        }
    }

    private boolean writeNewLine() {
        if (this.indentChars == null) {
            return false;
        }
        this.writer.write(10);
        for (int i = 0; i < this.indent; ++i) {
            this.writer.write(this.indentChars);
        }
        return true;
    }
}


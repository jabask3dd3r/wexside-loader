/*
 * Decompiled with CFR 0.152.
 */
package com.eclipsesource.json;

import java.io.Writer;

class SourceFile10 {
    private static final int CONTROL_CHARACTERS_END = 31;
    private static final char[] QUOT_CHARS = new char[]{'\\', '\"'};
    private static final char[] BS_CHARS = new char[]{'\\', '\\'};
    private static final char[] LF_CHARS = new char[]{'\\', 'n'};
    private static final char[] CR_CHARS = new char[]{'\\', 'r'};
    private static final char[] TAB_CHARS = new char[]{'\\', 't'};
    private static final char[] UNICODE_2028_CHARS = new char[]{'\\', 'u', '2', '0', '2', '8'};
    private static final char[] UNICODE_2029_CHARS = new char[]{'\\', 'u', '2', '0', '2', '9'};
    private static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected final Writer writer;

    SourceFile10(Writer writer) {
        this.writer = writer;
    }

    protected void writeLiteral(String string) {
        this.writer.write(string);
    }

    protected void writeNumber(String string) {
        this.writer.write(string);
    }

    protected void writeString(String string) {
        this.writer.write(34);
        this.writeJsonString(string);
        this.writer.write(34);
    }

    protected void writeArrayOpen() {
        this.writer.write(91);
    }

    protected void writeArrayClose() {
        this.writer.write(93);
    }

    protected void writeArraySeparator() {
        this.writer.write(44);
    }

    protected void writeObjectOpen() {
        this.writer.write(123);
    }

    protected void writeObjectClose() {
        this.writer.write(125);
    }

    protected void writeMemberName(String string) {
        this.writer.write(34);
        this.writeJsonString(string);
        this.writer.write(34);
    }

    protected void writeMemberSeparator() {
        this.writer.write(58);
    }

    protected void writeObjectSeparator() {
        this.writer.write(44);
    }

    protected void writeJsonString(String string) {
        int n = string.length();
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            char[] cArray = SourceFile10.getReplacementChars(string.charAt(i));
            if (cArray == null) continue;
            this.writer.write(string, n2, i - n2);
            this.writer.write(cArray);
            n2 = i + 1;
        }
        this.writer.write(string, n2, n - n2);
    }

    private static char[] getReplacementChars(char c) {
        if (c > '\\') {
            if (c < '\u2028' || c > '\u2029') {
                return null;
            }
            return c == '\u2028' ? UNICODE_2028_CHARS : UNICODE_2029_CHARS;
        }
        if (c == '\\') {
            return BS_CHARS;
        }
        if (c > '\"') {
            return null;
        }
        if (c == '\"') {
            return QUOT_CHARS;
        }
        if (c > '\u001f') {
            return null;
        }
        if (c == '\n') {
            return LF_CHARS;
        }
        if (c == '\r') {
            return CR_CHARS;
        }
        if (c == '\t') {
            return TAB_CHARS;
        }
        return new char[]{'\\', 'u', '0', '0', HEX_DIGITS[c >> 4 & 0xF], HEX_DIGITS[c & 0xF]};
    }
}


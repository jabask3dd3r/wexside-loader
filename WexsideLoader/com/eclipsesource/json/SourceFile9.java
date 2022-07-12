/*
 * Decompiled with CFR 0.152.
 */
package com.eclipsesource.json;

import com.eclipsesource.json.SourceFile$PrettyPrintWriter;
import com.eclipsesource.json.SourceFile10;
import com.eclipsesource.json.SourceFile4;
import java.io.Writer;
import java.util.Arrays;

public class SourceFile9
extends SourceFile4 {
    private final char[] indentChars;

    protected SourceFile9(char[] cArray) {
        this.indentChars = cArray;
    }

    public static SourceFile9 singleLine() {
        return new SourceFile9(null);
    }

    public static SourceFile9 indentWithSpaces(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("number is negative");
        }
        char[] cArray = new char[n];
        Arrays.fill(cArray, ' ');
        return new SourceFile9(cArray);
    }

    public static SourceFile9 indentWithTabs() {
        return new SourceFile9(new char[]{'\t'});
    }

    @Override
    protected SourceFile10 createWriter(Writer writer) {
        return new SourceFile$PrettyPrintWriter(writer, this.indentChars);
    }
}


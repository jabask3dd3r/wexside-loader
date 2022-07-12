/*
 * Decompiled with CFR 0.152.
 */
package com.eclipsesource.json;

import com.eclipsesource.json.SourceFile$1;
import com.eclipsesource.json.SourceFile10;
import com.eclipsesource.json.SourceFile9;
import java.io.Writer;

public abstract class SourceFile4 {
    public static SourceFile4 MINIMAL = new SourceFile$1();
    public static SourceFile4 PRETTY_PRINT = SourceFile9.indentWithSpaces(2);

    abstract SourceFile10 createWriter(Writer var1);
}


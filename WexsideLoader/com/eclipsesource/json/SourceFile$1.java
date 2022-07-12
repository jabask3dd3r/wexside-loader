/*
 * Decompiled with CFR 0.152.
 */
package com.eclipsesource.json;

import com.eclipsesource.json.SourceFile10;
import com.eclipsesource.json.SourceFile4;
import java.io.Writer;

final class SourceFile$1
extends SourceFile4 {
    SourceFile$1() {
    }

    @Override
    SourceFile10 createWriter(Writer writer) {
        return new SourceFile10(writer);
    }
}


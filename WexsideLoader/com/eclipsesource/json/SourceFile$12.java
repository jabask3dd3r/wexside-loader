/*
 * Decompiled with CFR 0.152.
 */
package com.eclipsesource.json;

import com.eclipsesource.json.SourceFile12;
import com.eclipsesource.json.SourceFile8;
import java.util.Iterator;

class SourceFile$12
implements Iterator {
    final /* synthetic */ Iterator val$iterator;
    final /* synthetic */ SourceFile12 this$0;

    SourceFile$12(SourceFile12 sourceFile12, Iterator iterator) {
        this.this$0 = sourceFile12;
        this.val$iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.val$iterator.hasNext();
    }

    public SourceFile8 next() {
        return (SourceFile8)this.val$iterator.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}


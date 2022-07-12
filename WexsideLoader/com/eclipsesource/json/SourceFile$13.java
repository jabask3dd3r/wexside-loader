/*
 * Decompiled with CFR 0.152.
 */
package com.eclipsesource.json;

import com.eclipsesource.json.SourceFile$Member;
import com.eclipsesource.json.SourceFile5;
import com.eclipsesource.json.SourceFile8;
import java.util.Iterator;

class SourceFile$13
implements Iterator {
    final /* synthetic */ Iterator val$namesIterator;
    final /* synthetic */ Iterator val$valuesIterator;
    final /* synthetic */ SourceFile5 this$0;

    SourceFile$13(SourceFile5 sourceFile5, Iterator iterator, Iterator iterator2) {
        this.this$0 = sourceFile5;
        this.val$namesIterator = iterator;
        this.val$valuesIterator = iterator2;
    }

    @Override
    public boolean hasNext() {
        return this.val$namesIterator.hasNext();
    }

    public SourceFile$Member next() {
        String string = (String)this.val$namesIterator.next();
        SourceFile8 sourceFile8 = (SourceFile8)this.val$valuesIterator.next();
        return new SourceFile$Member(string, sourceFile8);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}


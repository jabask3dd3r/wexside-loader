/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import launcher.SourceFile2;
import launcher.SourceFile3;
import launcher.SourceFile5;
import launcher.SourceFile51;
import launcher.SourceFile56;
import launcher.SourceFile61;
import launcher.SourceFile72;

public final class SourceFile86
extends SourceFile51 {
    @SourceFile3
    public SourceFile86(SourceFile2 sourceFile2) {
        super(sourceFile2);
    }

    @SourceFile3
    public SourceFile86() {
        this(null);
    }

    @Override
    public SourceFile56 getType() {
        return SourceFile56.UPDATE_LIST;
    }

    protected Set keepErJErRy6HE(SourceFile5 sourceFile5, SourceFile61 sourceFile61) {
        int n = sourceFile5.readLength(0);
        HashSet<String> hashSet = new HashSet<String>(n);
        for (int i = 0; i < n; ++i) {
            hashSet.add(SourceFile72.verifyFileName(sourceFile5.readString(255)));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Override
    protected /* synthetic */ Object requestDo(SourceFile5 sourceFile5, SourceFile61 sourceFile61) {
        return this.keepErJErRy6HE(sourceFile5, sourceFile61);
    }
}


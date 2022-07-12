/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import launcher.SourceFile18;
import launcher.SourceFile3;
import launcher.SourceFile78;

public final class SourceFile {
    @SourceFile3
    public final SourceFile18 mismatch;
    @SourceFile3
    public final SourceFile18 extra;

    private SourceFile(SourceFile18 sourceFile18, SourceFile18 sourceFile182) {
        this.mismatch = sourceFile18;
        this.extra = sourceFile182;
    }

    @SourceFile3
    public boolean isSame() {
        return this.mismatch.isEmpty() && this.extra.isEmpty();
    }

    /* synthetic */ SourceFile(SourceFile18 sourceFile18, SourceFile18 sourceFile182, SourceFile78 sourceFile78) {
        this(sourceFile18, sourceFile182);
    }
}


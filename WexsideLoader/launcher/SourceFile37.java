/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import launcher.SourceFile3;
import launcher.SourceFile35;
import launcher.SourceFile45;
import launcher.SourceFile5;
import launcher.SourceFile61;

public final class SourceFile37
extends SourceFile35 {
    @SourceFile3
    public SourceFile37(boolean bl, boolean bl2, int n) {
        super(bl, bl2, n);
    }

    @SourceFile3
    public SourceFile37(SourceFile5 sourceFile5, boolean bl) {
        this(sourceFile5.readBoolean(), bl, 0);
    }

    @Override
    public SourceFile45 getType() {
        return SourceFile45.BOOLEAN;
    }

    @Override
    public void write(SourceFile61 sourceFile61) {
        sourceFile61.writeBoolean((Boolean)this.getValue());
    }
}


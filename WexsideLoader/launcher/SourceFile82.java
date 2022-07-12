/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import launcher.SourceFile3;
import launcher.SourceFile35;
import launcher.SourceFile45;
import launcher.SourceFile5;
import launcher.SourceFile61;

public final class SourceFile82
extends SourceFile35 {
    @SourceFile3
    public SourceFile82(int n, boolean bl, int n2) {
        super(n, bl, n2);
    }

    @SourceFile3
    public SourceFile82(SourceFile5 sourceFile5, boolean bl) {
        this(sourceFile5.readVarInt(), bl, 0);
    }

    @Override
    public SourceFile45 getType() {
        return SourceFile45.INTEGER;
    }

    @Override
    public void write(SourceFile61 sourceFile61) {
        sourceFile61.writeVarInt((Integer)this.getValue());
    }
}


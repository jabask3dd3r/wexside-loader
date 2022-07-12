/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.util.Objects;
import launcher.SourceFile19;
import launcher.SourceFile3;
import launcher.SourceFile61;
import launcher.SourceFile83;

public abstract class SourceFile64
extends SourceFile19 {
    @SourceFile3
    public final SourceFile83 block;

    @SourceFile3
    protected SourceFile64(SourceFile83 sourceFile83) {
        this.block = Objects.requireNonNull(sourceFile83, "block");
    }

    @Override
    public final void write(SourceFile61 sourceFile61) {
        this.block.write(sourceFile61);
    }
}


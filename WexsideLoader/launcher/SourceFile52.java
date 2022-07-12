/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import launcher.SourceFile2;
import launcher.SourceFile3;
import launcher.SourceFile5;
import launcher.SourceFile51;
import launcher.SourceFile56;
import launcher.SourceFile61;
import launcher.SourceFile75;

public abstract class SourceFile52
extends SourceFile51 {
    @SourceFile3
    public SourceFile52(SourceFile2 sourceFile2) {
        super(sourceFile2);
    }

    @SourceFile3
    public SourceFile52() {
        this(null);
    }

    @Override
    public final SourceFile56 getType() {
        return SourceFile56.CUSTOM;
    }

    @Override
    protected final Object requestDo(SourceFile5 sourceFile5, SourceFile61 sourceFile61) {
        sourceFile61.writeASCII(SourceFile75.verifyIDName(this.getName()), 255);
        sourceFile61.flush();
        return this.requestDoCustom(sourceFile5, sourceFile61);
    }

    @SourceFile3
    public abstract String getName();

    @SourceFile3
    protected abstract Object requestDoCustom(SourceFile5 var1, SourceFile61 var2);
}


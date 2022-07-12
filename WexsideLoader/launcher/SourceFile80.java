/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import launcher.SourceFile3;
import launcher.SourceFile35;
import launcher.SourceFile45;
import launcher.SourceFile5;
import launcher.SourceFile61;

public final class SourceFile80
extends SourceFile35 {
    @SourceFile3
    public SourceFile80(String string, boolean bl, int n) {
        super(string, bl, n);
    }

    @SourceFile3
    public SourceFile80(SourceFile5 sourceFile5, boolean bl) {
        this(sourceFile5.readString(0), bl, 0);
    }

    @Override
    public SourceFile45 getType() {
        return SourceFile45.STRING;
    }

    protected void keepErJErRy6HE(String string) {
        super.keepErJErRy6HE(string);
    }

    @Override
    public void write(SourceFile61 sourceFile61) {
        sourceFile61.writeString((String)this.getValue(), 0);
    }
}


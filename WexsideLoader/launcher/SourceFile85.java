/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import launcher.SourceFile16;
import launcher.SourceFile2;
import launcher.SourceFile3;
import launcher.SourceFile5;
import launcher.SourceFile51;
import launcher.SourceFile56;
import launcher.SourceFile61;
import launcher.SourceFile75;

public final class SourceFile85
extends SourceFile51 {
    private final String keepErJErRy6HE;

    @SourceFile3
    public SourceFile85(SourceFile2 sourceFile2, String string) {
        super(sourceFile2);
        this.keepErJErRy6HE = SourceFile75.verifyUsername(string);
    }

    @SourceFile3
    public SourceFile85(String string) {
        this(null, string);
    }

    @Override
    public SourceFile56 getType() {
        return SourceFile56.PROFILE_BY_USERNAME;
    }

    protected SourceFile16 keepErJErRy6HE(SourceFile5 sourceFile5, SourceFile61 sourceFile61) {
        sourceFile61.writeString(this.keepErJErRy6HE, 64);
        sourceFile61.flush();
        return sourceFile5.readBoolean() ? new SourceFile16(sourceFile5) : null;
    }

    @Override
    protected /* synthetic */ Object requestDo(SourceFile5 sourceFile5, SourceFile61 sourceFile61) {
        return this.keepErJErRy6HE(sourceFile5, sourceFile61);
    }
}


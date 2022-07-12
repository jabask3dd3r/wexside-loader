/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.io.IOException;
import launcher.SourceFile2;
import launcher.SourceFile3;
import launcher.SourceFile5;
import launcher.SourceFile51;
import launcher.SourceFile56;
import launcher.SourceFile61;

public final class SourceFile4
extends SourceFile51 {
    @SourceFile3
    public static final byte EXPECTED_BYTE = 85;

    @SourceFile3
    public SourceFile4(SourceFile2 sourceFile2) {
        super(sourceFile2);
    }

    @SourceFile3
    public SourceFile4() {
        this(null);
    }

    @Override
    public SourceFile56 getType() {
        return SourceFile56.PING;
    }

    protected Void keepErJErRy6HE(SourceFile5 sourceFile5, SourceFile61 sourceFile61) {
        byte by = (byte)sourceFile5.readUnsignedByte();
        if (by != 85) {
            throw new IOException("Illegal ping response: " + by);
        }
        return null;
    }

    @Override
    protected /* synthetic */ Object requestDo(SourceFile5 sourceFile5, SourceFile61 sourceFile61) {
        return this.keepErJErRy6HE(sourceFile5, sourceFile61);
    }
}


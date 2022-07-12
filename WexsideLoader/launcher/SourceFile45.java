/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import launcher.SourceFile12;
import launcher.SourceFile3;
import launcher.SourceFile5;
import launcher.SourceFile6;

@SourceFile3
public enum SourceFile45 implements SourceFile6
{
    BLOCK(1),
    BOOLEAN(2),
    INTEGER(3),
    STRING(4),
    LIST(5);

    private static final SourceFile12 SERIALIZER;
    private final int n;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SourceFile45() {
        void var3_1;
        this.n = var3_1;
    }

    public static SourceFile45 read(SourceFile5 sourceFile5) {
        return (SourceFile45)SERIALIZER.read(sourceFile5);
    }

    @Override
    public int getNumber() {
        return this.n;
    }

    static {
        SERIALIZER = new SourceFile12(SourceFile45.class);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import launcher.SourceFile12;
import launcher.SourceFile3;
import launcher.SourceFile5;
import launcher.SourceFile6;

@SourceFile3
public enum SourceFile58 implements SourceFile6
{
    DIR(1),
    FILE(2);

    private static final SourceFile12 SERIALIZER;
    private final int n;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SourceFile58() {
        void var3_1;
        this.n = var3_1;
    }

    public static SourceFile58 read(SourceFile5 sourceFile5) {
        return (SourceFile58)SERIALIZER.read(sourceFile5);
    }

    @Override
    public int getNumber() {
        return this.n;
    }

    static {
        SERIALIZER = new SourceFile12(SourceFile58.class);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import launcher.SourceFile12;
import launcher.SourceFile5;
import launcher.SourceFile6;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class SourceFile11
extends Enum
implements SourceFile6 {
    public static final /* enum */ SourceFile11 keepErJErRy6HE = new SourceFile11("CD", 0, 1);
    public static final /* enum */ SourceFile11 KeePerjeRryt52 = new SourceFile11("CD_BACK", 1, 2);
    public static final /* enum */ SourceFile11 keEPERjERryabM = new SourceFile11("GET", 2, 3);
    public static final /* enum */ SourceFile11 keEpErjeRRYsAK = new SourceFile11("FINISH", 3, 255);
    private static final SourceFile12 keepErJErRy6HE;
    private final int keepErJErRy6HE;
    private static final /* synthetic */ SourceFile11[] keepErJErRy6HE;

    public static SourceFile11[] values() {
        return (SourceFile11[])keepErJErRy6HE.clone();
    }

    public static SourceFile11 valueOf(String string) {
        return Enum.valueOf(SourceFile11.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SourceFile11() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.keepErJErRy6HE = var3_1;
    }

    public static SourceFile11 keepErJErRy6HE(SourceFile5 sourceFile5) {
        return (SourceFile11)keepErJErRy6HE.read(sourceFile5);
    }

    @Override
    public int getNumber() {
        return this.keepErJErRy6HE;
    }

    static {
        keepErJErRy6HE = new SourceFile11[]{keepErJErRy6HE, KeePerjeRryt52, keEPERjERryabM, keEpErjeRRYsAK};
        keepErJErRy6HE = new SourceFile12(SourceFile11.class);
    }
}


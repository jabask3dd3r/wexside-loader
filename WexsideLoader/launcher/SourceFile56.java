/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import launcher.SourceFile12;
import launcher.SourceFile3;
import launcher.SourceFile5;
import launcher.SourceFile6;

@SourceFile3
public enum SourceFile56 implements SourceFile6
{
    PING(0),
    LAUNCHER(1),
    UPDATE(2),
    UPDATE_LIST(3),
    AUTH(4),
    JOIN_SERVER(5),
    CHECK_SERVER(6),
    PROFILE_BY_USERNAME(7),
    PROFILE_BY_UUID(8),
    BATCH_PROFILE_BY_USERNAME(9),
    CUSTOM(255);

    private static final SourceFile12 SERIALIZER;
    private final int n;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SourceFile56() {
        void var3_1;
        this.n = var3_1;
    }

    @SourceFile3
    public static SourceFile56 read(SourceFile5 sourceFile5) {
        return (SourceFile56)SERIALIZER.read(sourceFile5);
    }

    @Override
    public int getNumber() {
        return this.n;
    }

    static {
        SERIALIZER = new SourceFile12(SourceFile56.class);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.util.Collections;
import java.util.List;
import launcher.SourceFile23;
import launcher.SourceFile3;

public final class SourceFile73 {
    @SourceFile3
    public final List profiles;
    private final byte[] keepErJErRy6HE;
    private final byte[] KeePerjeRryt52;

    private SourceFile73(byte[] byArray, byte[] byArray2, List list) {
        this.keepErJErRy6HE = byArray == null ? null : (byte[])byArray.clone();
        this.KeePerjeRryt52 = (byte[])byArray2.clone();
        this.profiles = Collections.unmodifiableList(list);
    }

    @SourceFile3
    public byte[] getBinary() {
        return this.keepErJErRy6HE == null ? null : (byte[])this.keepErJErRy6HE.clone();
    }

    @SourceFile3
    public byte[] getSign() {
        return (byte[])this.KeePerjeRryt52.clone();
    }

    static /* synthetic */ byte[] keepErJErRy6HE(SourceFile73 sourceFile73) {
        return sourceFile73.keepErJErRy6HE;
    }

    static /* synthetic */ byte[] KeePerjeRryt52(SourceFile73 sourceFile73) {
        return sourceFile73.KeePerjeRryt52;
    }

    /* synthetic */ SourceFile73(byte[] byArray, byte[] byArray2, List list, SourceFile23 sourceFile23) {
        this(byArray, byArray2, list);
    }
}


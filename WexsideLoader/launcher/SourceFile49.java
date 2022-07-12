/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.util.Arrays;
import java.util.Collection;
import launcher.SourceFile3;
import launcher.SourceFile69;

public final class SourceFile49 {
    private static final SourceFile69[] keepErJErRy6HE = new SourceFile69[0];
    private final SourceFile69[] KeePerjeRryt52;
    private final SourceFile69[] keEPERjERryabM;
    private final SourceFile69[] keEpErjeRRYsAK;

    @SourceFile3
    public SourceFile49(String[] stringArray, String[] stringArray2, String[] stringArray3) {
        this.KeePerjeRryt52 = SourceFile49.keepErJErRy6HE(stringArray);
        this.keEPERjERryabM = SourceFile49.keepErJErRy6HE(stringArray2);
        this.keEpErjeRRYsAK = SourceFile49.keepErJErRy6HE(stringArray3);
    }

    private SourceFile49(SourceFile69[] sourceFile69Array, SourceFile69[] sourceFile69Array2, SourceFile69[] sourceFile69Array3) {
        this.KeePerjeRryt52 = sourceFile69Array;
        this.keEPERjERryabM = sourceFile69Array2;
        this.keEpErjeRRYsAK = sourceFile69Array3;
    }

    private static boolean keepErJErRy6HE(SourceFile69[] sourceFile69Array, Collection collection) {
        return Arrays.stream(sourceFile69Array).anyMatch(sourceFile69 -> SourceFile69.keepErJErRy6HE(sourceFile69, collection));
    }

    private static SourceFile69[] keepErJErRy6HE(String ... stringArray) {
        return (SourceFile69[])Arrays.stream(stringArray).map(charSequence -> new SourceFile69((CharSequence)charSequence, null)).toArray(SourceFile69[]::new);
    }

    @SourceFile3
    public boolean shouldUpdate(Collection collection) {
        return (SourceFile49.keepErJErRy6HE(this.KeePerjeRryt52, collection) || SourceFile49.keepErJErRy6HE(this.keEPERjERryabM, collection)) && !SourceFile49.keepErJErRy6HE(this.keEpErjeRRYsAK, collection);
    }

    @SourceFile3
    public boolean shouldVerify(Collection collection) {
        return SourceFile49.keepErJErRy6HE(this.keEPERjERryabM, collection) && !SourceFile49.keepErJErRy6HE(this.keEpErjeRRYsAK, collection);
    }

    @SourceFile3
    public SourceFile49 verifyOnly() {
        return new SourceFile49(keepErJErRy6HE, this.keEPERjERryabM, this.keEpErjeRRYsAK);
    }
}


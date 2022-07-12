/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import launcher.SourceFile11;
import launcher.SourceFile12;
import launcher.SourceFile19;
import launcher.SourceFile5;
import launcher.SourceFile61;
import launcher.SourceFile62;
import launcher.SourceFile72;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class SourceFile47
extends SourceFile19 {
    public static final SourceFile47 keepErJErRy6HE = new SourceFile47(SourceFile11.KeePerjeRryt52, null, null);
    public static final SourceFile47 KeePerjeRryt52 = new SourceFile47(SourceFile11.keEpErjeRRYsAK, null, null);
    public final SourceFile11 keepErJErRy6HE;
    public final String keepErJErRy6HE;
    public final SourceFile62 keepErJErRy6HE;

    public SourceFile47(SourceFile11 sourceFile11, String string, SourceFile62 sourceFile62) {
        this.keepErJErRy6HE = sourceFile11;
        this.keepErJErRy6HE = string;
        this.keepErJErRy6HE = sourceFile62;
    }

    public SourceFile47(SourceFile5 sourceFile5) {
        this.keepErJErRy6HE = SourceFile11.keepErJErRy6HE(sourceFile5);
        this.keepErJErRy6HE = this.keepErJErRy6HE == SourceFile11.keepErJErRy6HE || this.keepErJErRy6HE == SourceFile11.keEPERjERryabM ? SourceFile72.verifyFileName(sourceFile5.readString(255)) : null;
        this.keepErJErRy6HE = null;
    }

    @Override
    public void write(SourceFile61 sourceFile61) {
        SourceFile12.write(sourceFile61, this.keepErJErRy6HE);
        if (this.keepErJErRy6HE == SourceFile11.keepErJErRy6HE || this.keepErJErRy6HE == SourceFile11.keEPERjERryabM) {
            sourceFile61.writeString(this.keepErJErRy6HE, 255);
        }
    }
}


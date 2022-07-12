/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import launcher.SourceFile19;
import launcher.SourceFile3;
import launcher.SourceFile34;
import launcher.SourceFile5;
import launcher.SourceFile70;

public final class SourceFile39
extends SourceFile70 {
    @SourceFile3
    public final SourceFile19 object;

    @SourceFile3
    public SourceFile39(SourceFile5 sourceFile5, RSAPublicKey rSAPublicKey, SourceFile34 sourceFile34) {
        super(sourceFile5, rSAPublicKey);
        this.object = this.newInstance(sourceFile34);
    }

    @SourceFile3
    public SourceFile39(SourceFile19 sourceFile19, RSAPrivateKey rSAPrivateKey) {
        super(sourceFile19.write(), rSAPrivateKey);
        this.object = sourceFile19;
    }

    public boolean equals(Object object) {
        return object instanceof SourceFile39 && this.object.equals(((SourceFile39)object).object);
    }

    public int hashCode() {
        return this.object.hashCode();
    }

    public String toString() {
        return this.object.toString();
    }

    @SourceFile3
    public SourceFile19 newInstance(SourceFile34 sourceFile34) {
        try (SourceFile5 sourceFile5 = new SourceFile5(this.keepErJErRy6HE);){
            SourceFile19 sourceFile19 = sourceFile34.convert(sourceFile5);
            return sourceFile19;
        }
    }
}


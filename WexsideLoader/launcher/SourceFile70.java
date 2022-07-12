/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import launcher.SourceFile19;
import launcher.SourceFile3;
import launcher.SourceFile5;
import launcher.SourceFile54;
import launcher.SourceFile61;

public class SourceFile70
extends SourceFile19 {
    protected final byte[] keepErJErRy6HE;
    private final byte[] KeePerjeRryt52;

    @SourceFile3
    public SourceFile70(SourceFile5 sourceFile5, RSAPublicKey rSAPublicKey) {
        this(sourceFile5.readByteArray(0), sourceFile5.readByteArray(-256), rSAPublicKey);
    }

    @SourceFile3
    public SourceFile70(byte[] byArray, byte[] byArray2, RSAPublicKey rSAPublicKey) {
        SourceFile54.verifySign(byArray, byArray2, rSAPublicKey);
        this.keepErJErRy6HE = (byte[])byArray.clone();
        this.KeePerjeRryt52 = (byte[])byArray2.clone();
    }

    @SourceFile3
    public SourceFile70(byte[] byArray, RSAPrivateKey rSAPrivateKey) {
        this.keepErJErRy6HE = (byte[])byArray.clone();
        this.KeePerjeRryt52 = SourceFile54.sign(byArray, rSAPrivateKey);
    }

    @Override
    public final void write(SourceFile61 sourceFile61) {
        sourceFile61.writeByteArray(this.keepErJErRy6HE, 0);
        sourceFile61.writeByteArray(this.KeePerjeRryt52, -256);
    }

    @SourceFile3
    public final byte[] getBytes() {
        return (byte[])this.keepErJErRy6HE.clone();
    }

    @SourceFile3
    public final byte[] getSign() {
        return (byte[])this.KeePerjeRryt52.clone();
    }
}


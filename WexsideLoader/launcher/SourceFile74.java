/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.nio.file.Path;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.Collections;
import launcher.SourceFile2;
import launcher.SourceFile3;
import launcher.SourceFile30;
import launcher.SourceFile39;
import launcher.SourceFile5;
import launcher.SourceFile51;
import launcher.SourceFile54;
import launcher.SourceFile56;
import launcher.SourceFile61;
import launcher.SourceFile7;
import launcher.SourceFile71;
import launcher.SourceFile72;
import launcher.SourceFile73;
import launcher.SourceFile8;
import launcher.SourceFile81;

public final class SourceFile74
extends SourceFile51 {
    @SourceFile3
    public static final Path BINARY_PATH = SourceFile72.getCodeSource(SourceFile71.class);
    @SourceFile3
    public static final boolean EXE_BINARY = SourceFile72.hasExtension(BINARY_PATH, "exe");

    @SourceFile3
    public SourceFile74(SourceFile2 sourceFile2) {
        super(sourceFile2);
    }

    @SourceFile3
    public SourceFile74() {
        this(null);
    }

    @SourceFile3
    public static void update(SourceFile2 sourceFile2, SourceFile73 sourceFile73) {
        SourceFile54.verifySign(SourceFile73.keepErJErRy6HE(sourceFile73), SourceFile73.KeePerjeRryt52(sourceFile73), sourceFile2.publicKey);
        ArrayList<String> arrayList = new ArrayList<String>(8);
        arrayList.add(SourceFile72.resolveJavaBin(null).toString());
        if (SourceFile30.isDebugEnabled()) {
            arrayList.add(SourceFile7.keepErJErRy6HE("launcher.debug", Boolean.toString(SourceFile30.isDebugEnabled())));
        }
        if (SourceFile2.ADDRESS_OVERRIDE != null) {
            arrayList.add(SourceFile7.keepErJErRy6HE("launcher.addressOverride", SourceFile2.ADDRESS_OVERRIDE));
        }
        arrayList.add("-jar");
        arrayList.add(BINARY_PATH.toString());
        ProcessBuilder processBuilder = new ProcessBuilder(arrayList.toArray(new String[arrayList.size()]));
        processBuilder.inheritIO();
        SourceFile72.write(BINARY_PATH, SourceFile73.keepErJErRy6HE(sourceFile73));
        processBuilder.start();
        SourceFile81.RUNTIME.exit(255);
        throw new AssertionError((Object)"Why Launcher wasn't restarted?!");
    }

    @Override
    public SourceFile56 getType() {
        return SourceFile56.LAUNCHER;
    }

    protected SourceFile73 keepErJErRy6HE(SourceFile5 sourceFile5, SourceFile61 sourceFile61) {
        sourceFile61.writeBoolean(EXE_BINARY);
        sourceFile61.flush();
        this.readError(sourceFile5);
        RSAPublicKey rSAPublicKey = this.config.publicKey;
        byte[] byArray = sourceFile5.readByteArray(-256);
        boolean bl = !SourceFile54.isValidSign(BINARY_PATH, byArray, rSAPublicKey);
        sourceFile61.writeBoolean(bl);
        sourceFile61.flush();
        if (bl) {
            byte[] byArray2 = sourceFile5.readByteArray(0);
            SourceFile54.verifySign(byArray2, byArray, this.config.publicKey);
            return new SourceFile73(byArray2, byArray, Collections.emptyList(), null);
        }
        int n = sourceFile5.readLength(0);
        ArrayList<SourceFile39> arrayList = new ArrayList<SourceFile39>(n);
        for (int i = 0; i < n; ++i) {
            arrayList.add(new SourceFile39(sourceFile5, rSAPublicKey, SourceFile8.RO_ADAPTER));
        }
        return new SourceFile73(null, byArray, arrayList, null);
    }

    @Override
    protected /* synthetic */ Object requestDo(SourceFile5 sourceFile5, SourceFile61 sourceFile61) {
        return this.keepErJErRy6HE(sourceFile5, sourceFile61);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.nio.file.Path;
import launcher.SourceFile16;
import launcher.SourceFile19;
import launcher.SourceFile3;
import launcher.SourceFile5;
import launcher.SourceFile54;
import launcher.SourceFile61;
import launcher.SourceFile72;

public final class SourceFile29
extends SourceFile19 {
    @SourceFile3
    public final Path assetDir;
    @SourceFile3
    public final Path clientDir;
    @SourceFile3
    public final SourceFile16 pp;
    @SourceFile3
    public final String accessToken;
    @SourceFile3
    public final boolean autoEnter;
    @SourceFile3
    public final boolean fullScreen;
    @SourceFile3
    public final int ram;
    @SourceFile3
    public final int width;
    @SourceFile3
    public final int height;
    private final byte[] keepErJErRy6HE;

    @SourceFile3
    public SourceFile29(byte[] byArray, Path path, Path path2, SourceFile16 sourceFile16, String string, boolean bl, boolean bl2, int n, int n2, int n3) {
        this.keepErJErRy6HE = (byte[])byArray.clone();
        this.assetDir = path;
        this.clientDir = path2;
        this.pp = sourceFile16;
        this.accessToken = SourceFile54.verifyToken(string);
        this.autoEnter = bl;
        this.fullScreen = bl2;
        this.ram = n;
        this.width = n2;
        this.height = n3;
    }

    @SourceFile3
    public SourceFile29(SourceFile5 sourceFile5) {
        this.keepErJErRy6HE = sourceFile5.readByteArray(-256);
        this.assetDir = SourceFile72.toPath(sourceFile5.readString(0));
        this.clientDir = SourceFile72.toPath(sourceFile5.readString(0));
        this.pp = new SourceFile16(sourceFile5);
        int n = sourceFile5.readInt();
        this.accessToken = SourceFile54.verifyToken(sourceFile5.readASCII(-n));
        this.autoEnter = sourceFile5.readBoolean();
        this.fullScreen = sourceFile5.readBoolean();
        this.ram = sourceFile5.readVarInt();
        this.width = sourceFile5.readVarInt();
        this.height = sourceFile5.readVarInt();
    }

    @Override
    public void write(SourceFile61 sourceFile61) {
        sourceFile61.writeByteArray(this.keepErJErRy6HE, -256);
        sourceFile61.writeString(this.assetDir.toString(), 0);
        sourceFile61.writeString(this.clientDir.toString(), 0);
        this.pp.write(sourceFile61);
        sourceFile61.writeInt(this.accessToken.length());
        sourceFile61.writeASCII(this.accessToken, -this.accessToken.length());
        sourceFile61.writeBoolean(this.autoEnter);
        sourceFile61.writeBoolean(this.fullScreen);
        sourceFile61.writeVarInt(this.ram);
        sourceFile61.writeVarInt(this.width);
        sourceFile61.writeVarInt(this.height);
    }

    static /* synthetic */ byte[] keepErJErRy6HE(SourceFile29 sourceFile29) {
        return sourceFile29.keepErJErRy6HE;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.nio.file.Path;
import java.util.Arrays;
import launcher.SourceFile3;
import launcher.SourceFile5;
import launcher.SourceFile54;
import launcher.SourceFile58;
import launcher.SourceFile61;
import launcher.SourceFile62;
import launcher.SourceFile63;
import launcher.SourceFile72;
import launcher.SourceFile75;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class SourceFile43
extends SourceFile62 {
    public static final SourceFile63 keepErJErRy6HE = SourceFile63.MD5;
    @SourceFile3
    public final long size;
    private final byte[] keepErJErRy6HE;

    @SourceFile3
    public SourceFile43(long l, byte[] byArray) {
        this.size = SourceFile75.verifyLong(l, SourceFile75.L_NOT_NEGATIVE, "Illegal size: " + l);
        this.keepErJErRy6HE = byArray == null ? null : (byte[])keepErJErRy6HE.verify(byArray).clone();
    }

    @SourceFile3
    public SourceFile43(Path path, long l, boolean bl) {
        this(l, bl ? SourceFile54.digest(keepErJErRy6HE, path) : null);
    }

    @SourceFile3
    public SourceFile43(SourceFile5 sourceFile5) {
        this(sourceFile5.readVarLong(), sourceFile5.readBoolean() ? sourceFile5.readByteArray(-SourceFile43.keepErJErRy6HE.bytes) : null);
    }

    @Override
    public SourceFile58 getType() {
        return SourceFile58.FILE;
    }

    @Override
    public long size() {
        return this.size;
    }

    @Override
    public void write(SourceFile61 sourceFile61) {
        sourceFile61.writeVarLong(this.size);
        sourceFile61.writeBoolean(this.keepErJErRy6HE != null);
        if (this.keepErJErRy6HE != null) {
            sourceFile61.writeByteArray(this.keepErJErRy6HE, -SourceFile43.keepErJErRy6HE.bytes);
        }
    }

    @SourceFile3
    public boolean isSame(SourceFile43 sourceFile43) {
        return this.size == sourceFile43.size && (this.keepErJErRy6HE == null || sourceFile43.keepErJErRy6HE == null || Arrays.equals(this.keepErJErRy6HE, sourceFile43.keepErJErRy6HE));
    }

    @SourceFile3
    public boolean isSame(Path path, boolean bl) {
        if (this.size != SourceFile72.readAttributes(path).size()) {
            return false;
        }
        if (!bl || this.keepErJErRy6HE == null) {
            return true;
        }
        byte[] byArray = SourceFile54.digest(keepErJErRy6HE, path);
        return Arrays.equals(this.keepErJErRy6HE, byArray);
    }

    @SourceFile3
    public boolean isSameDigest(byte[] byArray) {
        return this.keepErJErRy6HE == null || byArray == null || Arrays.equals(this.keepErJErRy6HE, byArray);
    }
}


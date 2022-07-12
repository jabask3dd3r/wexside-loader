/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.util.HashMap;
import java.util.Map;
import launcher.SourceFile3;
import launcher.SourceFile54;
import launcher.SourceFile75;

@SourceFile3
public final class SourceFile63
extends Enum {
    public static final /* enum */ SourceFile63 PLAIN;
    public static final /* enum */ SourceFile63 MD5;
    public static final /* enum */ SourceFile63 SHA1;
    public static final /* enum */ SourceFile63 SHA224;
    public static final /* enum */ SourceFile63 SHA256;
    public static final /* enum */ SourceFile63 SHA512;
    private static final Map ALGORITHMS;
    public final String name;
    public final int bits;
    public final int bytes;
    private static final /* synthetic */ SourceFile63[] $VALUES;
    static final /* synthetic */ boolean $assertionsDisabled;

    public static SourceFile63[] values() {
        return (SourceFile63[])$VALUES.clone();
    }

    public static SourceFile63 valueOf(String string) {
        return Enum.valueOf(SourceFile63.class, string);
    }

    /*
     * WARNING - void declaration
     */
    private SourceFile63() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.name = var3_1;
        this.bits = var4_2;
        this.bytes = var4_2 / 8;
        if (!$assertionsDisabled && var4_2 % 8 != false) {
            throw new AssertionError();
        }
    }

    public static SourceFile63 byName(String string) {
        return (SourceFile63)((Object)SourceFile75.getMapValue(ALGORITHMS, string, String.format("Unknown digest algorithm: '%s'", string)));
    }

    public String toString() {
        return this.name;
    }

    public byte[] verify(byte[] byArray) {
        if (byArray.length != this.bytes) {
            throw new IllegalArgumentException("Invalid digest length: " + byArray.length);
        }
        return byArray;
    }

    static {
        $assertionsDisabled = !SourceFile54.class.desiredAssertionStatus();
        PLAIN = new SourceFile63("PLAIN", 0, "plain", -1);
        MD5 = new SourceFile63("MD5", 1, "MD5", 128);
        SHA1 = new SourceFile63("SHA1", 2, "SHA-1", 160);
        SHA224 = new SourceFile63("SHA224", 3, "SHA-224", 224);
        SHA256 = new SourceFile63("SHA256", 4, "SHA-256", 256);
        SHA512 = new SourceFile63("SHA512", 5, "SHA-512", 512);
        $VALUES = new SourceFile63[]{PLAIN, MD5, SHA1, SHA224, SHA256, SHA512};
        SourceFile63[] sourceFile63Array = SourceFile63.values();
        ALGORITHMS = new HashMap(sourceFile63Array.length);
        for (SourceFile63 sourceFile63 : sourceFile63Array) {
            ALGORITHMS.put(sourceFile63.name, sourceFile63);
        }
    }
}


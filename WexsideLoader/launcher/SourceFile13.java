/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import launcher.SourceFile3;

@SourceFile3
public enum SourceFile13 {
    MUSTDIE("mustdie"),
    LINUX("linux"),
    MACOSX("macosx");

    public final String name;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SourceFile13() {
        void var3_1;
        this.name = var3_1;
    }

    public static SourceFile13 byName(String string) {
        if (string.startsWith("Windows")) {
            return MUSTDIE;
        }
        if (string.startsWith("Linux")) {
            return LINUX;
        }
        if (string.startsWith("Mac OS X")) {
            return MACOSX;
        }
        throw new RuntimeException(String.format("This shit is not yet supported: '%s'", string));
    }
}


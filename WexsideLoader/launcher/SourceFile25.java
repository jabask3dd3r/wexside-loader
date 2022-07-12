/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import launcher.SourceFile3;

@SourceFile3
public enum SourceFile25 {
    DEBUG("DEBUG"),
    INFO("INFO"),
    WARNING("WARN"),
    ERROR("ERROR");

    public final String name;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SourceFile25() {
        void var3_1;
        this.name = var3_1;
    }

    public String toString() {
        return this.name;
    }
}


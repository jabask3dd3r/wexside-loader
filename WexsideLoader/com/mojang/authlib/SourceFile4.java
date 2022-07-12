/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib;

import java.util.HashMap;
import java.util.Map;

public enum SourceFile4 {
    LEGACY("legacy"),
    MOJANG("mojang");

    private static final Map BY_NAME;
    private final String name;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SourceFile4() {
        void var3_1;
        this.name = var3_1;
    }

    public static SourceFile4 byName(String string) {
        return (SourceFile4)((Object)BY_NAME.get(string.toLowerCase()));
    }

    public String getName() {
        return this.name;
    }

    static {
        BY_NAME = new HashMap();
        for (SourceFile4 sourceFile4 : SourceFile4.values()) {
            BY_NAME.put(sourceFile4.name, sourceFile4);
        }
    }
}


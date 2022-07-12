/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib;

public class SourceFile6 {
    public static final SourceFile6 MINECRAFT = new SourceFile6("Minecraft", 1);
    public static final SourceFile6 SCROLLS = new SourceFile6("Scrolls", 1);
    private final String name;
    private final int version;

    public SourceFile6(String string, int n) {
        this.name = string;
        this.version = n;
    }

    public String getName() {
        return this.name;
    }

    public int getVersion() {
        return this.version;
    }

    public String toString() {
        return "Agent{name='" + this.name + '\'' + ", version=" + this.version + '}';
    }
}


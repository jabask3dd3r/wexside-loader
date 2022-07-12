/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.yggdrasil;

public class SourceFile
extends RuntimeException {
    public SourceFile() {
    }

    public SourceFile(String string) {
        super(string);
    }

    public SourceFile(String string, Throwable throwable) {
        super(string, throwable);
    }

    public SourceFile(Throwable throwable) {
        super(throwable);
    }
}


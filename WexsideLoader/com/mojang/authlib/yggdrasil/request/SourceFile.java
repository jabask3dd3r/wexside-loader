/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.yggdrasil.request;

public class SourceFile {
    private String clientToken;
    private String accessToken;
    private com.mojang.authlib.SourceFile selectedProfile;
    private boolean requestUser = true;

    public SourceFile(String string, String string2) {
        this(string, string2, null);
    }

    public SourceFile(String string, String string2, com.mojang.authlib.SourceFile sourceFile) {
        this.clientToken = string2;
        this.accessToken = string;
        this.selectedProfile = sourceFile;
    }
}


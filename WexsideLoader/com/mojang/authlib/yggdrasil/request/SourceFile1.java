/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.yggdrasil.request;

import com.mojang.authlib.SourceFile6;

public class SourceFile1 {
    private SourceFile6 agent;
    private String username;
    private String password;
    private String clientToken;
    private boolean requestUser = true;

    public SourceFile1(SourceFile6 sourceFile6, String string, String string2, String string3) {
        this.agent = sourceFile6;
        this.username = string;
        this.password = string2;
        this.clientToken = string3;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.minecraft;

import com.mojang.authlib.SourceFile10;
import com.mojang.authlib.minecraft.SourceFile1;

public abstract class SourceFile5
implements SourceFile1 {
    private final SourceFile10 authenticationService;

    protected SourceFile5(SourceFile10 sourceFile10) {
        this.authenticationService = sourceFile10;
    }

    public SourceFile10 getAuthenticationService() {
        return this.authenticationService;
    }
}


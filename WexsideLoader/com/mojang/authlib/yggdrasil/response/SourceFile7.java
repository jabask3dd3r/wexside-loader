/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.yggdrasil.response;

import com.mojang.authlib.SourceFile;
import com.mojang.authlib.yggdrasil.response.SourceFile5;

public class SourceFile7
extends SourceFile5 {
    private SourceFile[] profiles;

    public SourceFile[] getProfiles() {
        return this.profiles;
    }

    static /* synthetic */ SourceFile[] access$002(SourceFile7 sourceFile7, SourceFile[] sourceFileArray) {
        sourceFile7.profiles = sourceFileArray;
        return sourceFileArray;
    }
}


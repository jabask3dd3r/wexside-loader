/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.yggdrasil;

import com.mojang.authlib.SourceFile9;
import com.mojang.authlib.minecraft.SourceFile4;
import com.mojang.authlib.yggdrasil.SourceFile6;
import java.util.UUID;

public class SourceFile8
implements SourceFile4 {
    public SourceFile8(SourceFile6 sourceFile6, String string, SourceFile9 sourceFile9) {
    }

    @Override
    public boolean serversAllowed() {
        return true;
    }

    @Override
    public boolean realmsAllowed() {
        return false;
    }

    @Override
    public boolean chatAllowed() {
        return true;
    }

    @Override
    public boolean isBlockedPlayer(UUID uUID) {
        return false;
    }
}


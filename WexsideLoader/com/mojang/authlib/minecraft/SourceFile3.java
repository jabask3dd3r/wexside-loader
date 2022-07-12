/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.minecraft;

import com.mojang.authlib.minecraft.SourceFile4;
import java.util.UUID;

public class SourceFile3
implements SourceFile4 {
    @Override
    public boolean serversAllowed() {
        return true;
    }

    @Override
    public boolean realmsAllowed() {
        return true;
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


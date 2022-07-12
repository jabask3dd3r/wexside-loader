/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.minecraft;

import java.util.UUID;

public interface SourceFile4 {
    public boolean serversAllowed();

    public boolean realmsAllowed();

    public boolean chatAllowed();

    public boolean isBlockedPlayer(UUID var1);
}


/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.yggdrasil.response;

import com.mojang.authlib.properties.SourceFile;
import com.mojang.authlib.yggdrasil.response.SourceFile5;
import java.util.UUID;

public class SourceFile2
extends SourceFile5 {
    private UUID id;
    private SourceFile properties;

    public UUID getId() {
        return this.id;
    }

    public SourceFile getProperties() {
        return this.properties;
    }
}


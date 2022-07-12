/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.yggdrasil.response;

import com.mojang.authlib.yggdrasil.response.SourceFile5;
import java.util.UUID;

public class SourceFile
extends SourceFile5 {
    private UUID id;
    private String name;
    private com.mojang.authlib.properties.SourceFile properties;

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public com.mojang.authlib.properties.SourceFile getProperties() {
        return this.properties;
    }
}


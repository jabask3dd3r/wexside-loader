/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.yggdrasil.response;

import java.util.Map;
import java.util.UUID;

public class SourceFile1 {
    private long timestamp;
    private UUID profileId;
    private String profileName;
    private boolean isPublic;
    private Map textures;

    public long getTimestamp() {
        return this.timestamp;
    }

    public UUID getProfileId() {
        return this.profileId;
    }

    public String getProfileName() {
        return this.profileName;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    public Map getTextures() {
        return this.textures;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.yggdrasil;

import java.util.UUID;
import launcher.SourceFile16;
import launcher.SourceFile3;
import launcher.SourceFile54;
import launcher.SourceFile7;

@SourceFile3
public class SourceFile9 {
    public static final String SKIN_URL_PROPERTY = "skinURL";
    public static final String SKIN_DIGEST_PROPERTY = "skinDigest";
    public static final String CLOAK_URL_PROPERTY = "cloakURL";
    public static final String CLOAK_DIGEST_PROPERTY = "cloakDigest";
    public final UUID uuid;
    public final String uuidHash;
    public final String username;
    public final String skinURL;
    public final String skinDigest;
    public final String cloakURL;
    public final String cloakDigest;

    public SourceFile9(UUID uUID, String string, String string2, String string3, String string4, String string5) {
        this.uuid = uUID;
        this.uuidHash = SourceFile7.toHash(uUID);
        this.username = string;
        this.skinURL = string2;
        this.skinDigest = string3;
        this.cloakURL = string4;
        this.cloakDigest = string5;
    }

    public static SourceFile9 fromPlayerProfile(SourceFile16 sourceFile16) {
        return sourceFile16 == null ? null : new SourceFile9(sourceFile16.uuid, sourceFile16.username, sourceFile16.skin == null ? null : sourceFile16.skin.url, sourceFile16.skin == null ? null : SourceFile54.toHex(sourceFile16.skin.digest), sourceFile16.cloak == null ? null : sourceFile16.cloak.url, sourceFile16.cloak == null ? null : SourceFile54.toHex(sourceFile16.cloak.digest));
    }

    public int countProperties() {
        int n = 0;
        if (this.skinURL != null) {
            ++n;
        }
        if (this.skinDigest != null) {
            ++n;
        }
        if (this.cloakURL != null) {
            ++n;
        }
        if (this.cloakDigest != null) {
            ++n;
        }
        return n;
    }
}


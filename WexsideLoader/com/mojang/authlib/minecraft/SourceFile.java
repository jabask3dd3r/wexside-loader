/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.minecraft;

import com.mojang.authlib.minecraft.SourceFile$Type;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public class SourceFile {
    public static final Set PROFILE_TEXTURE_TYPES = Collections.unmodifiableSet(EnumSet.allOf(SourceFile$Type.class));
    public static final int PROFILE_TEXTURE_COUNT = PROFILE_TEXTURE_TYPES.size();
    private final String url;
    private final String hash;

    public SourceFile(String string) {
        this(string, SourceFile.baseName(string));
    }

    public SourceFile(String string, String string2) {
        this.url = string;
        this.hash = string2;
    }

    private static String baseName(String string) {
        String string2 = string.substring(string.lastIndexOf(47) + 1);
        int n = string2.lastIndexOf(46);
        if (n >= 0) {
            string2 = string2.substring(0, n);
        }
        return string2;
    }

    public String getHash() {
        return this.hash;
    }

    public String getMetadata(String string) {
        return null;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return String.format("MinecraftProfileTexture{url='%s',hash=%s}", this.url, this.hash);
    }
}


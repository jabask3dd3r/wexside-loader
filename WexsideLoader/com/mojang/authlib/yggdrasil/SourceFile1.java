/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.yggdrasil;

import com.mojang.authlib.yggdrasil.SourceFile9;
import java.util.UUID;
import launcher.SourceFile16;
import launcher.SourceFile27;
import launcher.SourceFile28;
import launcher.SourceFile3;
import launcher.SourceFile30;
import launcher.SourceFile65;
import launcher.SourceFile67;
import launcher.SourceFile7;
import launcher.SourceFile85;

@SourceFile3
public class SourceFile1 {
    public static final int PROFILES_MAX_BATCH_SIZE = 128;

    private SourceFile1() {
    }

    public static SourceFile9 checkServer(String string, String string2) {
        SourceFile30.debug("CompatBridge.checkServer, Username: '%s', Server ID: %s", string, string2);
        return SourceFile9.fromPlayerProfile((SourceFile16)new SourceFile67(string, string2).request());
    }

    public static boolean joinServer(String string, String string2, String string3) {
        if (!SourceFile7.isLaunched()) {
            throw new IllegalStateException("Bad Login (Cheater)");
        }
        SourceFile30.debug("LegacyBridge.joinServer, Username: '%s', Access token: %s, Server ID: %s", string, string2, string3);
        return (Boolean)new SourceFile65(string, string2, string3).request();
    }

    public static SourceFile9 profileByUUID(UUID uUID) {
        return SourceFile9.fromPlayerProfile((SourceFile16)new SourceFile27(uUID).request());
    }

    public static SourceFile9 profileByUsername(String string) {
        return SourceFile9.fromPlayerProfile((SourceFile16)new SourceFile85(string).request());
    }

    public static SourceFile9[] profilesByUsername(String ... stringArray) {
        SourceFile16[] sourceFile16Array = (SourceFile16[])new SourceFile28(stringArray).request();
        SourceFile9[] sourceFile9Array = new SourceFile9[sourceFile16Array.length];
        for (int i = 0; i < sourceFile16Array.length; ++i) {
            sourceFile9Array[i] = SourceFile9.fromPlayerProfile(sourceFile16Array[i]);
        }
        return sourceFile9Array;
    }
}


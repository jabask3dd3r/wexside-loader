/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.yggdrasil;

import launcher.SourceFile15;
import launcher.SourceFile3;
import launcher.SourceFile30;
import launcher.SourceFile65;
import launcher.SourceFile67;
import launcher.SourceFile7;
import launcher.SourceFile72;

@SourceFile3
public class SourceFile4 {
    private SourceFile4() {
    }

    public static boolean checkServer(String string, String string2) {
        SourceFile30.debug("LegacyBridge.checkServer, Username: '%s', Server ID: %s", string, string2);
        return new SourceFile67(string, string2).request() != null;
    }

    public static String getCloakURL(String string) {
        SourceFile30.debug("LegacyBridge.getCloakURL: '%s'", string);
        return SourceFile15.replace(System.getProperty("launcher.legacy.cloaksURL", "http://skins.minecraft.net/MinecraftCloaks/%username%.png"), "username", SourceFile72.urlEncode(string));
    }

    public static String getSkinURL(String string) {
        SourceFile30.debug("LegacyBridge.getSkinURL: '%s'", string);
        return SourceFile15.replace(System.getProperty("launcher.legacy.skinsURL", "http://skins.minecraft.net/MinecraftSkins/%username%.png"), "username", SourceFile72.urlEncode(string));
    }

    public static String joinServer(String string, String string2, String string3) {
        if (!SourceFile7.isLaunched()) {
            return "Bad Login (Cheater)";
        }
        SourceFile30.debug("LegacyBridge.joinServer, Username: '%s', Access token: %s, Server ID: %s", string, string2, string3);
        try {
            return (Boolean)new SourceFile65(string, string2, string3).request() != false ? "OK" : "Bad Login (Clientside)";
        }
        catch (Throwable throwable) {
            return throwable.toString();
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Iterables
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 */
package com.mojang.authlib.yggdrasil;

import com.google.common.collect.Iterables;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.authlib.SourceFile;
import com.mojang.authlib.SourceFile10;
import com.mojang.authlib.SourceFile9;
import com.mojang.authlib.exceptions.SourceFile3;
import com.mojang.authlib.exceptions.SourceFile4;
import com.mojang.authlib.minecraft.SourceFile$Type;
import com.mojang.authlib.minecraft.SourceFile5;
import com.mojang.authlib.properties.SourceFile1;
import com.mojang.authlib.yggdrasil.SourceFile6;
import java.net.InetAddress;
import java.util.Base64;
import java.util.EnumMap;
import java.util.Map;
import java.util.UUID;
import launcher.SourceFile16;
import launcher.SourceFile27;
import launcher.SourceFile30;
import launcher.SourceFile54;
import launcher.SourceFile65;
import launcher.SourceFile67;
import launcher.SourceFile72;

public class SourceFile7
extends SourceFile5 {
    public static final JsonParser JSON_PARSER = new JsonParser();
    public static final boolean NO_TEXTURES = Boolean.parseBoolean("launcher.authlib.noTextures");

    public SourceFile7(SourceFile10 sourceFile10) {
        super(sourceFile10);
        SourceFile30.debug("Patched MinecraftSessionService created");
    }

    public SourceFile7(SourceFile6 sourceFile6) {
        super(sourceFile6);
        SourceFile30.debug("Patched MinecraftSessionService created");
    }

    public SourceFile7(SourceFile6 sourceFile6, SourceFile9 sourceFile9) {
        super(sourceFile6);
        SourceFile30.debug("Patched MinecraftSessionService created");
    }

    public SourceFile7(SourceFile10 sourceFile10, SourceFile9 sourceFile9) {
        super(sourceFile10);
        SourceFile30.debug("Patched MinecraftSessionService created");
    }

    public static void fillTextureProperties(SourceFile sourceFile, SourceFile16 sourceFile16) {
        SourceFile30.debug("fillTextureProperties, Username: '%s'", sourceFile.getName());
        if (NO_TEXTURES) {
            return;
        }
        com.mojang.authlib.properties.SourceFile sourceFile2 = sourceFile.getProperties();
        if (sourceFile16.skin != null) {
            sourceFile2.put("skinURL", new SourceFile1("skinURL", sourceFile16.skin.url, ""));
            sourceFile2.put("skinDigest", new SourceFile1("skinDigest", SourceFile54.toHex(sourceFile16.skin.digest), ""));
            SourceFile30.debug("fillTextureProperties, Has skin texture for username '%s'", sourceFile.getName());
        }
        if (sourceFile16.cloak != null) {
            sourceFile2.put("cloakURL", new SourceFile1("cloakURL", sourceFile16.cloak.url, ""));
            sourceFile2.put("cloakDigest", new SourceFile1("cloakDigest", SourceFile54.toHex(sourceFile16.cloak.digest), ""));
            SourceFile30.debug("fillTextureProperties, Has cloak texture for username '%s'", sourceFile.getName());
        }
    }

    public static SourceFile toGameProfile(SourceFile16 sourceFile16) {
        SourceFile sourceFile = new SourceFile(sourceFile16.uuid, sourceFile16.username);
        SourceFile7.fillTextureProperties(sourceFile, sourceFile16);
        return sourceFile;
    }

    private static void getTexturesMojang(Map map, String string, SourceFile sourceFile) {
        JsonObject jsonObject;
        Object object;
        Object object2;
        try {
            object2 = Base64.getDecoder().decode(string);
            object = new String((byte[])object2, SourceFile72.UNICODE_CHARSET);
            jsonObject = JSON_PARSER.parse(object).getAsJsonObject().getAsJsonObject("textures");
        }
        catch (Throwable throwable) {
            SourceFile30.error("Could not decode textures payload, Username: '%s', UUID: '%s'", sourceFile.getName(), sourceFile.getUUID());
            return;
        }
        object2 = com.mojang.authlib.minecraft.SourceFile.PROFILE_TEXTURE_TYPES.iterator();
        while (object2.hasNext()) {
            JsonElement jsonElement;
            JsonElement jsonElement2;
            object = (SourceFile$Type)((Object)object2.next());
            if (map.containsKey(object) || (jsonElement2 = jsonObject.get(((Enum)object).name())) == null || !jsonElement2.isJsonObject() || !(jsonElement = jsonElement2.getAsJsonObject().get("url")).isJsonPrimitive()) continue;
            map.put(object, new com.mojang.authlib.minecraft.SourceFile(jsonElement.getAsString()));
        }
    }

    @Override
    public SourceFile fillProfileProperties(SourceFile sourceFile, boolean bl) {
        SourceFile16 sourceFile16;
        UUID uUID = sourceFile.getUUID();
        SourceFile30.debug("fillProfileProperties, UUID: %s", uUID);
        if (uUID == null) {
            return sourceFile;
        }
        try {
            sourceFile16 = (SourceFile16)new SourceFile27(uUID).request();
        }
        catch (Throwable throwable) {
            SourceFile30.debug("Couldn't fetch profile properties for '%s': %s", sourceFile, throwable);
            return sourceFile;
        }
        if (sourceFile16 == null) {
            SourceFile30.debug("Couldn't fetch profile properties for '%s' as the profile does not exist", sourceFile);
            return sourceFile;
        }
        SourceFile30.debug("Successfully fetched profile properties for '%s'", sourceFile);
        SourceFile7.fillTextureProperties(sourceFile, sourceFile16);
        return SourceFile7.toGameProfile(sourceFile16);
    }

    @Override
    public Map getTextures(SourceFile sourceFile, boolean bl) {
        SourceFile30.debug("getTextures, Username: '%s', UUID: '%s'", sourceFile.getName(), sourceFile.getUUID());
        EnumMap<SourceFile$Type, com.mojang.authlib.minecraft.SourceFile> enumMap = new EnumMap<SourceFile$Type, com.mojang.authlib.minecraft.SourceFile>(SourceFile$Type.class);
        if (!NO_TEXTURES) {
            SourceFile1 sourceFile1;
            SourceFile1 sourceFile12 = (SourceFile1)Iterables.getFirst((Iterable)sourceFile.getProperties().get("skinURL"), null);
            SourceFile1 sourceFile13 = (SourceFile1)Iterables.getFirst((Iterable)sourceFile.getProperties().get("skinDigest"), null);
            if (sourceFile12 != null && sourceFile13 != null) {
                enumMap.put(SourceFile$Type.SKIN, new com.mojang.authlib.minecraft.SourceFile(sourceFile12.getValue(), sourceFile13.getValue()));
            }
            SourceFile1 sourceFile14 = (SourceFile1)Iterables.getFirst((Iterable)sourceFile.getProperties().get("cloakURL"), null);
            SourceFile1 sourceFile15 = (SourceFile1)Iterables.getFirst((Iterable)sourceFile.getProperties().get("cloakDigest"), null);
            if (sourceFile14 != null && sourceFile15 != null) {
                enumMap.put(SourceFile$Type.CAPE, new com.mojang.authlib.minecraft.SourceFile(sourceFile14.getValue(), sourceFile15.getValue()));
            }
            if (enumMap.size() != com.mojang.authlib.minecraft.SourceFile.PROFILE_TEXTURE_COUNT && (sourceFile1 = (SourceFile1)Iterables.getFirst((Iterable)sourceFile.getProperties().get("textures"), null)) != null) {
                SourceFile7.getTexturesMojang(enumMap, sourceFile1.getValue(), sourceFile);
            }
        }
        return enumMap;
    }

    @Override
    public SourceFile hasJoinedServer(SourceFile sourceFile, String string) {
        SourceFile16 sourceFile16;
        String string2 = sourceFile.getName();
        SourceFile30.debug("checkServer, Username: '%s', Server ID: %s", string2, string);
        try {
            sourceFile16 = (SourceFile16)new SourceFile67(string2, string).request();
        }
        catch (Throwable throwable) {
            SourceFile30.error(throwable);
            throw new SourceFile3(throwable);
        }
        return sourceFile16 == null ? null : SourceFile7.toGameProfile(sourceFile16);
    }

    @Override
    public SourceFile hasJoinedServer(SourceFile sourceFile, String string, InetAddress inetAddress) {
        return this.hasJoinedServer(sourceFile, string);
    }

    @Override
    public void joinServer(SourceFile sourceFile, String string, String string2) {
        boolean bl;
        if (!launcher.SourceFile7.isLaunched()) {
            throw new SourceFile4("Bad Login (Cheater)");
        }
        String string3 = sourceFile.getName();
        SourceFile30.debug("joinServer, Username: '%s', Access token: %s, Server ID: %s", string3, string, string2);
        try {
            bl = (Boolean)new SourceFile65(string3, string, string2).request();
        }
        catch (Throwable throwable) {
            throw new SourceFile3(throwable);
        }
        if (!bl) {
            throw new SourceFile4("Bad Login (Clientside)");
        }
    }
}


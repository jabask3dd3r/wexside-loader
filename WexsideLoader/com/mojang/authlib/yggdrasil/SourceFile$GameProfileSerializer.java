/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonDeserializationContext
 *  com.google.gson.JsonDeserializer
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonSerializationContext
 *  com.google.gson.JsonSerializer
 */
package com.mojang.authlib.yggdrasil;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mojang.authlib.SourceFile;
import com.mojang.authlib.yggdrasil.SourceFile$1;
import java.lang.reflect.Type;
import java.util.UUID;

class SourceFile$GameProfileSerializer
implements JsonDeserializer,
JsonSerializer {
    private SourceFile$GameProfileSerializer() {
    }

    public SourceFile deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        JsonObject jsonObject = (JsonObject)jsonElement;
        UUID uUID = jsonObject.has("id") ? (UUID)jsonDeserializationContext.deserialize(jsonObject.get("id"), UUID.class) : null;
        String string = jsonObject.has("name") ? jsonObject.getAsJsonPrimitive("name").getAsString() : null;
        return new SourceFile(uUID, string);
    }

    public JsonElement serialize(SourceFile sourceFile, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        if (sourceFile.getId() != null) {
            jsonObject.add("id", jsonSerializationContext.serialize((Object)sourceFile.getId()));
        }
        if (sourceFile.getName() != null) {
            jsonObject.addProperty("name", sourceFile.getName());
        }
        return jsonObject;
    }

    /* synthetic */ SourceFile$GameProfileSerializer(SourceFile$1 sourceFile$1) {
        this();
    }
}


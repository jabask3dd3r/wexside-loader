/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonDeserializationContext
 *  com.google.gson.JsonDeserializer
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 */
package com.mojang.authlib.yggdrasil.response;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.authlib.SourceFile;
import com.mojang.authlib.yggdrasil.response.SourceFile7;
import java.lang.reflect.Type;

public class SourceFile$Serializer
implements JsonDeserializer {
    public SourceFile7 deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        SourceFile7 sourceFile7 = new SourceFile7();
        if (jsonElement instanceof JsonObject) {
            JsonObject jsonObject = (JsonObject)jsonElement;
            if (jsonObject.has("error")) {
                sourceFile7.setError(jsonObject.getAsJsonPrimitive("error").getAsString());
            }
            if (jsonObject.has("errorMessage")) {
                sourceFile7.setError(jsonObject.getAsJsonPrimitive("errorMessage").getAsString());
            }
            if (jsonObject.has("cause")) {
                sourceFile7.setError(jsonObject.getAsJsonPrimitive("cause").getAsString());
            }
        } else {
            SourceFile7.access$002(sourceFile7, (SourceFile[])jsonDeserializationContext.deserialize(jsonElement, SourceFile[].class));
        }
        return sourceFile7;
    }
}


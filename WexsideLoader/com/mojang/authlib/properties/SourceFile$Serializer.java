/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonDeserializationContext
 *  com.google.gson.JsonDeserializer
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonSerializationContext
 *  com.google.gson.JsonSerializer
 */
package com.mojang.authlib.properties;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mojang.authlib.properties.SourceFile;
import com.mojang.authlib.properties.SourceFile1;
import java.lang.reflect.Type;
import java.util.Map;

public class SourceFile$Serializer
implements JsonDeserializer,
JsonSerializer {
    public SourceFile deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        SourceFile sourceFile;
        block5: {
            block4: {
                sourceFile = new SourceFile();
                if (!(jsonElement instanceof JsonObject)) break block4;
                JsonObject jsonObject = (JsonObject)jsonElement;
                for (Map.Entry entry : jsonObject.entrySet()) {
                    if (!(entry.getValue() instanceof JsonArray)) continue;
                    for (JsonElement jsonElement2 : (JsonArray)entry.getValue()) {
                        sourceFile.put(entry.getKey(), new SourceFile1((String)entry.getKey(), jsonElement2.getAsString()));
                    }
                }
                break block5;
            }
            if (!(jsonElement instanceof JsonArray)) break block5;
            for (JsonElement jsonElement3 : (JsonArray)jsonElement) {
                if (!(jsonElement3 instanceof JsonObject)) continue;
                JsonObject jsonObject = (JsonObject)jsonElement3;
                String string = jsonObject.getAsJsonPrimitive("name").getAsString();
                String string2 = jsonObject.getAsJsonPrimitive("value").getAsString();
                if (jsonObject.has("signature")) {
                    sourceFile.put(string, new SourceFile1(string, string2, jsonObject.getAsJsonPrimitive("signature").getAsString()));
                    continue;
                }
                sourceFile.put(string, new SourceFile1(string, string2));
            }
        }
        return sourceFile;
    }

    public JsonElement serialize(SourceFile sourceFile, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonArray jsonArray = new JsonArray();
        for (SourceFile1 sourceFile1 : sourceFile.values()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", sourceFile1.getName());
            jsonObject.addProperty("value", sourceFile1.getValue());
            if (sourceFile1.hasSignature()) {
                jsonObject.addProperty("signature", sourceFile1.getSignature());
            }
            jsonArray.add((JsonElement)jsonObject);
        }
        return jsonArray;
    }
}


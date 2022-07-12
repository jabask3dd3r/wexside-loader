/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.TypeAdapter
 *  com.google.gson.stream.JsonReader
 *  com.google.gson.stream.JsonWriter
 */
package com.mojang.util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.UUID;

public class SourceFile
extends TypeAdapter {
    public void write(JsonWriter jsonWriter, UUID uUID) {
        jsonWriter.value(SourceFile.fromUUID(uUID));
    }

    public UUID read(JsonReader jsonReader) {
        return SourceFile.fromString(jsonReader.nextString());
    }

    public static String fromUUID(UUID uUID) {
        return uUID.toString().replace("-", "");
    }

    public static UUID fromString(String string) {
        return UUID.fromString(string.replaceFirst("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5"));
    }
}


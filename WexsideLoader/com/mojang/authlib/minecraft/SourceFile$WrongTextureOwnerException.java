/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.minecraft;

import com.mojang.authlib.SourceFile;
import com.mojang.authlib.minecraft.SourceFile2;
import java.util.UUID;

public class SourceFile$WrongTextureOwnerException
extends SourceFile2 {
    private final SourceFile expected;
    private final UUID resultId;
    private final String resultName;

    public SourceFile$WrongTextureOwnerException(SourceFile sourceFile, UUID uUID, String string) {
        super("Decrypted textures payload was for another user (expected " + sourceFile.getId() + "/" + sourceFile.getName() + " but was for " + uUID + "/" + string + ")");
        this.expected = sourceFile;
        this.resultId = uUID;
        this.resultName = string;
    }
}


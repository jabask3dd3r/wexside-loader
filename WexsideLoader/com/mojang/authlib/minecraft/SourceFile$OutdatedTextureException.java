/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.minecraft;

import com.mojang.authlib.minecraft.SourceFile2;
import java.util.Calendar;
import java.util.Date;

public class SourceFile$OutdatedTextureException
extends SourceFile2 {
    private final Date validFrom;
    private final Calendar limit;

    public SourceFile$OutdatedTextureException(Date date, Calendar calendar) {
        super("Decrypted textures payload is too old (" + date + ", but we need it to be at least " + calendar + ")");
        this.validFrom = date;
        this.limit = calendar;
    }
}


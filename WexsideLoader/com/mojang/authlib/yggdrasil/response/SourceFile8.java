/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.yggdrasil.response;

import com.mojang.authlib.yggdrasil.response.SourceFile$Privileges;
import com.mojang.authlib.yggdrasil.response.SourceFile5;

public class SourceFile8
extends SourceFile5 {
    private SourceFile$Privileges privileges = new SourceFile$Privileges(this);

    public SourceFile$Privileges getPrivileges() {
        return this.privileges;
    }
}


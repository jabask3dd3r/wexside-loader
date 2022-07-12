/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.yggdrasil.response;

import com.mojang.authlib.yggdrasil.response.SourceFile$Privileges$Privilege;
import com.mojang.authlib.yggdrasil.response.SourceFile8;

public class SourceFile$Privileges {
    private SourceFile$Privileges$Privilege onlineChat = new SourceFile$Privileges$Privilege(this);
    private SourceFile$Privileges$Privilege multiplayerServer = new SourceFile$Privileges$Privilege(this);
    private SourceFile$Privileges$Privilege multiplayerRealms = new SourceFile$Privileges$Privilege(this);
    final /* synthetic */ SourceFile8 this$0;

    public SourceFile$Privileges(SourceFile8 sourceFile8) {
        this.this$0 = sourceFile8;
    }

    public SourceFile$Privileges$Privilege getOnlineChat() {
        return this.onlineChat;
    }

    public SourceFile$Privileges$Privilege getMultiplayerServer() {
        return this.multiplayerServer;
    }

    public SourceFile$Privileges$Privilege getMultiplayerRealms() {
        return this.multiplayerRealms;
    }
}


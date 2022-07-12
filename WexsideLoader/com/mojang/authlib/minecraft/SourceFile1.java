/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.minecraft;

import com.mojang.authlib.SourceFile;
import java.net.InetAddress;
import java.util.Map;

public interface SourceFile1 {
    public void joinServer(SourceFile var1, String var2, String var3);

    public SourceFile hasJoinedServer(SourceFile var1, String var2);

    public SourceFile hasJoinedServer(SourceFile var1, String var2, InetAddress var3);

    public Map getTextures(SourceFile var1, boolean var2);

    public SourceFile fillProfileProperties(SourceFile var1, boolean var2);
}


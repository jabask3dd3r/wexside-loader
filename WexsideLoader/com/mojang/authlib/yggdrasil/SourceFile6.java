/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.yggdrasil;

import com.mojang.authlib.SourceFile10;
import com.mojang.authlib.SourceFile11;
import com.mojang.authlib.SourceFile3;
import com.mojang.authlib.SourceFile5;
import com.mojang.authlib.SourceFile9;
import com.mojang.authlib.minecraft.SourceFile1;
import com.mojang.authlib.yggdrasil.SourceFile2;
import com.mojang.authlib.yggdrasil.SourceFile7;
import com.mojang.authlib.yggdrasil.SourceFile8;
import java.net.Proxy;
import launcher.SourceFile30;

public class SourceFile6
implements SourceFile10 {
    private final SourceFile9 environment;

    public SourceFile6(Proxy proxy) {
        this(proxy, SourceFile6.determineEnvironment());
    }

    public SourceFile6(Proxy proxy, SourceFile9 sourceFile9) {
        this(proxy, null, sourceFile9);
    }

    public SourceFile6(Proxy proxy, String string) {
        this(proxy, string, SourceFile6.determineEnvironment());
    }

    public SourceFile6(Proxy proxy, String string, SourceFile9 sourceFile9) {
        this.environment = sourceFile9;
        SourceFile30.debug("Patched AuthenticationService created: '%s'", string);
    }

    private static SourceFile9 determineEnvironment() {
        return SourceFile5.getEnvironmentFromProperties().orElse(SourceFile2.PROD);
    }

    @Override
    public SourceFile11 createUserAuthentication(com.mojang.authlib.SourceFile6 sourceFile6) {
        throw new UnsupportedOperationException("createUserAuthentication is used only by Mojang Launcher");
    }

    @Override
    public SourceFile1 createMinecraftSessionService() {
        return new SourceFile7((SourceFile10)this, this.environment);
    }

    @Override
    public SourceFile3 createProfileRepository() {
        return new com.mojang.authlib.yggdrasil.SourceFile5(this, this.environment);
    }

    public SourceFile8 createSocialInteractionsService(String string) {
        return new SourceFile8(this, string, this.environment);
    }
}


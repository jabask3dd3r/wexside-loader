/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.mojang.authlib.yggdrasil;

import com.mojang.authlib.SourceFile9;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Stream;
import javax.annotation.Nullable;

public enum SourceFile2 implements SourceFile9
{
    PROD("https://authserver.mojang.com", "https://api.mojang.com", "https://sessionserver.mojang.com", "https://api.minecraftservices.com"),
    STAGING("https://yggdrasil-auth-staging.mojang.com", "https://api-staging.mojang.com", "https://yggdrasil-auth-session-staging.mojang.zone", "https://api-staging.minecraftservices.com");

    private final String authHost;
    private final String accountsHost;
    private final String sessionHost;
    private final String servicesHost;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SourceFile2(String string3, String string4) {
        void var6_4;
        void var5_3;
        this.authHost = string3;
        this.accountsHost = string4;
        this.sessionHost = var5_3;
        this.servicesHost = var6_4;
    }

    @Override
    public String getAuthHost() {
        return this.authHost;
    }

    @Override
    public String getAccountsHost() {
        return this.accountsHost;
    }

    @Override
    public String getSessionHost() {
        return this.sessionHost;
    }

    @Override
    public String getServicesHost() {
        return this.servicesHost;
    }

    @Override
    public String getName() {
        return this.name();
    }

    @Override
    public String asString() {
        return new StringJoiner(", ", "", "").add("authHost='" + this.authHost + "'").add("accountsHost='" + this.accountsHost + "'").add("sessionHost='" + this.sessionHost + "'").add("servicesHost='" + this.servicesHost + "'").add("name='" + this.getName() + "'").toString();
    }

    public static Optional fromString(@Nullable String string) {
        return Stream.of(SourceFile2.values()).filter(sourceFile2 -> string != null && string.equalsIgnoreCase(sourceFile2.name())).findFirst();
    }
}


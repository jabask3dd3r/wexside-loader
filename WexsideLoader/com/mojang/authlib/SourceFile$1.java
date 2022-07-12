/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib;

import com.mojang.authlib.SourceFile9;
import java.util.StringJoiner;

final class SourceFile$1
implements SourceFile9 {
    final /* synthetic */ String val$auth;
    final /* synthetic */ String val$account;
    final /* synthetic */ String val$session;
    final /* synthetic */ String val$services;
    final /* synthetic */ String val$name;

    SourceFile$1(String string, String string2, String string3, String string4, String string5) {
        this.val$auth = string;
        this.val$account = string2;
        this.val$session = string3;
        this.val$services = string4;
        this.val$name = string5;
    }

    @Override
    public String getAuthHost() {
        return this.val$auth;
    }

    @Override
    public String getAccountsHost() {
        return this.val$account;
    }

    @Override
    public String getSessionHost() {
        return this.val$session;
    }

    @Override
    public String getServicesHost() {
        return this.val$services;
    }

    @Override
    public String getName() {
        return this.val$name;
    }

    @Override
    public String asString() {
        return new StringJoiner(", ", "", "").add("authHost='" + this.getAuthHost() + "'").add("accountsHost='" + this.getAccountsHost() + "'").add("sessionHost='" + this.getSessionHost() + "'").add("servicesHost='" + this.getServicesHost() + "'").add("name='" + this.getName() + "'").toString();
    }
}


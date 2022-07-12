/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib;

import com.mojang.authlib.SourceFile$1;

public interface SourceFile9 {
    public String getAuthHost();

    public String getAccountsHost();

    public String getSessionHost();

    public String getServicesHost();

    public String getName();

    public String asString();

    public static SourceFile9 create(String string, String string2, String string3, String string4, String string5) {
        return new SourceFile$1(string, string2, string3, string4, string5);
    }
}


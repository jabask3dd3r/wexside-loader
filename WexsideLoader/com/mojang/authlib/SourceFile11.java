/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib;

import com.mojang.authlib.SourceFile4;
import com.mojang.authlib.properties.SourceFile;
import java.util.Map;

public interface SourceFile11 {
    public boolean canLogIn();

    public void logIn();

    public void logOut();

    public boolean isLoggedIn();

    public boolean canPlayOnline();

    public com.mojang.authlib.SourceFile[] getAvailableProfiles();

    public com.mojang.authlib.SourceFile getSelectedProfile();

    public void selectGameProfile(com.mojang.authlib.SourceFile var1);

    public void loadFromStorage(Map var1);

    public Map saveForStorage();

    public void setUsername(String var1);

    public void setPassword(String var1);

    public String getAuthenticatedToken();

    public String getUserID();

    public SourceFile getUserProperties();

    public SourceFile4 getUserType();
}


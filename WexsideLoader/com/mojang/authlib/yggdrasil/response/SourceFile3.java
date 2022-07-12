/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.yggdrasil.response;

import com.mojang.authlib.SourceFile;
import com.mojang.authlib.yggdrasil.response.SourceFile5;
import com.mojang.authlib.yggdrasil.response.SourceFile9;

public class SourceFile3
extends SourceFile5 {
    private String accessToken;
    private String clientToken;
    private SourceFile selectedProfile;
    private SourceFile[] availableProfiles;
    private SourceFile9 user;

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getClientToken() {
        return this.clientToken;
    }

    public SourceFile[] getAvailableProfiles() {
        return this.availableProfiles;
    }

    public SourceFile getSelectedProfile() {
        return this.selectedProfile;
    }

    public SourceFile9 getUser() {
        return this.user;
    }
}


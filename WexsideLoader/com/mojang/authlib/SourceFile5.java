/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package com.mojang.authlib;

import com.mojang.authlib.SourceFile9;
import com.mojang.authlib.yggdrasil.SourceFile2;
import java.util.Arrays;
import java.util.Optional;
import javax.annotation.Nullable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SourceFile5 {
    @Nullable
    private static String environmentOverride;
    private static final String PROP_PREFIX = "minecraft.api.";
    private static final Logger LOGGER;
    public static final String PROP_ENV = "minecraft.api.env";
    public static final String PROP_AUTH_HOST = "minecraft.api.auth.host";
    public static final String PROP_ACCOUNT_HOST = "minecraft.api.account.host";
    public static final String PROP_SESSION_HOST = "minecraft.api.session.host";
    public static final String PROP_SERVICES_HOST = "minecraft.api.services.host";

    public static void setEnvironmentOverride(String string) {
        environmentOverride = string;
    }

    public static Optional getEnvironmentFromProperties() {
        String string = environmentOverride != null ? environmentOverride : System.getProperty(PROP_ENV);
        Optional optional = SourceFile2.fromString(string).map(SourceFile9.class::cast);
        return optional.isPresent() ? optional : SourceFile5.fromHostNames();
    }

    private static Optional fromHostNames() {
        String string = System.getProperty(PROP_AUTH_HOST);
        String string2 = System.getProperty(PROP_ACCOUNT_HOST);
        String string3 = System.getProperty(PROP_SESSION_HOST);
        String string4 = System.getProperty(PROP_SERVICES_HOST);
        if (string != null && string2 != null && string3 != null) {
            return Optional.of(SourceFile9.create(string, string2, string3, string4, "properties"));
        }
        if (string != null || string2 != null || string3 != null) {
            LOGGER.info("Ignoring hosts properties. All need to be set: " + Arrays.asList(PROP_AUTH_HOST, PROP_ACCOUNT_HOST, PROP_SESSION_HOST));
        }
        return Optional.empty();
    }

    static {
        LOGGER = LogManager.getLogger();
    }
}


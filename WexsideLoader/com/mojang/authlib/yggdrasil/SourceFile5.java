/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.yggdrasil;

import com.mojang.authlib.SourceFile;
import com.mojang.authlib.SourceFile1;
import com.mojang.authlib.SourceFile3;
import com.mojang.authlib.SourceFile6;
import com.mojang.authlib.SourceFile9;
import com.mojang.authlib.yggdrasil.SourceFile7;
import java.util.Arrays;
import java.util.UUID;
import launcher.SourceFile16;
import launcher.SourceFile28;
import launcher.SourceFile30;
import launcher.SourceFile75;

public class SourceFile5
implements SourceFile3 {
    private static final long BUSY_WAIT_MS = SourceFile75.verifyLong(Long.parseLong(System.getProperty("launcher.com.mojang.authlib.busyWait", Long.toString(100L))), SourceFile75.L_NOT_NEGATIVE, "launcher.com.mojang.authlib.busyWait can't be < 0");
    private static final long ERROR_BUSY_WAIT_MS = SourceFile75.verifyLong(Long.parseLong(System.getProperty("launcher.com.mojang.authlib.errorBusyWait", Long.toString(500L))), SourceFile75.L_NOT_NEGATIVE, "launcher.com.mojang.authlib.errorBusyWait can't be < 0");

    public SourceFile5(com.mojang.authlib.yggdrasil.SourceFile6 sourceFile6, SourceFile9 sourceFile9) {
        SourceFile30.debug("Patched GameProfileRepository created");
    }

    private static void busyWait(long l) {
        try {
            Thread.sleep(l);
        }
        catch (InterruptedException interruptedException) {
            SourceFile30.error(interruptedException);
        }
    }

    @Override
    public void findProfilesByNames(String[] stringArray, SourceFile6 sourceFile6, SourceFile1 sourceFile1) {
        int n = 0;
        while (n < stringArray.length) {
            SourceFile16[] sourceFile16Array;
            String[] stringArray2 = Arrays.copyOfRange(stringArray, n, Math.min(n + 128, stringArray.length));
            n += 128;
            try {
                sourceFile16Array = (SourceFile16[])new SourceFile28(stringArray2).request();
            }
            catch (Throwable throwable) {
                for (String string : stringArray2) {
                    SourceFile30.debug("Couldn't find profile '%s': %s", string, throwable);
                    sourceFile1.onProfileLookupFailed(new SourceFile((UUID)null, string), throwable instanceof Exception ? (Exception)throwable : new Exception(throwable));
                }
                SourceFile5.busyWait(ERROR_BUSY_WAIT_MS);
                continue;
            }
            for (int i = 0; i < sourceFile16Array.length; ++i) {
                SourceFile16 sourceFile16 = sourceFile16Array[i];
                if (sourceFile16 == null) {
                    String string = stringArray2[i];
                    SourceFile30.debug("Couldn't find profile '%s'", string);
                    sourceFile1.onProfileLookupFailed(new SourceFile((UUID)null, string), new com.mojang.authlib.yggdrasil.SourceFile("Server did not find the requested profile"));
                    continue;
                }
                SourceFile30.debug("Successfully looked up profile '%s'", sourceFile16.username);
                sourceFile1.onProfileLookupSucceeded(SourceFile7.toGameProfile(sourceFile16));
            }
            SourceFile5.busyWait(BUSY_WAIT_MS);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jdk.nashorn.api.scripting.NashornScriptEngineFactory
 */
package launcher;

import java.util.Locale;
import javax.script.ScriptEngine;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import launcher.SourceFile3;

public final class SourceFile15 {
    private static final String[] keepErJErRy6HE = new String[]{"-strict", "--language=es6", "--optimistic-types=false"};

    private SourceFile15() {
    }

    @SourceFile3
    public static String low(String string) {
        return string.toLowerCase(Locale.US);
    }

    @SourceFile3
    public static ScriptEngine newScriptEngine() {
        return new NashornScriptEngineFactory().getScriptEngine(keepErJErRy6HE);
    }

    @SourceFile3
    public static Thread newThread(String string, boolean bl, Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(bl);
        if (string != null) {
            thread.setName(string);
        }
        return thread;
    }

    @SourceFile3
    public static String replace(String string, String ... stringArray) {
        for (int i = 0; i < stringArray.length; i += 2) {
            string = string.replace('%' + stringArray[i] + '%', stringArray[i + 1]);
        }
        return string;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javafx.application.Application
 */
package launcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.NoSuchFileException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javafx.application.Application;
import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import launcher.SourceFile12;
import launcher.SourceFile13;
import launcher.SourceFile14;
import launcher.SourceFile15;
import launcher.SourceFile16;
import launcher.SourceFile18;
import launcher.SourceFile19;
import launcher.SourceFile2;
import launcher.SourceFile21;
import launcher.SourceFile24;
import launcher.SourceFile27;
import launcher.SourceFile28;
import launcher.SourceFile29;
import launcher.SourceFile3;
import launcher.SourceFile30;
import launcher.SourceFile32;
import launcher.SourceFile34;
import launcher.SourceFile37;
import launcher.SourceFile38;
import launcher.SourceFile39;
import launcher.SourceFile4;
import launcher.SourceFile40;
import launcher.SourceFile41;
import launcher.SourceFile43;
import launcher.SourceFile45;
import launcher.SourceFile49;
import launcher.SourceFile5;
import launcher.SourceFile50;
import launcher.SourceFile51;
import launcher.SourceFile52;
import launcher.SourceFile54;
import launcher.SourceFile55;
import launcher.SourceFile56;
import launcher.SourceFile58;
import launcher.SourceFile61;
import launcher.SourceFile63;
import launcher.SourceFile64;
import launcher.SourceFile65;
import launcher.SourceFile67;
import launcher.SourceFile68;
import launcher.SourceFile7;
import launcher.SourceFile70;
import launcher.SourceFile72;
import launcher.SourceFile74;
import launcher.SourceFile75;
import launcher.SourceFile76;
import launcher.SourceFile77;
import launcher.SourceFile8;
import launcher.SourceFile80;
import launcher.SourceFile81;
import launcher.SourceFile82;
import launcher.SourceFile83;
import launcher.SourceFile85;
import launcher.wendoxd.utils.SourceFile;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class SourceFile71 {
    @SourceFile3
    public static final String VERSION = "1.7.4.2";
    @SourceFile3
    public static final String BUILD = SourceFile71.keepErJErRy6HE();
    @SourceFile3
    public static final int PROTOCOL_MAGIC = 1917264919;
    @SourceFile3
    public static final String RUNTIME_DIR = "runtime";
    @SourceFile3
    public static final String CONFIG_FILE = "config.bin";
    @SourceFile3
    public static final String INIT_SCRIPT_FILE = "init.js";
    private static final AtomicReference keepErJErRy6HE = new AtomicReference();
    private final AtomicBoolean keepErJErRy6HE;
    private final ScriptEngine keepErJErRy6HE = SourceFile15.newScriptEngine();

    private SourceFile71() {
        this.keepErJErRy6HE();
    }

    @SourceFile3
    public static void addLauncherClassBindings(ScriptEngine scriptEngine, Map map) {
        SourceFile71.addClassBinding(scriptEngine, map, "Launcher", SourceFile71.class);
        SourceFile71.addClassBinding(scriptEngine, map, "Config", SourceFile2.class);
        SourceFile71.addClassBinding(scriptEngine, map, "Draggable", SourceFile.class);
        SourceFile71.addClassBinding(scriptEngine, map, "PlayerProfile", SourceFile16.class);
        SourceFile71.addClassBinding(scriptEngine, map, "PlayerProfileTexture", SourceFile41.class);
        SourceFile71.addClassBinding(scriptEngine, map, "ClientProfile", SourceFile8.class);
        SourceFile71.addClassBinding(scriptEngine, map, "ClientProfileVersion", SourceFile77.class);
        SourceFile71.addClassBinding(scriptEngine, map, "ClientLauncher", SourceFile7.class);
        SourceFile71.addClassBinding(scriptEngine, map, "ClientLauncherParams", SourceFile29.class);
        SourceFile71.addClassBinding(scriptEngine, map, "ServerPinger", SourceFile21.class);
        SourceFile71.addClassBinding(scriptEngine, map, "Request", SourceFile51.class);
        SourceFile71.addClassBinding(scriptEngine, map, "RequestType", SourceFile56.class);
        SourceFile71.addClassBinding(scriptEngine, map, "RequestException", SourceFile24.class);
        SourceFile71.addClassBinding(scriptEngine, map, "CustomRequest", SourceFile52.class);
        SourceFile71.addClassBinding(scriptEngine, map, "PingRequest", SourceFile4.class);
        SourceFile71.addClassBinding(scriptEngine, map, "AuthRequest", SourceFile76.class);
        SourceFile71.addClassBinding(scriptEngine, map, "JoinServerRequest", SourceFile65.class);
        SourceFile71.addClassBinding(scriptEngine, map, "CheckServerRequest", SourceFile67.class);
        SourceFile71.addClassBinding(scriptEngine, map, "UpdateRequest", SourceFile14.class);
        SourceFile71.addClassBinding(scriptEngine, map, "LauncherRequest", SourceFile74.class);
        SourceFile71.addClassBinding(scriptEngine, map, "ProfileByUsernameRequest", SourceFile85.class);
        SourceFile71.addClassBinding(scriptEngine, map, "ProfileByUUIDRequest", SourceFile27.class);
        SourceFile71.addClassBinding(scriptEngine, map, "BatchProfileByUsernameRequest", SourceFile28.class);
        SourceFile71.addClassBinding(scriptEngine, map, "FileNameMatcher", SourceFile49.class);
        SourceFile71.addClassBinding(scriptEngine, map, "HashedDir", SourceFile18.class);
        SourceFile71.addClassBinding(scriptEngine, map, "HashedFile", SourceFile43.class);
        SourceFile71.addClassBinding(scriptEngine, map, "HashedEntryType", SourceFile58.class);
        SourceFile71.addClassBinding(scriptEngine, map, "HInput", SourceFile5.class);
        SourceFile71.addClassBinding(scriptEngine, map, "HOutput", SourceFile61.class);
        SourceFile71.addClassBinding(scriptEngine, map, "StreamObject", SourceFile19.class);
        SourceFile71.addClassBinding(scriptEngine, map, "StreamObjectAdapter", SourceFile34.class);
        SourceFile71.addClassBinding(scriptEngine, map, "SignedBytesHolder", SourceFile70.class);
        SourceFile71.addClassBinding(scriptEngine, map, "SignedObjectHolder", SourceFile39.class);
        SourceFile71.addClassBinding(scriptEngine, map, "EnumSerializer", SourceFile12.class);
        SourceFile71.addClassBinding(scriptEngine, map, "ConfigObject", SourceFile64.class);
        SourceFile71.addClassBinding(scriptEngine, map, "ConfigObjectAdapter", SourceFile32.class);
        SourceFile71.addClassBinding(scriptEngine, map, "BlockConfigEntry", SourceFile83.class);
        SourceFile71.addClassBinding(scriptEngine, map, "BooleanConfigEntry", SourceFile37.class);
        SourceFile71.addClassBinding(scriptEngine, map, "IntegerConfigEntry", SourceFile82.class);
        SourceFile71.addClassBinding(scriptEngine, map, "ListConfigEntry", SourceFile50.class);
        SourceFile71.addClassBinding(scriptEngine, map, "StringConfigEntry", SourceFile80.class);
        SourceFile71.addClassBinding(scriptEngine, map, "ConfigEntryType", SourceFile45.class);
        SourceFile71.addClassBinding(scriptEngine, map, "TextConfigReader", SourceFile38.class);
        SourceFile71.addClassBinding(scriptEngine, map, "TextConfigWriter", SourceFile68.class);
        SourceFile71.addClassBinding(scriptEngine, map, "CommonHelper", SourceFile15.class);
        SourceFile71.addClassBinding(scriptEngine, map, "IOHelper", SourceFile72.class);
        SourceFile71.addClassBinding(scriptEngine, map, "JVMHelper", SourceFile81.class);
        SourceFile71.addClassBinding(scriptEngine, map, "JVMHelperOS", SourceFile13.class);
        SourceFile71.addClassBinding(scriptEngine, map, "LogHelper", SourceFile30.class);
        SourceFile71.addClassBinding(scriptEngine, map, "LogHelperOutput", SourceFile40.class);
        SourceFile71.addClassBinding(scriptEngine, map, "SecurityHelper", SourceFile54.class);
        SourceFile71.addClassBinding(scriptEngine, map, "DigestAlgorithm", SourceFile63.class);
        SourceFile71.addClassBinding(scriptEngine, map, "VerifyHelper", SourceFile75.class);
        try {
            SourceFile71.addClassBinding(scriptEngine, map, "Application", Application.class);
            SourceFile71.addClassBinding(scriptEngine, map, "JSApplication", SourceFile55.class);
        }
        catch (Throwable throwable) {
            SourceFile30.error("JavaFX API isn't available");
        }
    }

    @SourceFile3
    public static void addClassBinding(ScriptEngine scriptEngine, Map map, String string, Class clazz) {
        map.put(string + "Class", clazz);
        try {
            scriptEngine.eval("var " + string + " = " + string + "Class.static;");
        }
        catch (ScriptException scriptException) {
            throw new AssertionError((Object)scriptException);
        }
    }

    @SourceFile3
    public static SourceFile2 getConfig() {
        SourceFile2 sourceFile2 = (SourceFile2)keepErJErRy6HE.get();
        if (sourceFile2 == null) {
            try (SourceFile5 sourceFile5 = new SourceFile5(SourceFile72.newInput(SourceFile72.getResourceURL(CONFIG_FILE)));){
                sourceFile2 = new SourceFile2(sourceFile5);
            }
            catch (IOException | InvalidKeySpecException exception) {
                throw new SecurityException(exception);
            }
            keepErJErRy6HE.set(sourceFile2);
        }
        return sourceFile2;
    }

    @SourceFile3
    public static URL getResourceURL(String string) {
        SourceFile2 sourceFile2 = SourceFile71.getConfig();
        byte[] byArray = (byte[])sourceFile2.runtime.get(string);
        if (byArray == null) {
            throw new NoSuchFileException(string);
        }
        URL uRL = SourceFile72.getResourceURL("runtime/" + string);
        if (!Arrays.equals(byArray, SourceFile54.digest(SourceFile63.MD5, uRL))) {
            throw new NoSuchFileException(string);
        }
        return uRL;
    }

    @SourceFile3
    public static String getVersion() {
        return VERSION;
    }

    public static void main(String ... stringArray) {
        SourceFile54.verifyCertificates(SourceFile71.class);
        SourceFile81.verifySystemProperties(SourceFile71.class, true);
        SourceFile30.printVersion("Launcher");
        try {
            new SourceFile71().start(stringArray);
        }
        catch (Throwable throwable) {
            SourceFile30.error(throwable);
            return;
        }
    }

    private static String keepErJErRy6HE() {
        try {
            return SourceFile72.request(SourceFile72.getResourceURL("buildnumber"));
        }
        catch (IOException iOException) {
            return "dev";
        }
    }

    @SourceFile3
    public Object loadScript(URL uRL) {
        SourceFile30.debug("Loading script: '%s'", uRL);
        try (BufferedReader bufferedReader = SourceFile72.newReader(uRL);){
            Object object = this.keepErJErRy6HE.eval(bufferedReader);
            return object;
        }
    }

    @SourceFile3
    public void start(String ... stringArray) {
        Objects.requireNonNull(stringArray, "args");
        if (this.keepErJErRy6HE.getAndSet(true)) {
            throw new IllegalStateException("Launcher has been already started");
        }
        this.loadScript(SourceFile71.getResourceURL(INIT_SCRIPT_FILE));
        SourceFile30.info("Invoking start() function");
        ((Invocable)((Object)this.keepErJErRy6HE)).invokeFunction("start", new Object[]{stringArray});
    }

    private void keepErJErRy6HE() {
        SourceFile30.info("Setting up script engine bindings");
        Bindings bindings = this.keepErJErRy6HE.getBindings(100);
        bindings.put("launcher", (Object)this);
        SourceFile71.addLauncherClassBindings(this.keepErJErRy6HE, bindings);
    }
}


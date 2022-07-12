/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import com.eclipsesource.json.SourceFile4;
import java.io.Serializable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.security.interfaces.RSAPublicKey;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import launcher.SourceFile13;
import launcher.SourceFile15;
import launcher.SourceFile16;
import launcher.SourceFile18;
import launcher.SourceFile2;
import launcher.SourceFile20;
import launcher.SourceFile22;
import launcher.SourceFile29;
import launcher.SourceFile3;
import launcher.SourceFile30;
import launcher.SourceFile39;
import launcher.SourceFile49;
import launcher.SourceFile5;
import launcher.SourceFile54;
import launcher.SourceFile61;
import launcher.SourceFile71;
import launcher.SourceFile72;
import launcher.SourceFile74;
import launcher.SourceFile75;
import launcher.SourceFile77;
import launcher.SourceFile8;
import launcher.SourceFile81;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class SourceFile7 {
    @SourceFile3
    public static final String SKIN_URL_PROPERTY = "skinURL";
    @SourceFile3
    public static final String SKIN_DIGEST_PROPERTY = "skinDigest";
    @SourceFile3
    public static final String CLOAK_URL_PROPERTY = "cloakURL";
    @SourceFile3
    public static final String CLOAK_DIGEST_PROPERTY = "cloakDigest";
    private static final String[] keepErJErRy6HE = new String[0];
    private static final String keepErJErRy6HE = "-XX:HeapDumpPath=ThisTricksIntelDriversForPerformance_javaw.exe_minecraft.exe.heapdump";
    private static final Set keepErJErRy6HE;
    private static final Path keepErJErRy6HE;
    private static final Path KeePerjeRryt52;
    private static final Pattern keepErJErRy6HE;
    private static final AtomicBoolean keepErJErRy6HE;

    private SourceFile7() {
    }

    @SourceFile3
    public static boolean isLaunched() {
        return keepErJErRy6HE.get();
    }

    public static String keepErJErRy6HE(String string, String string2) {
        return String.format("-D%s=%s", string, string2);
    }

    @SourceFile3
    public static Process launch(Path path, SourceFile39 sourceFile39, SourceFile39 sourceFile392, SourceFile39 sourceFile393, SourceFile39 sourceFile394, SourceFile29 sourceFile29, boolean bl) {
        SourceFile30.debug("Writing ClientLauncher params file");
        Path path2 = Files.createTempFile("ClientLauncherParams", ".bin", new FileAttribute[0]);
        Object object = new SourceFile61(SourceFile72.newOutput(path2));
        Serializable serializable = null;
        try {
            sourceFile29.write((SourceFile61)object);
            sourceFile394.write((SourceFile61)object);
            sourceFile39.write((SourceFile61)object);
            sourceFile392.write((SourceFile61)object);
            sourceFile393.write((SourceFile61)object);
        }
        catch (Throwable throwable) {
            serializable = throwable;
            throw throwable;
        }
        finally {
            if (object != null) {
                if (serializable != null) {
                    try {
                        ((SourceFile61)object).close();
                    }
                    catch (Throwable throwable) {
                        ((Throwable)serializable).addSuppressed(throwable);
                    }
                } else {
                    ((SourceFile61)object).close();
                }
            }
        }
        SourceFile30.debug("Resolving JVM binary");
        object = SourceFile72.resolveJavaBin(path);
        if (SourceFile72.POSIX) {
            Files.setPosixFilePermissions((Path)object, keepErJErRy6HE);
        }
        serializable = new LinkedList();
        serializable.add(object.toString());
        serializable.add(keepErJErRy6HE);
        if (sourceFile29.ram > 0 && sourceFile29.ram <= SourceFile81.RAM) {
            serializable.add("-Xms" + sourceFile29.ram + 'M');
            serializable.add("-Xmx" + sourceFile29.ram + 'M');
        }
        serializable.add(SourceFile7.keepErJErRy6HE("launcher.debug", Boolean.toString(SourceFile30.isDebugEnabled())));
        if (SourceFile2.ADDRESS_OVERRIDE != null) {
            serializable.add(SourceFile7.keepErJErRy6HE("launcher.addressOverride", SourceFile2.ADDRESS_OVERRIDE));
        }
        if (SourceFile81.OS_TYPE == SourceFile13.MUSTDIE && SourceFile81.OS_VERSION.startsWith("10.")) {
            SourceFile30.debug("MustDie 10 fix is applied");
            serializable.add(SourceFile7.keepErJErRy6HE("os.name", "Windows 10"));
            serializable.add(SourceFile7.keepErJErRy6HE("os.version", "10.0"));
        }
        Collections.addAll(serializable, ((SourceFile8)sourceFile394.object).getJvmArgs());
        String string = ((SourceFile8)sourceFile394.object).getVersion();
        if (SourceFile77.keepErJErRy6HE(string, "1.13") >= 0 && SourceFile81.OS_TYPE == SourceFile13.MACOSX) {
            Collections.addAll(serializable, new String[]{"-XstartOnFirstThread"});
        }
        Collections.addAll(serializable, new String[]{"-classpath", SourceFile72.getCodeSource(SourceFile7.class).toString(), SourceFile7.class.getName()});
        serializable.add(path2.toString());
        SourceFile30.debug("Commandline: " + serializable);
        SourceFile30.debug("Launching client instance");
        ProcessBuilder processBuilder = new ProcessBuilder((List<String>)((Object)serializable));
        processBuilder.directory(sourceFile29.clientDir.toFile());
        processBuilder.inheritIO();
        Map<String, String> map = processBuilder.environment();
        map.put("_JAVA_OPTS", "");
        map.put("_JAVA_OPTIONS", "");
        map.put("JAVA_OPTS", "");
        map.put("JAVA_OPTIONS", "");
        if (bl) {
            processBuilder.redirectErrorStream(true);
            processBuilder.redirectOutput(ProcessBuilder.Redirect.PIPE);
        }
        return processBuilder.start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @SourceFile3
    public static void main(String ... stringArray) {
        Object object;
        SourceFile39 sourceFile39;
        SourceFile39 sourceFile392;
        SourceFile39 sourceFile393;
        SourceFile39 sourceFile394;
        SourceFile29 sourceFile29;
        URL[] uRLArray;
        SourceFile54.verifyCertificates(SourceFile7.class);
        SourceFile81.verifySystemProperties(SourceFile7.class, true);
        SourceFile30.printVersion("Client Launcher");
        SourceFile75.verifyInt(stringArray.length, n -> n >= 1, "Missing args: <paramsFile>");
        Path path = SourceFile72.toPath(stringArray[0]);
        SourceFile30.debug("Reading ClientLauncher params file");
        RSAPublicKey rSAPublicKey = SourceFile71.getConfig().publicKey;
        try {
            uRLArray = new SourceFile5(SourceFile72.newInput(path));
            URL[] uRLArray2 = null;
            try {
                sourceFile29 = new SourceFile29((SourceFile5)uRLArray);
                sourceFile394 = new SourceFile39((SourceFile5)uRLArray, rSAPublicKey, SourceFile8.RO_ADAPTER);
                sourceFile393 = new SourceFile39((SourceFile5)uRLArray, rSAPublicKey, SourceFile18::new);
                sourceFile392 = new SourceFile39((SourceFile5)uRLArray, rSAPublicKey, SourceFile18::new);
                sourceFile39 = new SourceFile39((SourceFile5)uRLArray, rSAPublicKey, SourceFile18::new);
            }
            catch (Throwable object3) {
                uRLArray2 = object3;
                throw object3;
            }
            finally {
                if (uRLArray != null) {
                    if (uRLArray2 != null) {
                        try {
                            uRLArray.close();
                        }
                        catch (Throwable throwable) {
                            uRLArray2.addSuppressed(throwable);
                        }
                    } else {
                        uRLArray.close();
                    }
                }
            }
        }
        finally {
            Files.delete(path);
        }
        SourceFile30.debug("Verifying ClientLauncher sign and classpath");
        SourceFile54.verifySign(SourceFile74.BINARY_PATH, SourceFile29.keepErJErRy6HE(sourceFile29), rSAPublicKey);
        for (URL object22 : uRLArray = SourceFile81.getClassPath()) {
            object = Paths.get(object22.toURI());
            if (object.startsWith(SourceFile72.JVM_DIR) || object.equals(SourceFile74.BINARY_PATH)) continue;
            throw new SecurityException(String.format("Forbidden classpath entry: '%s'", object));
        }
        boolean bl = !((SourceFile8)sourceFile394.object).isUpdateFastCheck();
        SourceFile30.debug("Starting JVM and client WatchService");
        SourceFile49 sourceFile49 = ((SourceFile8)sourceFile394.object).getAssetUpdateMatcher();
        SourceFile49 sourceFile492 = ((SourceFile8)sourceFile394.object).getClientUpdateMatcher();
        SourceFile22 sourceFile22 = new SourceFile22(SourceFile72.JVM_DIR, (SourceFile18)sourceFile393.object, null, bl);
        object = null;
        try (SourceFile22 throwable = new SourceFile22(sourceFile29.assetDir, (SourceFile18)sourceFile392.object, sourceFile49, bl);
             SourceFile22 sourceFile222 = new SourceFile22(sourceFile29.clientDir, (SourceFile18)sourceFile39.object, sourceFile492, bl);){
            SourceFile15.newThread("JVM Directory Watcher", true, sourceFile22).start();
            SourceFile15.newThread("Asset Directory Watcher", true, throwable).start();
            SourceFile15.newThread("Client Directory Watcher", true, sourceFile222).start();
            SourceFile7.verifyHDir(SourceFile72.JVM_DIR, (SourceFile18)sourceFile393.object, null, bl);
            SourceFile7.verifyHDir(sourceFile29.assetDir, (SourceFile18)sourceFile392.object, sourceFile49, bl);
            SourceFile7.verifyHDir(sourceFile29.clientDir, (SourceFile18)sourceFile39.object, sourceFile492, bl);
            SourceFile7.keepErJErRy6HE((SourceFile8)sourceFile394.object, sourceFile29);
        }
        catch (Throwable throwable2) {
            object = throwable2;
            throw throwable2;
        }
        finally {
            if (sourceFile22 != null) {
                if (object != null) {
                    try {
                        sourceFile22.close();
                    }
                    catch (Throwable throwable3) {
                        ((Throwable)object).addSuppressed(throwable3);
                    }
                } else {
                    sourceFile22.close();
                }
            }
        }
    }

    @SourceFile3
    public static String toHash(UUID uUID) {
        return keepErJErRy6HE.matcher(uUID.toString()).replaceAll("");
    }

    @SourceFile3
    public static void verifyHDir(Path path, SourceFile18 sourceFile18, SourceFile49 sourceFile49, boolean bl) {
        SourceFile18 sourceFile182;
        if (sourceFile49 != null) {
            sourceFile49 = sourceFile49.verifyOnly();
        }
        if (!sourceFile18.diff(sourceFile182 = new SourceFile18(path, sourceFile49, false, bl), sourceFile49).isSame()) {
            throw new SecurityException(String.format("Forbidden modification: '%s'", SourceFile72.getFileName(path)));
        }
    }

    private static void keepErJErRy6HE(Collection collection, SourceFile8 sourceFile8, SourceFile29 sourceFile29) {
        SourceFile16 sourceFile16 = sourceFile29.pp;
        String string = sourceFile8.getVersion();
        Collections.addAll(collection, "--username", sourceFile16.username);
        if (SourceFile77.keepErJErRy6HE(string, "1.7.2") >= 0) {
            Collections.addAll(collection, "--uuid", SourceFile7.toHash(sourceFile16.uuid));
            Collections.addAll(collection, "--accessToken", sourceFile29.accessToken);
            if (SourceFile77.keepErJErRy6HE(string, "1.7.3") >= 0) {
                if (SourceFile77.keepErJErRy6HE(string, "1.7.4") >= 0) {
                    Collections.addAll(collection, "--userType", "mojang");
                }
                com.eclipsesource.json.SourceFile5 sourceFile5 = com.eclipsesource.json.SourceFile7.object();
                if (sourceFile16.skin != null) {
                    sourceFile5.add(SKIN_URL_PROPERTY, com.eclipsesource.json.SourceFile7.array(sourceFile16.skin.url));
                    sourceFile5.add(SKIN_DIGEST_PROPERTY, com.eclipsesource.json.SourceFile7.array(SourceFile54.toHex(sourceFile16.skin.digest)));
                }
                if (sourceFile16.cloak != null) {
                    sourceFile5.add(CLOAK_URL_PROPERTY, com.eclipsesource.json.SourceFile7.array(sourceFile16.cloak.url));
                    sourceFile5.add(CLOAK_DIGEST_PROPERTY, com.eclipsesource.json.SourceFile7.array(SourceFile54.toHex(sourceFile16.cloak.digest)));
                }
                Collections.addAll(collection, "--userProperties", sourceFile5.toString(SourceFile4.MINIMAL));
                Collections.addAll(collection, "--assetIndex", sourceFile8.getAssetIndex());
            }
        } else {
            Collections.addAll(collection, "--session", sourceFile29.accessToken);
        }
        Collections.addAll(collection, "--version", sourceFile8.getVersion());
        Collections.addAll(collection, "--gameDir", sourceFile29.clientDir.toString());
        Collections.addAll(collection, "--assetsDir", sourceFile29.assetDir.toString());
        Collections.addAll(collection, "--resourcePackDir", sourceFile29.clientDir.resolve(KeePerjeRryt52).toString());
        if (SourceFile77.keepErJErRy6HE(string, "1.9.0") >= 0) {
            Collections.addAll(collection, "--versionType", "KJ-Launcher v1.7.4.2");
        }
        if (sourceFile29.autoEnter) {
            Collections.addAll(collection, "--server", sourceFile8.getServerAddress());
            Collections.addAll(collection, "--port", Integer.toString(sourceFile8.getServerPort()));
        }
        if (sourceFile29.fullScreen) {
            Collections.addAll(collection, "--fullscreen", Boolean.toString(true));
        }
        if (sourceFile29.width > 0 && sourceFile29.height > 0) {
            Collections.addAll(collection, "--width", Integer.toString(sourceFile29.width));
            Collections.addAll(collection, "--height", Integer.toString(sourceFile29.height));
        }
    }

    private static void KeePerjeRryt52(Collection collection, SourceFile8 sourceFile8, SourceFile29 sourceFile29) {
        collection.add(sourceFile29.pp.username);
        collection.add(sourceFile29.accessToken);
        Collections.addAll(collection, "--version", sourceFile8.getVersion());
        Collections.addAll(collection, "--gameDir", sourceFile29.clientDir.toString());
        Collections.addAll(collection, "--assetsDir", sourceFile29.assetDir.toString());
    }

    private static void keepErJErRy6HE(SourceFile8 sourceFile8, SourceFile29 sourceFile29) {
        URL[] uRLArray;
        SourceFile81.addNativePath(sourceFile29.clientDir.resolve(keepErJErRy6HE));
        LinkedList linkedList = new LinkedList();
        if (SourceFile77.keepErJErRy6HE(sourceFile8.getVersion(), "1.6.0") >= 0) {
            SourceFile7.keepErJErRy6HE(linkedList, sourceFile8, sourceFile29);
        } else {
            SourceFile7.KeePerjeRryt52(linkedList, sourceFile8, sourceFile29);
        }
        Collections.addAll(linkedList, sourceFile8.getClientArgs());
        SourceFile30.debug("Args: " + linkedList);
        for (URL uRL : uRLArray = SourceFile7.keepErJErRy6HE(sourceFile29.clientDir, sourceFile8.getClassPath())) {
            SourceFile81.addClassPath(uRL);
        }
        Class<?> clazz = Class.forName(sourceFile8.getMainClass());
        MethodHandle methodHandle = SourceFile81.LOOKUP.findStatic(clazz, "main", MethodType.methodType(Void.TYPE, String[].class)).asFixedArity();
        keepErJErRy6HE.set(true);
        SourceFile81.fullGC();
        System.setProperty("minecraft.launcher.brand", "wexsidelauncher");
        System.setProperty("minecraft.launcher.version", "1.7.4.2");
        System.setProperty("minecraft.applet.TargetDirectory", sourceFile29.clientDir.toString());
        methodHandle.invoke(linkedList.toArray(keepErJErRy6HE));
    }

    private static URL[] keepErJErRy6HE(Path path, String ... stringArray) {
        LinkedList<Path> linkedList = new LinkedList<Path>();
        for (String string : stringArray) {
            Path path2 = path.resolve(SourceFile72.toPath(string));
            if (SourceFile72.isDir(path2)) {
                SourceFile72.walk(path2, new SourceFile20(linkedList, null), false);
                continue;
            }
            linkedList.add(path2);
        }
        return (URL[])linkedList.stream().map(SourceFile72::toURL).toArray(URL[]::new);
    }

    static {
        keepErJErRy6HE = Collections.unmodifiableSet(EnumSet.of(PosixFilePermission.OWNER_READ, new PosixFilePermission[]{PosixFilePermission.OWNER_WRITE, PosixFilePermission.OWNER_EXECUTE, PosixFilePermission.GROUP_READ, PosixFilePermission.GROUP_EXECUTE, PosixFilePermission.OTHERS_READ, PosixFilePermission.OTHERS_EXECUTE}));
        keepErJErRy6HE = SourceFile72.toPath("natives");
        KeePerjeRryt52 = SourceFile72.toPath("resourcepacks");
        keepErJErRy6HE = Pattern.compile("-", 16);
        keepErJErRy6HE = new AtomicBoolean(false);
    }
}


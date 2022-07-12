/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import com.sun.management.OperatingSystemMXBean;
import java.io.File;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.Field;
import java.net.URL;
import java.nio.file.Path;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.Locale;
import launcher.SourceFile13;
import launcher.SourceFile3;
import launcher.SourceFile30;
import sun.misc.Unsafe;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class SourceFile81 {
    @SourceFile3
    public static final RuntimeMXBean RUNTIME_MXBEAN = ManagementFactory.getRuntimeMXBean();
    @SourceFile3
    public static final OperatingSystemMXBean OPERATING_SYSTEM_MXBEAN = (OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
    @SourceFile3
    public static final SourceFile13 OS_TYPE = SourceFile13.byName(OPERATING_SYSTEM_MXBEAN.getName());
    @SourceFile3
    public static final String OS_VERSION = OPERATING_SYSTEM_MXBEAN.getVersion();
    @SourceFile3
    public static final int OS_BITS = SourceFile81.keepErJErRy6HE();
    @SourceFile3
    public static final int JVM_BITS = Integer.parseInt(System.getProperty("sun.arch.data.model"));
    @SourceFile3
    public static final int RAM = SourceFile81.KeePerjeRryt52();
    @SourceFile3
    public static final Unsafe UNSAFE;
    @SourceFile3
    public static final MethodHandles.Lookup LOOKUP;
    @SourceFile3
    public static final Runtime RUNTIME;
    @SourceFile3
    public static final ClassLoader LOADER;
    private static final String keepErJErRy6HE = "java.library.path";
    private static final MethodHandle keepErJErRy6HE;
    private static final MethodHandle KeePerjeRryt52;
    private static final Object keepErJErRy6HE;
    private static final MethodHandle keEPERjERryabM;
    private static final MethodHandle keEpErjeRRYsAK;
    private static final MethodHandle KeEperJErryz5T;
    private static final MethodHandle keePErjerrYnmV;

    private SourceFile81() {
    }

    @SourceFile3
    public static void addClassPath(URL uRL) {
        try {
            keEPERjERryabM.invoke(keepErJErRy6HE, uRL);
        }
        catch (Throwable throwable) {
            throw new InternalError(throwable);
        }
    }

    @SourceFile3
    public static void addNativePath(Path path) {
        String string = path.toString();
        String string2 = System.getProperty(keepErJErRy6HE);
        string2 = string2 == null || string2.isEmpty() ? string : string2 + File.pathSeparatorChar + string;
        System.setProperty(keepErJErRy6HE, string2);
        try {
            keepErJErRy6HE.invoke(null);
            KeePerjeRryt52.invoke(null);
        }
        catch (Throwable throwable) {
            throw new InternalError(throwable);
        }
    }

    @SourceFile3
    public static void fullGC() {
        RUNTIME.gc();
        RUNTIME.runFinalization();
        SourceFile30.debug("Used heap: %d MiB", RUNTIME.totalMemory() - RUNTIME.freeMemory() >> 20);
    }

    @SourceFile3
    public static Certificate[] getCertificates(String string) {
        try {
            Object object = KeEperJErryz5T.invoke(keepErJErRy6HE, string);
            return object == null ? null : keePErjerrYnmV.invoke(object);
        }
        catch (Throwable throwable) {
            throw new InternalError(throwable);
        }
    }

    @SourceFile3
    public static URL[] getClassPath() {
        try {
            return keEpErjeRRYsAK.invoke(keepErJErRy6HE);
        }
        catch (Throwable throwable) {
            throw new InternalError(throwable);
        }
    }

    @SourceFile3
    public static void halt0(int n) {
        SourceFile30.debug("Trying to halt JVM");
        try {
            LOOKUP.findStatic(Class.forName("java.lang.Shutdown"), "halt0", MethodType.methodType(Void.TYPE, Integer.TYPE)).invokeExact(n);
        }
        catch (Throwable throwable) {
            throw new InternalError(throwable);
        }
    }

    @SourceFile3
    public static boolean isJVMMatchesSystemArch() {
        return JVM_BITS == OS_BITS;
    }

    @SourceFile3
    public static void verifySystemProperties(Class clazz, boolean bl) {
        Locale.setDefault(Locale.US);
        SourceFile30.debug("Verifying class loader");
        if (bl && !clazz.getClassLoader().equals(LOADER)) {
            throw new SecurityException("ClassLoader should be system");
        }
        SourceFile30.debug("Verifying JVM architecture");
        if (!SourceFile81.isJVMMatchesSystemArch()) {
            SourceFile30.warning("Java and OS architecture mismatch");
            SourceFile30.warning("It's recommended to download %d-bit JRE", OS_BITS);
        }
    }

    private static int keepErJErRy6HE() {
        if (OS_TYPE == SourceFile13.MUSTDIE) {
            return System.getenv("ProgramFiles(x86)") == null ? 32 : 64;
        }
        return System.getProperty("os.arch").contains("64") ? 64 : 32;
    }

    private static int KeePerjeRryt52() {
        int n = (int)(OPERATING_SYSTEM_MXBEAN.getTotalPhysicalMemorySize() >> 20);
        return Math.min(n, OS_BITS == 32 ? 1536 : 65534);
    }

    public static Class keepErJErRy6HE(String ... stringArray) {
        for (String string : stringArray) {
            try {
                return Class.forName(string, false, LOADER);
            }
            catch (ClassNotFoundException classNotFoundException) {
            }
        }
        throw new ClassNotFoundException(Arrays.toString(stringArray));
    }

    static {
        RUNTIME = Runtime.getRuntime();
        LOADER = ClassLoader.getSystemClassLoader();
        try {
            MethodHandles.publicLookup();
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            UNSAFE = (Unsafe)field.get(null);
            Field field2 = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
            LOOKUP = (MethodHandles.Lookup)UNSAFE.getObject(UNSAFE.staticFieldBase(field2), UNSAFE.staticFieldOffset(field2));
            keepErJErRy6HE = LOOKUP.findStaticSetter(ClassLoader.class, "usr_paths", String[].class);
            KeePerjeRryt52 = LOOKUP.findStaticSetter(ClassLoader.class, "sys_paths", String[].class);
            Class clazz = SourceFile81.keepErJErRy6HE("jdk.internal.loader.URLClassPath", "sun.misc.URLClassPath");
            Class clazz2 = SourceFile81.keepErJErRy6HE("jdk.internal.loader.ClassLoaders$AppClassLoader", "java.net.URLClassLoader");
            Class clazz3 = SourceFile81.keepErJErRy6HE("jdk.internal.loader.Resource", "sun.misc.Resource");
            keepErJErRy6HE = LOOKUP.findGetter(clazz2, "ucp", clazz).invoke(LOADER);
            keEPERjERryabM = LOOKUP.findVirtual(clazz, "addURL", MethodType.methodType(Void.TYPE, URL.class));
            keEpErjeRRYsAK = LOOKUP.findVirtual(clazz, "getURLs", MethodType.methodType(URL[].class));
            KeEperJErryz5T = LOOKUP.findVirtual(clazz, "getResource", MethodType.methodType(clazz3, String.class));
            keePErjerrYnmV = LOOKUP.findVirtual(clazz3, "getCertificates", MethodType.methodType(Certificate[].class));
        }
        catch (Throwable throwable) {
            throw new InternalError(throwable);
        }
    }
}


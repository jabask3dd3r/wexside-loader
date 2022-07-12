/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.fusesource.jansi.Ansi
 *  org.fusesource.jansi.Ansi$Attribute
 *  org.fusesource.jansi.Ansi$Color
 *  org.fusesource.jansi.AnsiConsole
 */
package launcher;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import launcher.SourceFile17;
import launcher.SourceFile25;
import launcher.SourceFile3;
import launcher.SourceFile40;
import launcher.SourceFile44;
import launcher.SourceFile71;
import launcher.SourceFile72;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class SourceFile30 {
    @SourceFile3
    public static final String DEBUG_PROPERTY = "launcher.debug";
    @SourceFile3
    public static final String NO_JANSI_PROPERTY = "launcher.noJAnsi";
    @SourceFile3
    public static final boolean JANSI;
    private static final DateTimeFormatter keepErJErRy6HE;
    private static final AtomicBoolean keepErJErRy6HE;
    private static final Set keepErJErRy6HE;
    private static final SourceFile40 keepErJErRy6HE;

    private SourceFile30() {
    }

    @SourceFile3
    public static void addOutput(SourceFile40 sourceFile40) {
        keepErJErRy6HE.add(Objects.requireNonNull(sourceFile40, "output"));
    }

    @SourceFile3
    public static void addOutput(Path path) {
        if (JANSI) {
            SourceFile30.addOutput(new SourceFile17(SourceFile72.newOutput(path, true), null));
        } else {
            SourceFile30.addOutput(SourceFile72.newWriter(path, true));
        }
    }

    @SourceFile3
    public static void addOutput(Writer writer) {
        SourceFile30.addOutput(new SourceFile44(writer, null));
    }

    @SourceFile3
    public static void debug(String string) {
        if (SourceFile30.isDebugEnabled()) {
            SourceFile30.log(SourceFile25.DEBUG, string, false);
        }
    }

    @SourceFile3
    public static void debug(String string, Object ... objectArray) {
        SourceFile30.debug(String.format(string, objectArray));
    }

    @SourceFile3
    public static void error(Throwable throwable) {
        SourceFile30.error(SourceFile30.isDebugEnabled() ? SourceFile30.toString(throwable) : throwable.toString());
    }

    @SourceFile3
    public static void error(String string) {
        SourceFile30.log(SourceFile25.ERROR, string, false);
    }

    @SourceFile3
    public static void error(String string, Object ... objectArray) {
        SourceFile30.error(String.format(string, objectArray));
    }

    @SourceFile3
    public static void info(String string) {
        SourceFile30.log(SourceFile25.INFO, string, false);
    }

    @SourceFile3
    public static void info(String string, Object ... objectArray) {
        SourceFile30.info(String.format(string, objectArray));
    }

    @SourceFile3
    public static boolean isDebugEnabled() {
        return keepErJErRy6HE.get();
    }

    @SourceFile3
    public static void setDebugEnabled(boolean bl) {
        keepErJErRy6HE.set(bl);
    }

    @SourceFile3
    public static void log(SourceFile25 sourceFile25, String string, boolean bl) {
        String string2 = keepErJErRy6HE.format(LocalDateTime.now());
        SourceFile30.println(JANSI ? SourceFile30.keepErJErRy6HE(sourceFile25, string2, string, bl) : SourceFile30.KeePerjeRryt52(sourceFile25, string, string2, bl));
    }

    @SourceFile3
    public static void printVersion(String string) {
        SourceFile30.println(JANSI ? SourceFile30.keepErJErRy6HE(string) : SourceFile30.KeePerjeRryt52(string));
    }

    @SourceFile3
    public static synchronized void println(String string) {
        for (SourceFile40 sourceFile40 : keepErJErRy6HE) {
            sourceFile40.println(string);
        }
    }

    @SourceFile3
    public static boolean removeOutput(SourceFile40 sourceFile40) {
        return keepErJErRy6HE.remove(sourceFile40);
    }

    @SourceFile3
    public static boolean removeStdOutput() {
        return SourceFile30.removeOutput(keepErJErRy6HE);
    }

    @SourceFile3
    public static void subDebug(String string) {
        if (SourceFile30.isDebugEnabled()) {
            SourceFile30.log(SourceFile25.DEBUG, string, true);
        }
    }

    @SourceFile3
    public static void subDebug(String string, Object ... objectArray) {
        SourceFile30.subDebug(String.format(string, objectArray));
    }

    @SourceFile3
    public static void subInfo(String string) {
        SourceFile30.log(SourceFile25.INFO, string, true);
    }

    @SourceFile3
    public static void subInfo(String string, Object ... objectArray) {
        SourceFile30.subInfo(String.format(string, objectArray));
    }

    @SourceFile3
    public static void subWarning(String string) {
        SourceFile30.log(SourceFile25.WARNING, string, true);
    }

    @SourceFile3
    public static void subWarning(String string, Object ... objectArray) {
        SourceFile30.subWarning(String.format(string, objectArray));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @SourceFile3
    public static String toString(Throwable throwable) {
        try (StringWriter stringWriter = new StringWriter();){
            try (Object object = new PrintWriter(stringWriter);){
                throwable.printStackTrace((PrintWriter)object);
            }
            object = stringWriter.toString();
            return object;
        }
        catch (IOException iOException) {
            throw new AssertionError((Object)iOException);
        }
    }

    @SourceFile3
    public static void warning(String string) {
        SourceFile30.log(SourceFile25.WARNING, string, false);
    }

    @SourceFile3
    public static void warning(String string, Object ... objectArray) {
        SourceFile30.warning(String.format(string, objectArray));
    }

    private static String keepErJErRy6HE(SourceFile25 sourceFile25, String string, String string2, boolean bl) {
        Ansi.Color color;
        boolean bl2 = sourceFile25 != SourceFile25.DEBUG;
        switch (sourceFile25) {
            case WARNING: {
                color = Ansi.Color.YELLOW;
                break;
            }
            case ERROR: {
                color = Ansi.Color.RED;
                break;
            }
            default: {
                color = Ansi.Color.WHITE;
            }
        }
        Ansi ansi = new Ansi();
        ansi.fg(Ansi.Color.WHITE).a(string);
        ansi.fgBright(Ansi.Color.WHITE).a(" [").bold();
        if (bl2) {
            ansi.fgBright(color);
        } else {
            ansi.fg(color);
        }
        ansi.a((Object)sourceFile25).boldOff().fgBright(Ansi.Color.WHITE).a("] ");
        if (bl2) {
            ansi.fgBright(color);
        } else {
            ansi.fg(color);
        }
        if (bl) {
            ansi.a(' ').a(Ansi.Attribute.ITALIC);
        }
        ansi.a(string2);
        return ansi.reset().toString();
    }

    private static String keepErJErRy6HE(String string) {
        return new Ansi().bold().fgBright(Ansi.Color.MAGENTA).a("KeeperJerry's ").fgBright(Ansi.Color.CYAN).a(string).fgBright(Ansi.Color.WHITE).a(" v").fgBright(Ansi.Color.BLUE).a("1.7.4.2").fgBright(Ansi.Color.WHITE).a(" (build #").fgBright(Ansi.Color.RED).a(SourceFile71.BUILD).fgBright(Ansi.Color.WHITE).a(')').reset().toString();
    }

    private static String KeePerjeRryt52(SourceFile25 sourceFile25, String string, String string2, boolean bl) {
        if (bl) {
            string = ' ' + string;
        }
        return string2 + " [" + sourceFile25.name + "] " + string;
    }

    private static String KeePerjeRryt52(String string) {
        return String.format("wexside's %s v%s (build #%s)", string, "1.7.4.2", SourceFile71.BUILD);
    }

    static {
        boolean bl;
        keepErJErRy6HE = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss", Locale.US);
        keepErJErRy6HE = new AtomicBoolean(Boolean.getBoolean(DEBUG_PROPERTY));
        keepErJErRy6HE = Collections.newSetFromMap(new ConcurrentHashMap(2));
        try {
            if (Boolean.getBoolean(NO_JANSI_PROPERTY)) {
                bl = false;
            } else {
                Class.forName("org.fusesource.jansi.Ansi");
                AnsiConsole.systemInstall();
                bl = true;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            bl = false;
        }
        JANSI = bl;
        keepErJErRy6HE = System.out::println;
        SourceFile30.addOutput(keepErJErRy6HE);
        String string = System.getProperty("launcher.logFile");
        if (string != null) {
            try {
                SourceFile30.addOutput(SourceFile72.toPath(string));
            }
            catch (IOException iOException) {
                SourceFile30.error(iOException);
            }
        }
    }
}


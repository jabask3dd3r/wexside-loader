/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import com.sun.nio.file.ExtendedWatchEventModifier;
import com.sun.nio.file.SensitivityWatchEventModifier;
import java.io.IOException;
import java.nio.file.ClosedWatchServiceException;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import launcher.SourceFile13;
import launcher.SourceFile18;
import launcher.SourceFile3;
import launcher.SourceFile30;
import launcher.SourceFile36;
import launcher.SourceFile43;
import launcher.SourceFile49;
import launcher.SourceFile58;
import launcher.SourceFile62;
import launcher.SourceFile72;
import launcher.SourceFile81;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class SourceFile22
implements AutoCloseable,
Runnable {
    private static final boolean keepErJErRy6HE = SourceFile81.OS_TYPE == SourceFile13.MUSTDIE;
    private static final WatchEvent.Modifier[] keepErJErRy6HE = new WatchEvent.Modifier[]{SensitivityWatchEventModifier.HIGH};
    private static final WatchEvent.Modifier[] KeePerjeRryt52 = new WatchEvent.Modifier[]{ExtendedWatchEventModifier.FILE_TREE, SensitivityWatchEventModifier.HIGH};
    private static final WatchEvent.Kind[] keepErJErRy6HE = new WatchEvent.Kind[]{StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE};
    private final Path keepErJErRy6HE;
    private final SourceFile18 keepErJErRy6HE;
    private final SourceFile49 keepErJErRy6HE;
    private final WatchService keepErJErRy6HE;
    private final boolean KeePerjeRryt52;

    @SourceFile3
    public SourceFile22(Path path, SourceFile18 sourceFile18, SourceFile49 sourceFile49, boolean bl) {
        this.keepErJErRy6HE = Objects.requireNonNull(path, "dir");
        this.keepErJErRy6HE = Objects.requireNonNull(sourceFile18, "hdir");
        this.keepErJErRy6HE = sourceFile49;
        this.KeePerjeRryt52 = bl;
        this.keepErJErRy6HE = path.getFileSystem().newWatchService();
        if (keepErJErRy6HE) {
            path.register(this.keepErJErRy6HE, keepErJErRy6HE, KeePerjeRryt52);
            return;
        }
        SourceFile72.walk(path, new SourceFile36(this, null), true);
    }

    private static void keepErJErRy6HE(Throwable throwable) {
        SourceFile30.error(throwable);
        SourceFile81.halt0(195952353);
    }

    private static Deque keepErJErRy6HE(Iterable iterable) {
        LinkedList<String> linkedList = new LinkedList<String>();
        for (Path path : iterable) {
            linkedList.add(path.toString());
        }
        return linkedList;
    }

    @Override
    @SourceFile3
    public void close() {
        this.keepErJErRy6HE.close();
    }

    @Override
    @SourceFile3
    public void run() {
        try {
            this.keepErJErRy6HE();
        }
        catch (InterruptedException | ClosedWatchServiceException exception) {
        }
        catch (Throwable throwable) {
            SourceFile22.keepErJErRy6HE(throwable);
        }
    }

    private void keepErJErRy6HE(WatchKey watchKey) {
        Path path = (Path)watchKey.watchable();
        for (WatchEvent<?> watchEvent : watchKey.pollEvents()) {
            SourceFile62 sourceFile62;
            WatchEvent.Kind<?> kind = watchEvent.kind();
            if (kind.equals(StandardWatchEventKinds.OVERFLOW)) {
                if (Boolean.getBoolean("launcher.dirwatcher.ignoreOverflows")) continue;
                throw new IOException("Overflow");
            }
            Path path2 = path.resolve((Path)watchEvent.context());
            Deque deque = SourceFile22.keepErJErRy6HE(this.keepErJErRy6HE.relativize(path2));
            if (this.keepErJErRy6HE != null && !this.keepErJErRy6HE.shouldVerify(deque) || kind.equals(StandardWatchEventKinds.ENTRY_MODIFY) && (sourceFile62 = this.keepErJErRy6HE.resolve(deque)) != null && (sourceFile62.getType() != SourceFile58.FILE || ((SourceFile43)sourceFile62).isSame(path2, this.KeePerjeRryt52))) continue;
            throw new SecurityException(String.format("Forbidden modification (%s, %d times): '%s'", kind, watchEvent.count(), path2));
        }
        watchKey.reset();
    }

    private void keepErJErRy6HE() {
        while (!Thread.interrupted()) {
            this.keepErJErRy6HE(this.keepErJErRy6HE.take());
        }
    }

    static /* synthetic */ Path keepErJErRy6HE(SourceFile22 sourceFile22) {
        return sourceFile22.keepErJErRy6HE;
    }

    static /* synthetic */ WatchService keepErJErRy6HE(SourceFile22 sourceFile22) {
        return sourceFile22.keepErJErRy6HE;
    }

    static /* synthetic */ WatchEvent.Kind[] keepErJErRy6HE() {
        return keepErJErRy6HE;
    }

    static /* synthetic */ WatchEvent.Modifier[] keepErJErRy6HE() {
        return keepErJErRy6HE;
    }

    static /* synthetic */ SourceFile49 keepErJErRy6HE(SourceFile22 sourceFile22) {
        return sourceFile22.keepErJErRy6HE;
    }
}


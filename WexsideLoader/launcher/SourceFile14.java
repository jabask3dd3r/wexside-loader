/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.security.MessageDigest;
import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.zip.InflaterInputStream;
import launcher.SourceFile;
import launcher.SourceFile11;
import launcher.SourceFile18;
import launcher.SourceFile2;
import launcher.SourceFile3;
import launcher.SourceFile33;
import launcher.SourceFile39;
import launcher.SourceFile43;
import launcher.SourceFile47;
import launcher.SourceFile49;
import launcher.SourceFile5;
import launcher.SourceFile51;
import launcher.SourceFile54;
import launcher.SourceFile56;
import launcher.SourceFile58;
import launcher.SourceFile61;
import launcher.SourceFile62;
import launcher.SourceFile63;
import launcher.SourceFile72;
import launcher.SourceFile9;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class SourceFile14
extends SourceFile51 {
    @SourceFile3
    public static final int MAX_QUEUE_SIZE = 128;
    private final String keepErJErRy6HE;
    private final Path keepErJErRy6HE;
    private final SourceFile49 keepErJErRy6HE;
    private final boolean keepErJErRy6HE;
    private volatile SourceFile33 keepErJErRy6HE;
    private SourceFile18 keepErJErRy6HE;
    private long keepErJErRy6HE;
    private long KeePerjeRryt52;
    private Instant keepErJErRy6HE;

    @SourceFile3
    public SourceFile14(SourceFile2 sourceFile2, String string, Path path, SourceFile49 sourceFile49, boolean bl) {
        super(sourceFile2);
        this.keepErJErRy6HE = SourceFile72.verifyFileName(string);
        this.keepErJErRy6HE = Objects.requireNonNull(path, "dir");
        this.keepErJErRy6HE = sourceFile49;
        this.keepErJErRy6HE = bl;
    }

    @SourceFile3
    public SourceFile14(String string, Path path, SourceFile49 sourceFile49, boolean bl) {
        this(null, string, path, sourceFile49, bl);
    }

    private static void keepErJErRy6HE(Queue queue, SourceFile18 sourceFile18) {
        block4: for (Map.Entry entry : sourceFile18.map().entrySet()) {
            String string = (String)entry.getKey();
            SourceFile62 sourceFile62 = (SourceFile62)entry.getValue();
            SourceFile58 sourceFile58 = sourceFile62.getType();
            switch (sourceFile58) {
                case DIR: {
                    queue.add(new SourceFile47(SourceFile11.keepErJErRy6HE, string, sourceFile62));
                    SourceFile14.keepErJErRy6HE(queue, (SourceFile18)sourceFile62);
                    queue.add(SourceFile47.keepErJErRy6HE);
                    continue block4;
                }
                case FILE: {
                    queue.add(new SourceFile47(SourceFile11.keEPERjERryabM, string, sourceFile62));
                    continue block4;
                }
            }
            throw new AssertionError((Object)("Unsupported hashed entry type: " + sourceFile58.name()));
        }
    }

    @Override
    public SourceFile56 getType() {
        return SourceFile56.UPDATE;
    }

    public SourceFile39 keepErJErRy6HE() {
        Files.createDirectories(this.keepErJErRy6HE, new FileAttribute[0]);
        this.keepErJErRy6HE = new SourceFile18(this.keepErJErRy6HE, this.keepErJErRy6HE, false, this.keepErJErRy6HE);
        return (SourceFile39)super.request();
    }

    protected SourceFile39 keepErJErRy6HE(SourceFile5 sourceFile5, SourceFile61 sourceFile61) {
        sourceFile61.writeString(this.keepErJErRy6HE, 255);
        sourceFile61.flush();
        this.readError(sourceFile5);
        SourceFile39 sourceFile39 = new SourceFile39(sourceFile5, this.config.publicKey, SourceFile18::new);
        SourceFile sourceFile = ((SourceFile18)sourceFile39.object).diff(this.keepErJErRy6HE, this.keepErJErRy6HE);
        this.KeePerjeRryt52 = sourceFile.mismatch.size();
        boolean bl = sourceFile5.readBoolean();
        LinkedList<SourceFile47> linkedList = new LinkedList<SourceFile47>();
        SourceFile14.keepErJErRy6HE(linkedList, sourceFile.mismatch);
        linkedList.add(SourceFile47.KeePerjeRryt52);
        InputStream inputStream = bl ? new InflaterInputStream(sourceFile5.stream, SourceFile72.newInflater(), SourceFile72.BUFFER_SIZE) : sourceFile5.stream;
        this.keepErJErRy6HE = Instant.now();
        Path path = this.keepErJErRy6HE;
        SourceFile47[] sourceFile47Array = new SourceFile47[128];
        while (!linkedList.isEmpty()) {
            SourceFile47 sourceFile47;
            int n;
            int n2 = Math.min(linkedList.size(), 128);
            sourceFile61.writeLength(n2, 128);
            for (n = 0; n < n2; ++n) {
                sourceFile47Array[n] = sourceFile47 = (SourceFile47)linkedList.remove();
                sourceFile47.write(sourceFile61);
            }
            sourceFile61.flush();
            block8: for (n = 0; n < n2; ++n) {
                sourceFile47 = sourceFile47Array[n];
                switch (sourceFile47.keepErJErRy6HE) {
                    case keepErJErRy6HE: {
                        path = path.resolve(sourceFile47.keepErJErRy6HE);
                        Files.createDirectories(path, new FileAttribute[0]);
                        continue block8;
                    }
                    case keEPERjERryabM: {
                        Path path2 = path.resolve(sourceFile47.keepErJErRy6HE);
                        if (inputStream.read() != 255) {
                            throw new IOException("Serverside cached size mismath for file " + sourceFile47.keepErJErRy6HE);
                        }
                        this.keepErJErRy6HE(path2, (SourceFile43)sourceFile47.keepErJErRy6HE, inputStream);
                        continue block8;
                    }
                    case KeePerjeRryt52: {
                        path = path.getParent();
                        continue block8;
                    }
                    case keEpErjeRRYsAK: {
                        continue block8;
                    }
                    default: {
                        throw new AssertionError((Object)String.format("Unsupported action type: '%s'", sourceFile47.keepErJErRy6HE.name()));
                    }
                }
            }
        }
        this.keepErJErRy6HE(this.keepErJErRy6HE, sourceFile.extra, sourceFile.extra.flag);
        return sourceFile39;
    }

    @SourceFile3
    public void setStateCallback(SourceFile33 sourceFile33) {
        this.keepErJErRy6HE = sourceFile33;
    }

    private void keepErJErRy6HE(Path path, SourceFile18 sourceFile18, boolean bl) {
        block4: for (Map.Entry entry : sourceFile18.map().entrySet()) {
            String string = (String)entry.getKey();
            Path path2 = path.resolve(string);
            SourceFile62 sourceFile62 = (SourceFile62)entry.getValue();
            SourceFile58 sourceFile58 = sourceFile62.getType();
            switch (sourceFile58) {
                case FILE: {
                    this.keepErJErRy6HE(SourceFile72.toString(path2), 0L, 0L);
                    Files.delete(path2);
                    continue block4;
                }
                case DIR: {
                    this.keepErJErRy6HE(path2, (SourceFile18)sourceFile62, bl || sourceFile62.flag);
                    continue block4;
                }
            }
            throw new AssertionError((Object)("Unsupported hashed entry type: " + sourceFile58.name()));
        }
        if (bl) {
            this.keepErJErRy6HE(SourceFile72.toString(path), 0L, 0L);
            Files.delete(path);
        }
    }

    private void keepErJErRy6HE(Path path, SourceFile43 sourceFile43, InputStream inputStream) {
        String string = SourceFile72.toString(this.keepErJErRy6HE.relativize(path));
        this.keepErJErRy6HE(string, 0L, sourceFile43.size);
        MessageDigest messageDigest = this.keepErJErRy6HE ? SourceFile54.newDigest(SourceFile63.MD5) : null;
        try (Object object = SourceFile72.newBufferedOutStream(SourceFile72.newOutput(path));){
            long l = 0L;
            byte[] byArray = SourceFile72.newBuffer();
            while (l < sourceFile43.size) {
                int n = (int)Math.min(sourceFile43.size - l, (long)byArray.length);
                int n2 = inputStream.read(byArray, 0, n);
                if (n2 < 0) {
                    throw new EOFException(String.format("%d bytes remaining", sourceFile43.size - l));
                }
                ((OutputStream)object).write(byArray, 0, n2);
                if (messageDigest != null) {
                    messageDigest.update(byArray, 0, n2);
                }
                this.keepErJErRy6HE += (long)n2;
                this.keepErJErRy6HE(string, l += (long)n2, sourceFile43.size);
            }
            ((OutputStream)object).flush();
        }
        if (messageDigest != null && !sourceFile43.isSameDigest((byte[])(object = (Object)messageDigest.digest()))) {
            throw new SecurityException(String.format("File digest mismatch: '%s'", string));
        }
    }

    private void keepErJErRy6HE(String string, long l, long l2) {
        if (this.keepErJErRy6HE != null) {
            this.keepErJErRy6HE.keepErJErRy6HE(new SourceFile9(string, l, l2, this.keepErJErRy6HE, this.KeePerjeRryt52, Duration.between(this.keepErJErRy6HE, Instant.now())));
        }
    }

    @Override
    public /* synthetic */ Object request() {
        return this.keepErJErRy6HE();
    }

    @Override
    protected /* synthetic */ Object requestDo(SourceFile5 sourceFile5, SourceFile61 sourceFile61) {
        return this.keepErJErRy6HE(sourceFile5, sourceFile61);
    }
}


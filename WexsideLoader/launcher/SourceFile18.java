/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.nio.file.Path;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import launcher.SourceFile;
import launcher.SourceFile12;
import launcher.SourceFile3;
import launcher.SourceFile43;
import launcher.SourceFile48;
import launcher.SourceFile49;
import launcher.SourceFile5;
import launcher.SourceFile58;
import launcher.SourceFile61;
import launcher.SourceFile62;
import launcher.SourceFile72;
import launcher.SourceFile75;

public final class SourceFile18
extends SourceFile62 {
    private final Map keepErJErRy6HE = new HashMap(32);

    @SourceFile3
    public SourceFile18() {
    }

    @SourceFile3
    public SourceFile18(Path path, SourceFile49 sourceFile49, boolean bl, boolean bl2) {
        SourceFile72.walk(path, new SourceFile48(this, path, sourceFile49, bl, bl2, null), true);
    }

    @SourceFile3
    public SourceFile18(SourceFile5 sourceFile5) {
        int n = sourceFile5.readLength(0);
        for (int i = 0; i < n; ++i) {
            SourceFile62 sourceFile62;
            String string = SourceFile72.verifyFileName(sourceFile5.readString(255));
            SourceFile58 sourceFile58 = SourceFile58.read(sourceFile5);
            switch (sourceFile58) {
                case FILE: {
                    sourceFile62 = new SourceFile43(sourceFile5);
                    break;
                }
                case DIR: {
                    sourceFile62 = new SourceFile18(sourceFile5);
                    break;
                }
                default: {
                    throw new AssertionError((Object)("Unsupported hashed entry type: " + sourceFile58.name()));
                }
            }
            SourceFile75.putIfAbsent(this.keepErJErRy6HE, string, sourceFile62, String.format("Duplicate dir entry: '%s'", string));
        }
    }

    @Override
    public SourceFile58 getType() {
        return SourceFile58.DIR;
    }

    @Override
    public long size() {
        return this.keepErJErRy6HE.values().stream().mapToLong(SourceFile62::size).sum();
    }

    @Override
    public void write(SourceFile61 sourceFile61) {
        Set set = this.keepErJErRy6HE.entrySet();
        sourceFile61.writeLength(set.size(), 0);
        for (Map.Entry entry : set) {
            sourceFile61.writeString((String)entry.getKey(), 255);
            SourceFile62 sourceFile62 = (SourceFile62)entry.getValue();
            SourceFile12.write(sourceFile61, sourceFile62.getType());
            sourceFile62.write(sourceFile61);
        }
    }

    @SourceFile3
    public SourceFile diff(SourceFile18 sourceFile18, SourceFile49 sourceFile49) {
        SourceFile18 sourceFile182 = this.keepErJErRy6HE(sourceFile18, sourceFile49, new LinkedList(), true);
        SourceFile18 sourceFile183 = sourceFile18.keepErJErRy6HE(this, sourceFile49, new LinkedList(), false);
        return new SourceFile(sourceFile182, sourceFile183, null);
    }

    @SourceFile3
    public SourceFile62 getEntry(String string) {
        return (SourceFile62)this.keepErJErRy6HE.get(string);
    }

    @SourceFile3
    public boolean isEmpty() {
        return this.keepErJErRy6HE.isEmpty();
    }

    @SourceFile3
    public Map map() {
        return Collections.unmodifiableMap(this.keepErJErRy6HE);
    }

    @SourceFile3
    public SourceFile62 resolve(Iterable iterable) {
        SourceFile62 sourceFile62 = this;
        for (String string : iterable) {
            if (sourceFile62 instanceof SourceFile18) {
                sourceFile62 = (SourceFile62)sourceFile62.keepErJErRy6HE.get(string);
                continue;
            }
            return null;
        }
        return sourceFile62;
    }

    private SourceFile18 keepErJErRy6HE(SourceFile18 sourceFile18, SourceFile49 sourceFile49, Deque deque, boolean bl) {
        SourceFile18 sourceFile182 = new SourceFile18();
        for (Map.Entry entry : this.keepErJErRy6HE.entrySet()) {
            String string = (String)entry.getKey();
            SourceFile62 sourceFile62 = (SourceFile62)entry.getValue();
            deque.add(string);
            boolean bl2 = sourceFile49 == null || sourceFile49.shouldUpdate(deque);
            SourceFile58 sourceFile58 = sourceFile62.getType();
            SourceFile62 sourceFile622 = (SourceFile62)sourceFile18.keepErJErRy6HE.get(string);
            if (sourceFile622 == null || sourceFile622.getType() != sourceFile58) {
                if (bl2 || bl && sourceFile622 == null) {
                    sourceFile182.keepErJErRy6HE.put(string, sourceFile62);
                    if (!bl) {
                        sourceFile62.flag = true;
                    }
                }
                deque.removeLast();
                continue;
            }
            switch (sourceFile58) {
                case FILE: {
                    SourceFile43 sourceFile43 = (SourceFile43)sourceFile62;
                    SourceFile43 sourceFile432 = (SourceFile43)sourceFile622;
                    if (!bl || !bl2 || sourceFile43.isSame(sourceFile432)) break;
                    sourceFile182.keepErJErRy6HE.put(string, sourceFile62);
                    break;
                }
                case DIR: {
                    SourceFile18 sourceFile183;
                    SourceFile18 sourceFile184 = (SourceFile18)sourceFile62;
                    SourceFile18 sourceFile185 = (SourceFile18)sourceFile622;
                    if (!bl && !bl2 || (sourceFile183 = sourceFile184.keepErJErRy6HE(sourceFile185, sourceFile49, deque, bl)).isEmpty()) break;
                    sourceFile182.keepErJErRy6HE.put(string, sourceFile183);
                    break;
                }
                default: {
                    throw new AssertionError((Object)("Unsupported hashed entry type: " + sourceFile58.name()));
                }
            }
            deque.removeLast();
        }
        return sourceFile182;
    }

    static /* synthetic */ Map keepErJErRy6HE(SourceFile18 sourceFile18) {
        return sourceFile18.keepErJErRy6HE;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Deque;
import java.util.LinkedList;
import launcher.SourceFile18;
import launcher.SourceFile43;
import launcher.SourceFile49;
import launcher.SourceFile72;
import launcher.SourceFile78;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class SourceFile48
extends SimpleFileVisitor {
    private final Path keepErJErRy6HE;
    private final SourceFile49 keepErJErRy6HE;
    private final boolean keepErJErRy6HE;
    private final boolean KeePerjeRryt52;
    private final Deque keepErJErRy6HE = new LinkedList();
    private final Deque KeePerjeRryt52;
    private SourceFile18 KeePerjeRryt52 = this.keepErJErRy6HE;
    final /* synthetic */ SourceFile18 keepErJErRy6HE;

    private SourceFile48(SourceFile18 sourceFile18, Path path, SourceFile49 sourceFile49, boolean bl, boolean bl2) {
        this.keepErJErRy6HE = sourceFile18;
        this.keepErJErRy6HE = path;
        this.keepErJErRy6HE = sourceFile49;
        this.keepErJErRy6HE = bl;
        this.KeePerjeRryt52 = bl2;
    }

    public FileVisitResult keepErJErRy6HE(Path path, IOException iOException) {
        FileVisitResult fileVisitResult = super.postVisitDirectory(path, iOException);
        if (this.keepErJErRy6HE.equals(path)) {
            return fileVisitResult;
        }
        SourceFile18 sourceFile18 = (SourceFile18)this.KeePerjeRryt52.removeLast();
        SourceFile18.keepErJErRy6HE(sourceFile18).put(this.keepErJErRy6HE.removeLast(), this.KeePerjeRryt52);
        this.KeePerjeRryt52 = sourceFile18;
        return fileVisitResult;
    }

    public FileVisitResult keepErJErRy6HE(Path path, BasicFileAttributes basicFileAttributes) {
        FileVisitResult fileVisitResult = super.preVisitDirectory(path, basicFileAttributes);
        if (this.keepErJErRy6HE.equals(path)) {
            return fileVisitResult;
        }
        if (!this.keepErJErRy6HE && basicFileAttributes.isSymbolicLink()) {
            throw new SecurityException("Symlinks are not allowed");
        }
        this.KeePerjeRryt52.add(this.KeePerjeRryt52);
        this.KeePerjeRryt52 = new SourceFile18();
        this.keepErJErRy6HE.add(SourceFile72.getFileName(path));
        return fileVisitResult;
    }

    public FileVisitResult KeePerjeRryt52(Path path, BasicFileAttributes basicFileAttributes) {
        if (!this.keepErJErRy6HE && basicFileAttributes.isSymbolicLink()) {
            throw new SecurityException("Symlinks are not allowed");
        }
        this.keepErJErRy6HE.add(SourceFile72.getFileName(path));
        boolean bl = this.KeePerjeRryt52 && (this.keepErJErRy6HE == null || this.keepErJErRy6HE.shouldUpdate(this.keepErJErRy6HE));
        SourceFile18.keepErJErRy6HE(this.KeePerjeRryt52).put(this.keepErJErRy6HE.removeLast(), new SourceFile43(path, basicFileAttributes.size(), bl));
        return super.visitFile(path, basicFileAttributes);
    }

    @Override
    public /* synthetic */ FileVisitResult postVisitDirectory(Object object, IOException iOException) {
        return this.keepErJErRy6HE((Path)object, iOException);
    }

    @Override
    public /* synthetic */ FileVisitResult visitFile(Object object, BasicFileAttributes basicFileAttributes) {
        return this.KeePerjeRryt52((Path)object, basicFileAttributes);
    }

    @Override
    public /* synthetic */ FileVisitResult preVisitDirectory(Object object, BasicFileAttributes basicFileAttributes) {
        return this.keepErJErRy6HE((Path)object, basicFileAttributes);
    }

    /* synthetic */ SourceFile48(SourceFile18 sourceFile18, Path path, SourceFile49 sourceFile49, boolean bl, boolean bl2, SourceFile78 sourceFile78) {
        this(sourceFile18, path, sourceFile49, bl, bl2);
    }
}


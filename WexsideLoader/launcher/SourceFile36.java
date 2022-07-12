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
import launcher.SourceFile22;
import launcher.SourceFile42;
import launcher.SourceFile72;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class SourceFile36
extends SimpleFileVisitor {
    private final Deque keepErJErRy6HE = new LinkedList();
    final /* synthetic */ SourceFile22 keepErJErRy6HE;

    private SourceFile36(SourceFile22 sourceFile22) {
        this.keepErJErRy6HE = sourceFile22;
    }

    public FileVisitResult keepErJErRy6HE(Path path, IOException iOException) {
        FileVisitResult fileVisitResult = super.postVisitDirectory(path, iOException);
        if (!SourceFile22.keepErJErRy6HE(this.keepErJErRy6HE).equals(path)) {
            this.keepErJErRy6HE.removeLast();
        }
        return fileVisitResult;
    }

    public FileVisitResult keepErJErRy6HE(Path path, BasicFileAttributes basicFileAttributes) {
        FileVisitResult fileVisitResult = super.preVisitDirectory(path, basicFileAttributes);
        if (SourceFile22.keepErJErRy6HE(this.keepErJErRy6HE).equals(path)) {
            path.register(SourceFile22.keepErJErRy6HE(this.keepErJErRy6HE), SourceFile22.keepErJErRy6HE(), SourceFile22.keepErJErRy6HE());
            return fileVisitResult;
        }
        this.keepErJErRy6HE.add(SourceFile72.getFileName(path));
        if (SourceFile22.keepErJErRy6HE(this.keepErJErRy6HE) != null && !SourceFile22.keepErJErRy6HE(this.keepErJErRy6HE).shouldVerify(this.keepErJErRy6HE)) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        path.register(SourceFile22.keepErJErRy6HE(this.keepErJErRy6HE), SourceFile22.keepErJErRy6HE(), SourceFile22.keepErJErRy6HE());
        return fileVisitResult;
    }

    @Override
    public /* synthetic */ FileVisitResult postVisitDirectory(Object object, IOException iOException) {
        return this.keepErJErRy6HE((Path)object, iOException);
    }

    @Override
    public /* synthetic */ FileVisitResult preVisitDirectory(Object object, BasicFileAttributes basicFileAttributes) {
        return this.keepErJErRy6HE((Path)object, basicFileAttributes);
    }

    /* synthetic */ SourceFile36(SourceFile22 sourceFile22, SourceFile42 sourceFile42) {
        this(sourceFile22);
    }
}


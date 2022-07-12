/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import launcher.SourceFile60;

final class SourceFile10
implements FileVisitor {
    private final FileVisitor keepErJErRy6HE;

    private SourceFile10(FileVisitor fileVisitor) {
        this.keepErJErRy6HE = fileVisitor;
    }

    public FileVisitResult keepErJErRy6HE(Path path, IOException iOException) {
        return Files.isHidden(path) ? FileVisitResult.CONTINUE : this.keepErJErRy6HE.postVisitDirectory(path, iOException);
    }

    public FileVisitResult keepErJErRy6HE(Path path, BasicFileAttributes basicFileAttributes) {
        return Files.isHidden(path) ? FileVisitResult.SKIP_SUBTREE : this.keepErJErRy6HE.preVisitDirectory(path, basicFileAttributes);
    }

    public FileVisitResult KeePerjeRryt52(Path path, BasicFileAttributes basicFileAttributes) {
        return Files.isHidden(path) ? FileVisitResult.CONTINUE : this.keepErJErRy6HE.visitFile(path, basicFileAttributes);
    }

    public FileVisitResult KeePerjeRryt52(Path path, IOException iOException) {
        return this.keepErJErRy6HE.visitFileFailed(path, iOException);
    }

    public /* synthetic */ FileVisitResult postVisitDirectory(Object object, IOException iOException) {
        return this.keepErJErRy6HE((Path)object, iOException);
    }

    public /* synthetic */ FileVisitResult visitFileFailed(Object object, IOException iOException) {
        return this.KeePerjeRryt52((Path)object, iOException);
    }

    public /* synthetic */ FileVisitResult visitFile(Object object, BasicFileAttributes basicFileAttributes) {
        return this.KeePerjeRryt52((Path)object, basicFileAttributes);
    }

    public /* synthetic */ FileVisitResult preVisitDirectory(Object object, BasicFileAttributes basicFileAttributes) {
        return this.keepErJErRy6HE((Path)object, basicFileAttributes);
    }

    /* synthetic */ SourceFile10(FileVisitor fileVisitor, SourceFile60 sourceFile60) {
        this(fileVisitor);
    }
}


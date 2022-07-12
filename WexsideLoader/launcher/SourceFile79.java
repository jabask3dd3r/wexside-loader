/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import launcher.SourceFile60;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class SourceFile79
extends SimpleFileVisitor {
    private final Path keepErJErRy6HE;
    private final boolean keepErJErRy6HE;

    private SourceFile79(Path path, boolean bl) {
        this.keepErJErRy6HE = path;
        this.keepErJErRy6HE = bl;
    }

    public FileVisitResult keepErJErRy6HE(Path path, IOException iOException) {
        FileVisitResult fileVisitResult = super.postVisitDirectory(path, iOException);
        if (this.keepErJErRy6HE || !this.keepErJErRy6HE.equals(path)) {
            Files.delete(path);
        }
        return fileVisitResult;
    }

    public FileVisitResult keepErJErRy6HE(Path path, BasicFileAttributes basicFileAttributes) {
        Files.delete(path);
        return super.visitFile(path, basicFileAttributes);
    }

    @Override
    public /* synthetic */ FileVisitResult postVisitDirectory(Object object, IOException iOException) {
        return this.keepErJErRy6HE((Path)object, iOException);
    }

    @Override
    public /* synthetic */ FileVisitResult visitFile(Object object, BasicFileAttributes basicFileAttributes) {
        return this.keepErJErRy6HE((Path)object, basicFileAttributes);
    }

    /* synthetic */ SourceFile79(Path path, boolean bl, SourceFile60 sourceFile60) {
        this(path, bl);
    }
}


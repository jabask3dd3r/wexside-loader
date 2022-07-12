/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collection;
import launcher.SourceFile72;
import launcher.SourceFile84;

final class SourceFile20
extends SimpleFileVisitor {
    private final Collection keepErJErRy6HE;

    private SourceFile20(Collection collection) {
        this.keepErJErRy6HE = collection;
    }

    public FileVisitResult keepErJErRy6HE(Path path, BasicFileAttributes basicFileAttributes) {
        if (SourceFile72.hasExtension(path, "jar") || SourceFile72.hasExtension(path, "zip")) {
            this.keepErJErRy6HE.add(path);
        }
        return super.visitFile(path, basicFileAttributes);
    }

    @Override
    public /* synthetic */ FileVisitResult visitFile(Object object, BasicFileAttributes basicFileAttributes) {
        return this.keepErJErRy6HE((Path)object, basicFileAttributes);
    }

    /* synthetic */ SourceFile20(Collection collection, SourceFile84 sourceFile84) {
        this(collection);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.fusesource.jansi.AnsiOutputStream
 */
package launcher;

import java.io.OutputStream;
import launcher.SourceFile44;
import launcher.SourceFile59;
import launcher.SourceFile72;
import org.fusesource.jansi.AnsiOutputStream;

final class SourceFile17
extends SourceFile44 {
    private SourceFile17(OutputStream outputStream) {
        super(SourceFile72.newWriter((OutputStream)new AnsiOutputStream(outputStream)), null);
    }

    /* synthetic */ SourceFile17(OutputStream outputStream, SourceFile59 sourceFile59) {
        this(outputStream);
    }
}


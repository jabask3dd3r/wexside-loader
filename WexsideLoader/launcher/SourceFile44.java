/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.io.IOException;
import java.io.Writer;
import launcher.SourceFile40;
import launcher.SourceFile59;

class SourceFile44
implements AutoCloseable,
SourceFile40 {
    private final Writer keepErJErRy6HE;

    private SourceFile44(Writer writer) {
        this.keepErJErRy6HE = writer;
    }

    @Override
    public void close() {
        this.keepErJErRy6HE.close();
    }

    @Override
    public void println(String string) {
        try {
            this.keepErJErRy6HE.write(string + System.lineSeparator());
            this.keepErJErRy6HE.flush();
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    /* synthetic */ SourceFile44(Writer writer, SourceFile59 sourceFile59) {
        this(writer);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.io.ByteArrayOutputStream;
import launcher.SourceFile3;
import launcher.SourceFile61;
import launcher.SourceFile72;

public abstract class SourceFile19 {
    @SourceFile3
    public abstract void write(SourceFile61 var1);

    @SourceFile3
    public final byte[] write() {
        try (ByteArrayOutputStream byteArrayOutputStream = SourceFile72.newByteArrayOutput();){
            try (Object object = new SourceFile61(byteArrayOutputStream);){
                this.write((SourceFile61)object);
            }
            object = byteArrayOutputStream.toByteArray();
            return object;
        }
    }
}


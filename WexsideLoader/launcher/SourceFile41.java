/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;
import launcher.SourceFile19;
import launcher.SourceFile3;
import launcher.SourceFile5;
import launcher.SourceFile54;
import launcher.SourceFile61;
import launcher.SourceFile63;
import launcher.SourceFile72;

public final class SourceFile41
extends SourceFile19 {
    private static final SourceFile63 keepErJErRy6HE = SourceFile63.SHA256;
    @SourceFile3
    public final String url;
    @SourceFile3
    public final byte[] digest;

    @SourceFile3
    public SourceFile41(String string, byte[] byArray) {
        this.url = SourceFile72.verifyURL(string);
        this.digest = Objects.requireNonNull(byArray, "digest");
    }

    @SourceFile3
    public SourceFile41(String string, boolean bl) {
        byte[] byArray;
        this.url = SourceFile72.verifyURL(string);
        try (InputStream inputStream = SourceFile72.newInput(new URL(string));){
            byArray = SourceFile72.read(inputStream);
        }
        inputStream = new ByteArrayInputStream(byArray);
        var5_4 = null;
        try {
            SourceFile72.readTexture(inputStream, bl);
        }
        catch (Throwable throwable) {
            var5_4 = throwable;
            throw throwable;
        }
        finally {
            if (inputStream != null) {
                if (var5_4 != null) {
                    try {
                        ((ByteArrayInputStream)inputStream).close();
                    }
                    catch (Throwable throwable) {
                        var5_4.addSuppressed(throwable);
                    }
                } else {
                    ((ByteArrayInputStream)inputStream).close();
                }
            }
        }
        this.digest = SourceFile54.digest(keepErJErRy6HE, new URL(string));
    }

    @SourceFile3
    public SourceFile41(SourceFile5 sourceFile5) {
        this.url = SourceFile72.verifyURL(sourceFile5.readASCII(2048));
        this.digest = sourceFile5.readByteArray(-SourceFile41.keepErJErRy6HE.bytes);
    }

    @Override
    public void write(SourceFile61 sourceFile61) {
        sourceFile61.writeASCII(this.url, 2048);
        sourceFile61.writeByteArray(this.digest, -SourceFile41.keepErJErRy6HE.bytes);
    }
}


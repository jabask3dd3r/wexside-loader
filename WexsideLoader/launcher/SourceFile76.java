/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import launcher.SourceFile16;
import launcher.SourceFile2;
import launcher.SourceFile3;
import launcher.SourceFile5;
import launcher.SourceFile51;
import launcher.SourceFile53;
import launcher.SourceFile56;
import launcher.SourceFile61;
import launcher.SourceFile75;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class SourceFile76
extends SourceFile51 {
    private final String keepErJErRy6HE;
    private final byte[] keepErJErRy6HE;

    @SourceFile3
    public SourceFile76(SourceFile2 sourceFile2, String string, byte[] byArray) {
        super(sourceFile2);
        this.keepErJErRy6HE = (String)SourceFile75.verify(string, SourceFile75.NOT_EMPTY, "Login can't be empty");
        this.keepErJErRy6HE = (byte[])byArray.clone();
    }

    @SourceFile3
    public SourceFile76(String string, byte[] byArray) {
        this(null, string, byArray);
    }

    @Override
    public SourceFile56 getType() {
        return SourceFile56.AUTH;
    }

    protected SourceFile53 keepErJErRy6HE(SourceFile5 sourceFile5, SourceFile61 sourceFile61) {
        sourceFile61.writeString(this.keepErJErRy6HE, 255);
        sourceFile61.writeByteArray(this.keepErJErRy6HE, 2048);
        sourceFile61.flush();
        this.readError(sourceFile5);
        SourceFile16 sourceFile16 = new SourceFile16(sourceFile5);
        int n = sourceFile5.readInt();
        String string = sourceFile5.readASCII(-n);
        return new SourceFile53(sourceFile16, string, null);
    }

    @Override
    protected /* synthetic */ Object requestDo(SourceFile5 sourceFile5, SourceFile61 sourceFile61) {
        return this.keepErJErRy6HE(sourceFile5, sourceFile61);
    }
}


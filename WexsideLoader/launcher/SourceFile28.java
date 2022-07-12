/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import launcher.SourceFile16;
import launcher.SourceFile2;
import launcher.SourceFile3;
import launcher.SourceFile5;
import launcher.SourceFile51;
import launcher.SourceFile56;
import launcher.SourceFile61;
import launcher.SourceFile72;
import launcher.SourceFile75;

public final class SourceFile28
extends SourceFile51 {
    @SourceFile3
    public static final int MAX_BATCH_SIZE = 128;
    private final String[] keepErJErRy6HE;

    @SourceFile3
    public SourceFile28(SourceFile2 sourceFile2, String ... stringArray) {
        super(sourceFile2);
        this.keepErJErRy6HE = (String[])stringArray.clone();
        SourceFile72.verifyLength(this.keepErJErRy6HE.length, 128);
        for (String string : this.keepErJErRy6HE) {
            SourceFile75.verifyUsername(string);
        }
    }

    @SourceFile3
    public SourceFile28(String ... stringArray) {
        this((SourceFile2)null, stringArray);
    }

    @Override
    public SourceFile56 getType() {
        return SourceFile56.BATCH_PROFILE_BY_USERNAME;
    }

    protected SourceFile16[] keepErJErRy6HE(SourceFile5 sourceFile5, SourceFile61 sourceFile61) {
        sourceFile61.writeLength(this.keepErJErRy6HE.length, 128);
        for (String string : this.keepErJErRy6HE) {
            sourceFile61.writeString(string, 64);
        }
        sourceFile61.flush();
        Object[] objectArray = new SourceFile16[this.keepErJErRy6HE.length];
        for (int i = 0; i < objectArray.length; ++i) {
            objectArray[i] = sourceFile5.readBoolean() ? new SourceFile16(sourceFile5) : null;
        }
        return objectArray;
    }

    @Override
    protected /* synthetic */ Object requestDo(SourceFile5 sourceFile5, SourceFile61 sourceFile61) {
        return this.keepErJErRy6HE(sourceFile5, sourceFile61);
    }
}


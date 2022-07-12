/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.util.Objects;
import java.util.UUID;
import launcher.SourceFile16;
import launcher.SourceFile2;
import launcher.SourceFile3;
import launcher.SourceFile5;
import launcher.SourceFile51;
import launcher.SourceFile56;
import launcher.SourceFile61;

public final class SourceFile27
extends SourceFile51 {
    private final UUID keepErJErRy6HE;

    @SourceFile3
    public SourceFile27(SourceFile2 sourceFile2, UUID uUID) {
        super(sourceFile2);
        this.keepErJErRy6HE = Objects.requireNonNull(uUID, "uuid");
    }

    @SourceFile3
    public SourceFile27(UUID uUID) {
        this(null, uUID);
    }

    @Override
    public SourceFile56 getType() {
        return SourceFile56.PROFILE_BY_UUID;
    }

    protected SourceFile16 keepErJErRy6HE(SourceFile5 sourceFile5, SourceFile61 sourceFile61) {
        sourceFile61.writeUUID(this.keepErJErRy6HE);
        sourceFile61.flush();
        return sourceFile5.readBoolean() ? new SourceFile16(sourceFile5) : null;
    }

    @Override
    protected /* synthetic */ Object requestDo(SourceFile5 sourceFile5, SourceFile61 sourceFile61) {
        return this.keepErJErRy6HE(sourceFile5, sourceFile61);
    }
}


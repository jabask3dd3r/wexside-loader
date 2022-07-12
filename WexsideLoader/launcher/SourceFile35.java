/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.util.Objects;
import launcher.SourceFile12;
import launcher.SourceFile19;
import launcher.SourceFile3;
import launcher.SourceFile37;
import launcher.SourceFile45;
import launcher.SourceFile5;
import launcher.SourceFile50;
import launcher.SourceFile61;
import launcher.SourceFile80;
import launcher.SourceFile82;
import launcher.SourceFile83;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class SourceFile35
extends SourceFile19 {
    @SourceFile3
    public final boolean ro;
    private final String[] keepErJErRy6HE;
    private Object keepErJErRy6HE;

    protected SourceFile35(Object object, boolean bl, int n) {
        this.ro = bl;
        this.keepErJErRy6HE = new String[n];
        this.keepErJErRy6HE(object);
    }

    protected static SourceFile35 keepErJErRy6HE(SourceFile5 sourceFile5, boolean bl) {
        SourceFile45 sourceFile45 = SourceFile45.read(sourceFile5);
        switch (sourceFile45) {
            case BOOLEAN: {
                return new SourceFile37(sourceFile5, bl);
            }
            case INTEGER: {
                return new SourceFile82(sourceFile5, bl);
            }
            case STRING: {
                return new SourceFile80(sourceFile5, bl);
            }
            case LIST: {
                return new SourceFile50(sourceFile5, bl);
            }
            case BLOCK: {
                return new SourceFile83(sourceFile5, bl);
            }
        }
        throw new AssertionError((Object)("Unsupported config entry type: " + sourceFile45.name()));
    }

    protected static void keepErJErRy6HE(SourceFile35 sourceFile35, SourceFile61 sourceFile61) {
        SourceFile12.write(sourceFile61, sourceFile35.getType());
        sourceFile35.write(sourceFile61);
    }

    @SourceFile3
    public abstract SourceFile45 getType();

    @SourceFile3
    public final String getComment(int n) {
        if (n < 0) {
            n += this.keepErJErRy6HE.length;
        }
        return n >= this.keepErJErRy6HE.length ? null : this.keepErJErRy6HE[n];
    }

    @SourceFile3
    public Object getValue() {
        return this.keepErJErRy6HE;
    }

    @SourceFile3
    public final void setValue(Object object) {
        this.keepErJErRy6HE();
        this.keepErJErRy6HE(object);
    }

    @SourceFile3
    public final void setComment(int n, String string) {
        this.keepErJErRy6HE[n] = string;
    }

    protected final void keepErJErRy6HE() {
        if (this.ro) {
            throw new UnsupportedOperationException("Read-only");
        }
    }

    protected void keepErJErRy6HE(Object object) {
        this.keepErJErRy6HE = Objects.requireNonNull(object, "value");
    }
}


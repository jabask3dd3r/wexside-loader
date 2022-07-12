/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import launcher.SourceFile3;
import launcher.SourceFile35;
import launcher.SourceFile45;
import launcher.SourceFile5;
import launcher.SourceFile61;

public final class SourceFile50
extends SourceFile35 {
    @SourceFile3
    public SourceFile50(List list, boolean bl, int n) {
        super(list, bl, n);
    }

    @SourceFile3
    public SourceFile50(SourceFile5 sourceFile5, boolean bl) {
        super(SourceFile50.keepErJErRy6HE(sourceFile5, bl), bl, 0);
    }

    private static List keepErJErRy6HE(SourceFile5 sourceFile5, boolean bl) {
        int n = sourceFile5.readLength(0);
        ArrayList<SourceFile35> arrayList = new ArrayList<SourceFile35>(n);
        for (int i = 0; i < n; ++i) {
            arrayList.add(SourceFile50.keepErJErRy6HE(sourceFile5, bl));
        }
        return arrayList;
    }

    @Override
    public SourceFile45 getType() {
        return SourceFile45.LIST;
    }

    protected void keepErJErRy6HE(List list) {
        ArrayList arrayList = new ArrayList(list);
        super.keepErJErRy6HE(this.ro ? Collections.unmodifiableList(arrayList) : arrayList);
    }

    @Override
    public void write(SourceFile61 sourceFile61) {
        List list = (List)this.getValue();
        sourceFile61.writeLength(list.size(), 0);
        for (SourceFile35 sourceFile35 : list) {
            SourceFile50.keepErJErRy6HE(sourceFile35, sourceFile61);
        }
    }

    @SourceFile3
    public Stream stream(Class clazz) {
        return ((List)this.getValue()).stream().map(clazz::cast).map(SourceFile35::getValue);
    }

    @SourceFile3
    public void verifyOfType(SourceFile45 sourceFile45) {
        if (((List)this.getValue()).stream().anyMatch(sourceFile35 -> sourceFile35.getType() != sourceFile45)) {
            throw new IllegalArgumentException("List type mismatch: " + sourceFile45.name());
        }
    }
}


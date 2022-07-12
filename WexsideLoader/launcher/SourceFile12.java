/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.util.HashMap;
import java.util.Map;
import launcher.SourceFile3;
import launcher.SourceFile5;
import launcher.SourceFile6;
import launcher.SourceFile61;
import launcher.SourceFile75;

public final class SourceFile12 {
    private final Map keepErJErRy6HE = new HashMap(16);

    @SourceFile3
    public SourceFile12(Class clazz) {
        for (Enum enum_ : (Enum[])clazz.getEnumConstants()) {
            SourceFile75.putIfAbsent(this.keepErJErRy6HE, ((SourceFile6)((Object)enum_)).getNumber(), enum_, "Duplicate number for enum constant " + enum_.name());
        }
    }

    @SourceFile3
    public static void write(SourceFile61 sourceFile61, SourceFile6 sourceFile6) {
        sourceFile61.writeVarInt(sourceFile6.getNumber());
    }

    @SourceFile3
    public Enum read(SourceFile5 sourceFile5) {
        int n = sourceFile5.readVarInt();
        return (Enum)SourceFile75.getMapValue(this.keepErJErRy6HE, n, "Unknown enum number: " + n);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import launcher.SourceFile3;
import launcher.SourceFile35;
import launcher.SourceFile45;
import launcher.SourceFile5;
import launcher.SourceFile61;
import launcher.SourceFile75;

public final class SourceFile83
extends SourceFile35 {
    @SourceFile3
    public SourceFile83(Map map, boolean bl, int n) {
        super(map, bl, n);
    }

    @SourceFile3
    public SourceFile83(int n) {
        super(Collections.emptyMap(), false, n);
    }

    @SourceFile3
    public SourceFile83(SourceFile5 sourceFile5, boolean bl) {
        super(SourceFile83.keepErJErRy6HE(sourceFile5, bl), bl, 0);
    }

    private static Map keepErJErRy6HE(SourceFile5 sourceFile5, boolean bl) {
        int n = sourceFile5.readLength(0);
        LinkedHashMap linkedHashMap = new LinkedHashMap(n);
        for (int i = 0; i < n; ++i) {
            String string = SourceFile75.verifyIDName(sourceFile5.readString(255));
            SourceFile35 sourceFile35 = SourceFile83.keepErJErRy6HE(sourceFile5, bl);
            SourceFile75.putIfAbsent(linkedHashMap, string, sourceFile35, String.format("Duplicate config entry: '%s'", string));
        }
        return linkedHashMap;
    }

    @Override
    public SourceFile45 getType() {
        return SourceFile45.BLOCK;
    }

    public Map keepErJErRy6HE() {
        Map map = (Map)super.getValue();
        return this.ro ? map : Collections.unmodifiableMap(map);
    }

    protected void keepErJErRy6HE(Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.keySet().stream().forEach(SourceFile75::verifyIDName);
        super.keepErJErRy6HE(this.ro ? Collections.unmodifiableMap(linkedHashMap) : linkedHashMap);
    }

    @Override
    public void write(SourceFile61 sourceFile61) {
        Set set = this.keepErJErRy6HE().entrySet();
        sourceFile61.writeLength(set.size(), 0);
        for (Map.Entry entry : set) {
            sourceFile61.writeString((String)entry.getKey(), 255);
            SourceFile83.keepErJErRy6HE((SourceFile35)entry.getValue(), sourceFile61);
        }
    }

    @SourceFile3
    public void clear() {
        ((Map)super.getValue()).clear();
    }

    @SourceFile3
    public SourceFile35 getEntry(String string, Class clazz) {
        Map map = (Map)super.getValue();
        SourceFile35 sourceFile35 = (SourceFile35)map.get(string);
        if (!clazz.isInstance(sourceFile35)) {
            throw new NoSuchElementException(string);
        }
        return (SourceFile35)clazz.cast(sourceFile35);
    }

    @SourceFile3
    public Object getEntryValue(String string, Class clazz) {
        return this.getEntry(string, clazz).getValue();
    }

    @SourceFile3
    public boolean hasEntry(String string) {
        return this.keepErJErRy6HE().containsKey(string);
    }

    @SourceFile3
    public void remove(String string) {
        ((Map)super.getValue()).remove(string);
    }

    @SourceFile3
    public void setEntry(String string, SourceFile35 sourceFile35) {
        ((Map)super.getValue()).put(SourceFile75.verifyIDName(string), sourceFile35);
    }

    @Override
    public /* synthetic */ Object getValue() {
        return this.keepErJErRy6HE();
    }
}


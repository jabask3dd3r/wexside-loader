/*
 * Decompiled with CFR 0.152.
 */
package com.eclipsesource.json;

import com.eclipsesource.json.SourceFile;
import com.eclipsesource.json.SourceFile$DefaultHandler;
import com.eclipsesource.json.SourceFile12;
import com.eclipsesource.json.SourceFile2;
import com.eclipsesource.json.SourceFile3;
import com.eclipsesource.json.SourceFile5;
import com.eclipsesource.json.SourceFile6;
import com.eclipsesource.json.SourceFile8;
import java.io.Reader;

public final class SourceFile7 {
    public static final SourceFile8 NULL = new SourceFile("null");
    public static final SourceFile8 TRUE = new SourceFile("true");
    public static final SourceFile8 FALSE = new SourceFile("false");

    private SourceFile7() {
    }

    public static SourceFile8 value(int n) {
        return new SourceFile3(Integer.toString(n, 10));
    }

    public static SourceFile8 value(long l) {
        return new SourceFile3(Long.toString(l, 10));
    }

    public static SourceFile8 value(float f) {
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            throw new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
        }
        return new SourceFile3(SourceFile7.cutOffPointZero(Float.toString(f)));
    }

    public static SourceFile8 value(double d) {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
        }
        return new SourceFile3(SourceFile7.cutOffPointZero(Double.toString(d)));
    }

    public static SourceFile8 value(String string) {
        return string == null ? NULL : new SourceFile6(string);
    }

    public static SourceFile8 value(boolean bl) {
        return bl ? TRUE : FALSE;
    }

    public static SourceFile12 array() {
        return new SourceFile12();
    }

    public static SourceFile12 array(int ... nArray) {
        if (nArray == null) {
            throw new NullPointerException("values is null");
        }
        SourceFile12 sourceFile12 = new SourceFile12();
        for (int n : nArray) {
            sourceFile12.add(n);
        }
        return sourceFile12;
    }

    public static SourceFile12 array(long ... lArray) {
        if (lArray == null) {
            throw new NullPointerException("values is null");
        }
        SourceFile12 sourceFile12 = new SourceFile12();
        for (long l : lArray) {
            sourceFile12.add(l);
        }
        return sourceFile12;
    }

    public static SourceFile12 array(float ... fArray) {
        if (fArray == null) {
            throw new NullPointerException("values is null");
        }
        SourceFile12 sourceFile12 = new SourceFile12();
        for (float f : fArray) {
            sourceFile12.add(f);
        }
        return sourceFile12;
    }

    public static SourceFile12 array(double ... dArray) {
        if (dArray == null) {
            throw new NullPointerException("values is null");
        }
        SourceFile12 sourceFile12 = new SourceFile12();
        for (double d : dArray) {
            sourceFile12.add(d);
        }
        return sourceFile12;
    }

    public static SourceFile12 array(boolean ... blArray) {
        if (blArray == null) {
            throw new NullPointerException("values is null");
        }
        SourceFile12 sourceFile12 = new SourceFile12();
        for (boolean bl : blArray) {
            sourceFile12.add(bl);
        }
        return sourceFile12;
    }

    public static SourceFile12 array(String ... stringArray) {
        if (stringArray == null) {
            throw new NullPointerException("values is null");
        }
        SourceFile12 sourceFile12 = new SourceFile12();
        for (String string : stringArray) {
            sourceFile12.add(string);
        }
        return sourceFile12;
    }

    public static SourceFile5 object() {
        return new SourceFile5();
    }

    public static SourceFile8 parse(String string) {
        if (string == null) {
            throw new NullPointerException("string is null");
        }
        SourceFile$DefaultHandler sourceFile$DefaultHandler = new SourceFile$DefaultHandler();
        new SourceFile2(sourceFile$DefaultHandler).parse(string);
        return sourceFile$DefaultHandler.getValue();
    }

    public static SourceFile8 parse(Reader reader) {
        if (reader == null) {
            throw new NullPointerException("reader is null");
        }
        SourceFile$DefaultHandler sourceFile$DefaultHandler = new SourceFile$DefaultHandler();
        new SourceFile2(sourceFile$DefaultHandler).parse(reader);
        return sourceFile$DefaultHandler.getValue();
    }

    private static String cutOffPointZero(String string) {
        if (string.endsWith(".0")) {
            return string.substring(0, string.length() - 2);
        }
        return string;
    }
}


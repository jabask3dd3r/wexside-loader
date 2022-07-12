/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import launcher.SourceFile3;
import launcher.SourceFile35;
import launcher.SourceFile37;
import launcher.SourceFile50;
import launcher.SourceFile75;
import launcher.SourceFile80;
import launcher.SourceFile82;
import launcher.SourceFile83;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class SourceFile38 {
    private final LineNumberReader keepErJErRy6HE;
    private final boolean keepErJErRy6HE;
    private String keepErJErRy6HE;
    private int keepErJErRy6HE = -1;

    private SourceFile38(Reader reader, boolean bl) {
        this.keepErJErRy6HE = new LineNumberReader(reader);
        this.keepErJErRy6HE.setLineNumber(1);
        this.keepErJErRy6HE = bl;
    }

    @SourceFile3
    public static SourceFile83 read(Reader reader, boolean bl) {
        return new SourceFile38(reader, bl).keepErJErRy6HE(0);
    }

    private IOException keepErJErRy6HE(String string) {
        return new IOException(string + " (line " + this.keepErJErRy6HE.getLineNumber() + ')');
    }

    private int keepErJErRy6HE(boolean bl) {
        this.keepErJErRy6HE = this.keepErJErRy6HE.read();
        if (bl && this.keepErJErRy6HE < 0) {
            throw this.keepErJErRy6HE("Unexpected end of config");
        }
        return this.keepErJErRy6HE;
    }

    private int KeePerjeRryt52(boolean bl) {
        this.keepErJErRy6HE(bl);
        return this.keEPERjERryabM(bl);
    }

    private SourceFile83 keepErJErRy6HE(int n) {
        Object object;
        boolean bl;
        LinkedHashMap<String, SourceFile35> linkedHashMap = new LinkedHashMap<String, SourceFile35>(16);
        boolean bl2 = bl = this.keepErJErRy6HE == 123;
        while (!(this.KeePerjeRryt52(bl) < 0 || bl && this.keepErJErRy6HE == 125)) {
            object = this.keepErJErRy6HE;
            String string = this.keepErJErRy6HE();
            if (this.keEPERjERryabM(true) != 58) {
                throw this.keepErJErRy6HE("Value start expected");
            }
            String string2 = this.keepErJErRy6HE;
            this.KeePerjeRryt52(true);
            String string3 = this.keepErJErRy6HE;
            SourceFile35 sourceFile35 = this.keepErJErRy6HE(4);
            if (this.keEPERjERryabM(true) != 59) {
                throw this.keepErJErRy6HE("Value end expected");
            }
            sourceFile35.setComment(0, (String)object);
            sourceFile35.setComment(1, string2);
            sourceFile35.setComment(2, string3);
            sourceFile35.setComment(3, this.keepErJErRy6HE);
            if (linkedHashMap.put(string, sourceFile35) == null) continue;
            throw this.keepErJErRy6HE(String.format("Duplicate config entry: '%s'", string));
        }
        object = new SourceFile83(linkedHashMap, this.keepErJErRy6HE, n + 1);
        ((SourceFile35)object).setComment(n, this.keepErJErRy6HE);
        this.keepErJErRy6HE(false);
        return object;
    }

    private SourceFile35 keepErJErRy6HE(int n) {
        String string;
        switch (this.keepErJErRy6HE) {
            case 34: {
                return this.keEpErjeRRYsAK(n);
            }
            case 91: {
                return this.keEPERjERryabM(n);
            }
            case 123: {
                return this.keepErJErRy6HE(n);
            }
        }
        if (this.keepErJErRy6HE == 45 || this.keepErJErRy6HE >= 48 && this.keepErJErRy6HE <= 57) {
            return this.KeePerjeRryt52(n);
        }
        switch (string = this.keepErJErRy6HE()) {
            case "true": {
                return new SourceFile37(Boolean.TRUE, this.keepErJErRy6HE, n);
            }
            case "false": {
                return new SourceFile37(Boolean.FALSE, this.keepErJErRy6HE, n);
            }
        }
        throw this.keepErJErRy6HE(String.format("Unknown statement: '%s'", string));
    }

    private SourceFile35 KeePerjeRryt52(int n) {
        return new SourceFile82(Integer.parseInt(this.keepErJErRy6HE()), this.keepErJErRy6HE, n);
    }

    private SourceFile35 keEPERjERryabM(int n) {
        ArrayList<SourceFile35> arrayList = new ArrayList<SourceFile35>(16);
        boolean bl = this.KeePerjeRryt52(true) != 93;
        String string = this.keepErJErRy6HE;
        while (bl) {
            SourceFile35 sourceFile35 = this.keepErJErRy6HE(2);
            bl = this.keEPERjERryabM(true) != 93;
            sourceFile35.setComment(0, string);
            sourceFile35.setComment(1, this.keepErJErRy6HE);
            arrayList.add(sourceFile35);
            if (!bl) continue;
            if (this.keepErJErRy6HE != 44) {
                throw this.keepErJErRy6HE("Comma expected");
            }
            this.KeePerjeRryt52(true);
            string = this.keepErJErRy6HE;
        }
        boolean bl2 = arrayList.isEmpty();
        SourceFile50 sourceFile50 = new SourceFile50(arrayList, this.keepErJErRy6HE, bl2 ? n + 1 : n);
        if (bl2) {
            sourceFile50.setComment(n, this.keepErJErRy6HE);
        }
        this.keepErJErRy6HE(false);
        return sourceFile50;
    }

    private SourceFile35 keEpErjeRRYsAK(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        block12: while (this.keepErJErRy6HE(true) != 34) {
            switch (this.keepErJErRy6HE) {
                case 10: 
                case 13: {
                    throw this.keepErJErRy6HE("String termination");
                }
                case 92: {
                    int n2 = this.keepErJErRy6HE(true);
                    switch (n2) {
                        case 116: {
                            stringBuilder.append('\t');
                            continue block12;
                        }
                        case 98: {
                            stringBuilder.append('\b');
                            continue block12;
                        }
                        case 110: {
                            stringBuilder.append('\n');
                            continue block12;
                        }
                        case 114: {
                            stringBuilder.append('\r');
                            continue block12;
                        }
                        case 102: {
                            stringBuilder.append('\f');
                            continue block12;
                        }
                        case 34: 
                        case 92: {
                            stringBuilder.append((char)n2);
                            continue block12;
                        }
                    }
                    throw this.keepErJErRy6HE("Illegal char escape: " + (char)n2);
                }
            }
            stringBuilder.append((char)this.keepErJErRy6HE);
        }
        this.keepErJErRy6HE(false);
        return new SourceFile80(stringBuilder.toString(), this.keepErJErRy6HE, n);
    }

    private String keepErJErRy6HE() {
        StringBuilder stringBuilder = new StringBuilder();
        while (SourceFile75.isValidIDNameChar(this.keepErJErRy6HE)) {
            stringBuilder.append((char)this.keepErJErRy6HE);
            this.keepErJErRy6HE(false);
        }
        String string = stringBuilder.toString();
        if (string.isEmpty()) {
            throw this.keepErJErRy6HE("Not a token");
        }
        return string;
    }

    private void keepErJErRy6HE(StringBuilder stringBuilder, boolean bl) {
        while (this.keepErJErRy6HE >= 0 && this.keepErJErRy6HE != 13 && this.keepErJErRy6HE != 10) {
            stringBuilder.append((char)this.keepErJErRy6HE);
            this.keepErJErRy6HE(bl);
        }
    }

    private int keEPERjERryabM(boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        while (Character.isWhitespace(this.keepErJErRy6HE) || this.keepErJErRy6HE == 35) {
            if (this.keepErJErRy6HE == 35) {
                this.keepErJErRy6HE(stringBuilder, bl);
                continue;
            }
            stringBuilder.append((char)this.keepErJErRy6HE);
            this.keepErJErRy6HE(bl);
        }
        this.keepErJErRy6HE = stringBuilder.toString();
        return this.keepErJErRy6HE;
    }
}


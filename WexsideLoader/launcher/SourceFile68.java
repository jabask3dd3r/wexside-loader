/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.io.Writer;
import java.util.List;
import java.util.Map;
import launcher.SourceFile3;
import launcher.SourceFile35;
import launcher.SourceFile37;
import launcher.SourceFile45;
import launcher.SourceFile50;
import launcher.SourceFile80;
import launcher.SourceFile82;
import launcher.SourceFile83;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class SourceFile68 {
    private final Writer keepErJErRy6HE;
    private final boolean keepErJErRy6HE;

    private SourceFile68(Writer writer, boolean bl) {
        this.keepErJErRy6HE = writer;
        this.keepErJErRy6HE = bl;
    }

    @SourceFile3
    public static void write(SourceFile83 sourceFile83, Writer writer, boolean bl) {
        new SourceFile68(writer, bl).keepErJErRy6HE(sourceFile83, false);
    }

    private void keepErJErRy6HE(SourceFile83 sourceFile83, boolean bl) {
        if (bl) {
            this.keepErJErRy6HE.write(123);
        }
        Map map = sourceFile83.keepErJErRy6HE();
        for (Map.Entry entry : map.entrySet()) {
            String string = (String)entry.getKey();
            SourceFile35 sourceFile35 = (SourceFile35)entry.getValue();
            this.keepErJErRy6HE(sourceFile35.getComment(0));
            this.keepErJErRy6HE.write(string);
            this.keepErJErRy6HE(sourceFile35.getComment(1));
            this.keepErJErRy6HE.write(58);
            this.keepErJErRy6HE(sourceFile35.getComment(2));
            this.keepErJErRy6HE(sourceFile35);
            this.keepErJErRy6HE(sourceFile35.getComment(3));
            this.keepErJErRy6HE.write(59);
        }
        this.keepErJErRy6HE(sourceFile83.getComment(-1));
        if (bl) {
            this.keepErJErRy6HE.write(125);
        }
    }

    private void keepErJErRy6HE(SourceFile37 sourceFile37) {
        this.keepErJErRy6HE.write(((Boolean)sourceFile37.getValue()).toString());
    }

    private void keepErJErRy6HE(String string) {
        if (this.keepErJErRy6HE && string != null) {
            this.keepErJErRy6HE.write(string);
        }
    }

    private void keepErJErRy6HE(SourceFile35 sourceFile35) {
        SourceFile45 sourceFile45 = sourceFile35.getType();
        switch (sourceFile45) {
            case BLOCK: {
                this.keepErJErRy6HE((SourceFile83)sourceFile35, true);
                break;
            }
            case STRING: {
                this.keepErJErRy6HE((SourceFile80)sourceFile35);
                break;
            }
            case INTEGER: {
                this.keepErJErRy6HE((SourceFile82)sourceFile35);
                break;
            }
            case BOOLEAN: {
                this.keepErJErRy6HE((SourceFile37)sourceFile35);
                break;
            }
            case LIST: {
                this.keepErJErRy6HE((SourceFile50)sourceFile35);
                break;
            }
            default: {
                throw new AssertionError((Object)("Unsupported config entry type: " + sourceFile45.name()));
            }
        }
    }

    private void keepErJErRy6HE(SourceFile82 sourceFile82) {
        this.keepErJErRy6HE.write(Integer.toString((Integer)sourceFile82.getValue()));
    }

    private void keepErJErRy6HE(SourceFile50 sourceFile50) {
        this.keepErJErRy6HE.write(91);
        List list = (List)sourceFile50.getValue();
        for (int i = 0; i < list.size(); ++i) {
            if (i > 0) {
                this.keepErJErRy6HE.write(44);
            }
            SourceFile35 sourceFile35 = (SourceFile35)list.get(i);
            this.keepErJErRy6HE(sourceFile35.getComment(0));
            this.keepErJErRy6HE(sourceFile35);
            this.keepErJErRy6HE(sourceFile35.getComment(1));
        }
        this.keepErJErRy6HE(sourceFile50.getComment(-1));
        this.keepErJErRy6HE.write(93);
    }

    private void keepErJErRy6HE(SourceFile80 sourceFile80) {
        this.keepErJErRy6HE.write(34);
        String string = (String)sourceFile80.getValue();
        block8: for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            switch (c) {
                case '\t': {
                    this.keepErJErRy6HE.write("\\t");
                    continue block8;
                }
                case '\b': {
                    this.keepErJErRy6HE.write("\\b");
                    continue block8;
                }
                case '\n': {
                    this.keepErJErRy6HE.write("\\n");
                    continue block8;
                }
                case '\r': {
                    this.keepErJErRy6HE.write("\\r");
                    continue block8;
                }
                case '\f': {
                    this.keepErJErRy6HE.write("\\f");
                    continue block8;
                }
                case '\"': 
                case '\\': {
                    this.keepErJErRy6HE.write(92);
                    this.keepErJErRy6HE.write(c);
                    continue block8;
                }
                default: {
                    this.keepErJErRy6HE.write(c);
                }
            }
        }
        this.keepErJErRy6HE.write(34);
    }
}


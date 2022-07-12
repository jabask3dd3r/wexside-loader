/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.util.concurrent.atomic.AtomicBoolean;
import launcher.SourceFile12;
import launcher.SourceFile2;
import launcher.SourceFile24;
import launcher.SourceFile3;
import launcher.SourceFile5;
import launcher.SourceFile56;
import launcher.SourceFile61;
import launcher.SourceFile71;

public abstract class SourceFile51 {
    @SourceFile3
    protected final SourceFile2 config;
    private final AtomicBoolean keepErJErRy6HE = new AtomicBoolean(false);

    @SourceFile3
    protected SourceFile51(SourceFile2 sourceFile2) {
        this.config = sourceFile2 == null ? SourceFile71.getConfig() : sourceFile2;
    }

    @SourceFile3
    protected SourceFile51() {
        this(null);
    }

    @SourceFile3
    public static void requestError(String string) {
        throw new SourceFile24(string);
    }

    @SourceFile3
    public abstract SourceFile56 getType();

    @SourceFile3
    protected abstract Object requestDo(SourceFile5 var1, SourceFile61 var2);

    /*
     * Exception decompiling
     */
    @SourceFile3
    public Object request() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    @SourceFile3
    protected final void readError(SourceFile5 sourceFile5) {
        String string = sourceFile5.readString(0);
        if (!string.isEmpty()) {
            SourceFile51.requestError(string);
        }
    }

    private void keepErJErRy6HE(SourceFile5 sourceFile5, SourceFile61 sourceFile61) {
        sourceFile61.writeInt(1917264919);
        sourceFile61.writeBigInteger(this.config.publicKey.getModulus(), 257);
        SourceFile12.write(sourceFile61, this.getType());
        sourceFile61.flush();
        if (!sourceFile5.readBoolean()) {
            SourceFile51.requestError("Serverside not accepted this connection");
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import com.eclipsesource.json.SourceFile7;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.regex.Pattern;
import launcher.SourceFile3;
import launcher.SourceFile30;
import launcher.SourceFile31;
import launcher.SourceFile5;
import launcher.SourceFile61;
import launcher.SourceFile72;
import launcher.SourceFile75;
import launcher.SourceFile81;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class SourceFile21 {
    private static final String keepErJErRy6HE = "\u00a71";
    private static final String KeePerjeRryt52 = "MC|PingHost";
    private static final Pattern keepErJErRy6HE = Pattern.compile("\u0000", 16);
    private static final int keepErJErRy6HE = 65535;
    private final InetSocketAddress keepErJErRy6HE;
    private final String keEPERjERryabM;
    private final Object keepErJErRy6HE;
    private SourceFile31 keepErJErRy6HE;
    private Throwable keepErJErRy6HE;
    private long keepErJErRy6HE = Long.MIN_VALUE;

    @SourceFile3
    public SourceFile21(InetSocketAddress inetSocketAddress, String string) {
        this.keepErJErRy6HE = Objects.requireNonNull(inetSocketAddress, "address");
        this.keEPERjERryabM = Objects.requireNonNull(string, "version");
    }

    private static String keepErJErRy6HE(SourceFile5 sourceFile5) {
        int n = sourceFile5.readUnsignedShort() << 1;
        byte[] byArray = sourceFile5.readByteArray(-n);
        return new String(byArray, StandardCharsets.UTF_16BE);
    }

    private static void keepErJErRy6HE(SourceFile61 sourceFile61, String string) {
        sourceFile61.writeShort((short)string.length());
        sourceFile61.stream.write(string.getBytes(StandardCharsets.UTF_16BE));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @SourceFile3
    public SourceFile31 ping() {
        Object object = this.keepErJErRy6HE;
        synchronized (object) {
            if (System.currentTimeMillis() >= this.keepErJErRy6HE) {
                try {
                    this.keepErJErRy6HE = this.keepErJErRy6HE();
                    this.keepErJErRy6HE = null;
                }
                catch (Throwable throwable) {
                    this.keepErJErRy6HE = null;
                    this.keepErJErRy6HE = throwable;
                }
                finally {
                    this.keepErJErRy6HE = System.currentTimeMillis() + (long)SourceFile72.SOCKET_TIMEOUT;
                }
            }
            if (this.keepErJErRy6HE != null) {
                SourceFile81.UNSAFE.throwException(this.keepErJErRy6HE);
            }
            return this.keepErJErRy6HE;
        }
    }

    /*
     * Exception decompiling
     */
    private SourceFile31 keepErJErRy6HE() {
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

    private SourceFile31 keepErJErRy6HE(SourceFile5 sourceFile5, SourceFile61 sourceFile61, boolean bl) {
        Object object;
        String[] stringArray;
        Object object2;
        sourceFile61.writeUnsignedByte(254);
        sourceFile61.writeUnsignedByte(1);
        if (bl) {
            byte[] byArray;
            sourceFile61.writeUnsignedByte(250);
            SourceFile21.keepErJErRy6HE(sourceFile61, KeePerjeRryt52);
            object2 = SourceFile72.newByteArrayOutput();
            stringArray = null;
            try {
                object = new SourceFile61((OutputStream)object2);
                Throwable throwable = null;
                try {
                    ((SourceFile61)object).writeUnsignedByte(78);
                    SourceFile21.keepErJErRy6HE((SourceFile61)object, this.keepErJErRy6HE.getHostString());
                    ((SourceFile61)object).writeInt(this.keepErJErRy6HE.getPort());
                }
                catch (Throwable throwable2) {
                    throwable = throwable2;
                    throw throwable2;
                }
                finally {
                    if (object != null) {
                        if (throwable != null) {
                            try {
                                ((SourceFile61)object).close();
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        } else {
                            ((SourceFile61)object).close();
                        }
                    }
                }
                byArray = ((ByteArrayOutputStream)object2).toByteArray();
            }
            catch (Throwable object3) {
                stringArray = object3;
                throw object3;
            }
            finally {
                if (object2 != null) {
                    if (stringArray != null) {
                        try {
                            ((ByteArrayOutputStream)object2).close();
                        }
                        catch (Throwable throwable) {
                            stringArray.addSuppressed(throwable);
                        }
                    } else {
                        ((ByteArrayOutputStream)object2).close();
                    }
                }
            }
            sourceFile61.writeShort((short)byArray.length);
            sourceFile61.stream.write(byArray);
        }
        sourceFile61.flush();
        int n = sourceFile5.readUnsignedByte();
        if (n != 255) {
            throw new IOException("Illegal kick packet ID: " + n);
        }
        object2 = SourceFile21.keepErJErRy6HE(sourceFile5);
        SourceFile30.debug("Ping response (legacy): '%s'", object2);
        stringArray = keepErJErRy6HE.split((CharSequence)object2);
        if (stringArray.length != 6) {
            throw new IOException("Tokens count mismatch");
        }
        object = stringArray[0];
        if (!((String)object).equals(keepErJErRy6HE)) {
            throw new IOException("Magic string mismatch: " + (String)object);
        }
        int n2 = Integer.parseInt(stringArray[1]);
        if (n2 != 78) {
            throw new IOException("Protocol mismatch: " + n2);
        }
        String string = stringArray[2];
        if (!string.equals(this.keEPERjERryabM)) {
            throw new IOException(String.format("Version mismatch: '%s'", string));
        }
        int n3 = SourceFile75.verifyInt(Integer.parseInt(stringArray[4]), SourceFile75.NOT_NEGATIVE, "onlinePlayers can't be < 0");
        int n4 = SourceFile75.verifyInt(Integer.parseInt(stringArray[5]), SourceFile75.NOT_NEGATIVE, "maxPlayers can't be < 0");
        return new SourceFile31(n3, n4, (String)object2);
    }

    private SourceFile31 keepErJErRy6HE(SourceFile5 sourceFile5, SourceFile61 sourceFile61) {
        byte[] byArray;
        Object object;
        Object object2;
        ByteArrayOutputStream byteArrayOutputStream = SourceFile72.newByteArrayOutput();
        Object object3 = null;
        try {
            object2 = new SourceFile61(byteArrayOutputStream);
            object = null;
            try {
                ((SourceFile61)object2).writeVarInt(0);
                ((SourceFile61)object2).writeVarInt(-1);
                ((SourceFile61)object2).writeString(this.keepErJErRy6HE.getHostString(), 0);
                ((SourceFile61)object2).writeShort((short)this.keepErJErRy6HE.getPort());
                ((SourceFile61)object2).writeVarInt(1);
            }
            catch (Throwable throwable) {
                object = throwable;
                throw throwable;
            }
            finally {
                if (object2 != null) {
                    if (object != null) {
                        try {
                            ((SourceFile61)object2).close();
                        }
                        catch (Throwable throwable) {
                            ((Throwable)object).addSuppressed(throwable);
                        }
                    } else {
                        ((SourceFile61)object2).close();
                    }
                }
            }
            byArray = byteArrayOutputStream.toByteArray();
        }
        catch (Throwable throwable) {
            object3 = throwable;
            throw throwable;
        }
        finally {
            if (byteArrayOutputStream != null) {
                if (object3 != null) {
                    try {
                        byteArrayOutputStream.close();
                    }
                    catch (Throwable throwable) {
                        ((Throwable)object3).addSuppressed(throwable);
                    }
                } else {
                    byteArrayOutputStream.close();
                }
            }
        }
        sourceFile61.writeByteArray(byArray, 65535);
        sourceFile61.writeVarInt(1);
        sourceFile61.writeVarInt(0);
        sourceFile61.flush();
        int n = 0;
        while (n <= 0) {
            n = SourceFile72.verifyLength(sourceFile5.readVarInt(), 65535);
        }
        object2 = sourceFile5.readByteArray(-n);
        object = new SourceFile5((byte[])object2);
        Serializable serializable = null;
        try {
            int n2 = ((SourceFile5)object).readVarInt();
            if (n2 != 0) {
                throw new IOException("Illegal status packet ID: " + n2);
            }
            object3 = ((SourceFile5)object).readString(65535);
            SourceFile30.debug("Ping response (modern): '%s'", object3);
        }
        catch (Throwable throwable) {
            serializable = throwable;
            throw throwable;
        }
        finally {
            if (object != null) {
                if (serializable != null) {
                    try {
                        ((SourceFile5)object).close();
                    }
                    catch (Throwable throwable) {
                        ((Throwable)serializable).addSuppressed(throwable);
                    }
                } else {
                    ((SourceFile5)object).close();
                }
            }
        }
        object = SourceFile7.parse((String)object3).asObject();
        serializable = ((com.eclipsesource.json.SourceFile5)object).get("players").asObject();
        int n3 = ((com.eclipsesource.json.SourceFile5)serializable).get("online").asInt();
        int n4 = ((com.eclipsesource.json.SourceFile5)serializable).get("max").asInt();
        return new SourceFile31(n3, n4, (String)object3);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.net.InetSocketAddress;
import launcher.SourceFile3;
import launcher.SourceFile34;
import launcher.SourceFile37;
import launcher.SourceFile45;
import launcher.SourceFile49;
import launcher.SourceFile5;
import launcher.SourceFile50;
import launcher.SourceFile64;
import launcher.SourceFile72;
import launcher.SourceFile75;
import launcher.SourceFile77;
import launcher.SourceFile80;
import launcher.SourceFile82;
import launcher.SourceFile83;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class SourceFile8
extends SourceFile64
implements Comparable {
    @SourceFile3
    public static final SourceFile34 RO_ADAPTER = sourceFile5 -> new SourceFile8(sourceFile5, true);
    private static final SourceFile49 keepErJErRy6HE = new SourceFile49(new String[0], new String[]{"indexes", "objects"}, new String[0]);
    private final SourceFile80 keepErJErRy6HE;
    private final SourceFile80 KeePerjeRryt52;
    private final SourceFile82 keepErJErRy6HE;
    private final SourceFile80 keEPERjERryabM;
    private final SourceFile80 keEpErjeRRYsAK;
    private final SourceFile82 KeePerjeRryt52;
    private final SourceFile50 keepErJErRy6HE;
    private final SourceFile50 KeePerjeRryt52;
    private final SourceFile50 keEPERjERryabM;
    private final SourceFile37 keepErJErRy6HE;
    private final SourceFile80 KeEperJErryz5T;
    private final SourceFile50 keEpErjeRRYsAK;
    private final SourceFile50 KeEperJErryz5T;
    private final SourceFile50 keePErjerrYnmV;

    @SourceFile3
    public SourceFile8(SourceFile83 sourceFile83) {
        super(sourceFile83);
        this.keepErJErRy6HE = (SourceFile80)sourceFile83.getEntry("version", SourceFile80.class);
        this.KeePerjeRryt52 = (SourceFile80)sourceFile83.getEntry("assetIndex", SourceFile80.class);
        this.keepErJErRy6HE = (SourceFile82)sourceFile83.getEntry("sortIndex", SourceFile82.class);
        this.keEPERjERryabM = (SourceFile80)sourceFile83.getEntry("title", SourceFile80.class);
        this.keEpErjeRRYsAK = (SourceFile80)sourceFile83.getEntry("serverAddress", SourceFile80.class);
        this.KeePerjeRryt52 = (SourceFile82)sourceFile83.getEntry("serverPort", SourceFile82.class);
        this.keepErJErRy6HE = (SourceFile50)sourceFile83.getEntry("update", SourceFile50.class);
        this.keEPERjERryabM = (SourceFile50)sourceFile83.getEntry("updateVerify", SourceFile50.class);
        this.KeePerjeRryt52 = (SourceFile50)sourceFile83.getEntry("updateExclusions", SourceFile50.class);
        this.keepErJErRy6HE = (SourceFile37)sourceFile83.getEntry("updateFastCheck", SourceFile37.class);
        this.KeEperJErryz5T = (SourceFile80)sourceFile83.getEntry("mainClass", SourceFile80.class);
        this.KeEperJErryz5T = (SourceFile50)sourceFile83.getEntry("classPath", SourceFile50.class);
        this.keEpErjeRRYsAK = (SourceFile50)sourceFile83.getEntry("jvmArgs", SourceFile50.class);
        this.keePErjerrYnmV = (SourceFile50)sourceFile83.getEntry("clientArgs", SourceFile50.class);
    }

    @SourceFile3
    public SourceFile8(SourceFile5 sourceFile5, boolean bl) {
        this(new SourceFile83(sourceFile5, bl));
    }

    public int keepErJErRy6HE(SourceFile8 sourceFile8) {
        return Integer.compare(this.getSortIndex(), sourceFile8.getSortIndex());
    }

    public String toString() {
        return (String)this.keEPERjERryabM.getValue();
    }

    @SourceFile3
    public String getAssetIndex() {
        return (String)this.KeePerjeRryt52.getValue();
    }

    @SourceFile3
    public void setAssetIndex(String string) {
        this.KeePerjeRryt52.setValue(string);
    }

    @SourceFile3
    public SourceFile49 getAssetUpdateMatcher() {
        return SourceFile77.keepErJErRy6HE(this.getVersion(), "1.7.3") >= 0 ? keepErJErRy6HE : null;
    }

    @SourceFile3
    public String[] getClassPath() {
        return (String[])this.KeEperJErryz5T.stream(SourceFile80.class).toArray(String[]::new);
    }

    @SourceFile3
    public String[] getClientArgs() {
        return (String[])this.keePErjerrYnmV.stream(SourceFile80.class).toArray(String[]::new);
    }

    @SourceFile3
    public SourceFile49 getClientUpdateMatcher() {
        String[] stringArray = (String[])this.keepErJErRy6HE.stream(SourceFile80.class).toArray(String[]::new);
        String[] stringArray2 = (String[])this.keEPERjERryabM.stream(SourceFile80.class).toArray(String[]::new);
        String[] stringArray3 = (String[])this.KeePerjeRryt52.stream(SourceFile80.class).toArray(String[]::new);
        return new SourceFile49(stringArray, stringArray2, stringArray3);
    }

    @SourceFile3
    public String[] getJvmArgs() {
        return (String[])this.keEpErjeRRYsAK.stream(SourceFile80.class).toArray(String[]::new);
    }

    @SourceFile3
    public String getMainClass() {
        return (String)this.KeEperJErryz5T.getValue();
    }

    @SourceFile3
    public String getServerAddress() {
        return (String)this.keEpErjeRRYsAK.getValue();
    }

    @SourceFile3
    public int getServerPort() {
        return (Integer)this.KeePerjeRryt52.getValue();
    }

    @SourceFile3
    public InetSocketAddress getServerSocketAddress() {
        return InetSocketAddress.createUnresolved(this.getServerAddress(), this.getServerPort());
    }

    @SourceFile3
    public int getSortIndex() {
        return (Integer)this.keepErJErRy6HE.getValue();
    }

    @SourceFile3
    public String getTitle() {
        return (String)this.keEPERjERryabM.getValue();
    }

    @SourceFile3
    public void setTitle(String string) {
        this.keEPERjERryabM.setValue(string);
    }

    @SourceFile3
    public String getVersion() {
        return (String)this.keepErJErRy6HE.getValue();
    }

    @SourceFile3
    public void setVersion(String string) {
        this.keepErJErRy6HE.setValue(string);
    }

    @SourceFile3
    public boolean isUpdateFastCheck() {
        return (Boolean)this.keepErJErRy6HE.getValue();
    }

    @SourceFile3
    public void verify() {
        SourceFile75.verify(this.getVersion(), SourceFile75.NOT_EMPTY, "Game version can't be empty");
        SourceFile72.verifyFileName(this.getAssetIndex());
        SourceFile75.verify(this.getTitle(), SourceFile75.NOT_EMPTY, "Profile title can't be empty");
        SourceFile75.verify(this.getServerAddress(), SourceFile75.NOT_EMPTY, "Server address can't be empty");
        SourceFile75.verifyInt(this.getServerPort(), SourceFile75.range(0, 65535), "Illegal server port: " + this.getServerPort());
        this.keepErJErRy6HE.verifyOfType(SourceFile45.STRING);
        this.keEPERjERryabM.verifyOfType(SourceFile45.STRING);
        this.KeePerjeRryt52.verifyOfType(SourceFile45.STRING);
        this.keEpErjeRRYsAK.verifyOfType(SourceFile45.STRING);
        this.KeEperJErryz5T.verifyOfType(SourceFile45.STRING);
        this.keePErjerrYnmV.verifyOfType(SourceFile45.STRING);
        SourceFile75.verify(this.getTitle(), SourceFile75.NOT_EMPTY, "Main class can't be empty");
    }

    public /* synthetic */ int compareTo(Object object) {
        return this.keepErJErRy6HE((SourceFile8)object);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.util.regex.Pattern;
import launcher.SourceFile2;
import launcher.SourceFile3;
import launcher.SourceFile5;
import launcher.SourceFile51;
import launcher.SourceFile54;
import launcher.SourceFile56;
import launcher.SourceFile61;
import launcher.SourceFile75;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class SourceFile65
extends SourceFile51 {
    private static final Pattern keepErJErRy6HE = Pattern.compile("-?[0-9a-f]{1,40}");
    private final String keepErJErRy6HE;
    private final String KeePerjeRryt52;
    private final String keEPERjERryabM;

    @SourceFile3
    public SourceFile65(SourceFile2 sourceFile2, String string, String string2, String string3) {
        super(sourceFile2);
        this.keepErJErRy6HE = SourceFile75.verifyUsername(string);
        this.KeePerjeRryt52 = SourceFile54.verifyToken(string2);
        this.keEPERjERryabM = SourceFile65.verifyServerID(string3);
    }

    @SourceFile3
    public SourceFile65(String string, String string2, String string3) {
        this(null, string, string2, string3);
    }

    @SourceFile3
    public static boolean isValidServerID(CharSequence charSequence) {
        return keepErJErRy6HE.matcher(charSequence).matches();
    }

    @SourceFile3
    public static String verifyServerID(String string) {
        return (String)SourceFile75.verify(string, SourceFile65::isValidServerID, String.format("Invalid server ID: '%s'", string));
    }

    @Override
    public SourceFile56 getType() {
        return SourceFile56.JOIN_SERVER;
    }

    protected Boolean keepErJErRy6HE(SourceFile5 sourceFile5, SourceFile61 sourceFile61) {
        sourceFile61.writeString(this.keepErJErRy6HE, 64);
        sourceFile61.writeInt(this.KeePerjeRryt52.length());
        sourceFile61.writeASCII(this.KeePerjeRryt52, -this.KeePerjeRryt52.length());
        sourceFile61.writeASCII(this.keEPERjERryabM, 41);
        sourceFile61.flush();
        this.readError(sourceFile5);
        return sourceFile5.readBoolean();
    }

    @Override
    protected /* synthetic */ Object requestDo(SourceFile5 sourceFile5, SourceFile61 sourceFile61) {
        return this.keepErJErRy6HE(sourceFile5, sourceFile61);
    }
}


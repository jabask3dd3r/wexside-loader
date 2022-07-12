/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.util.Objects;
import java.util.UUID;
import launcher.SourceFile19;
import launcher.SourceFile3;
import launcher.SourceFile41;
import launcher.SourceFile5;
import launcher.SourceFile61;
import launcher.SourceFile72;
import launcher.SourceFile75;

public final class SourceFile16
extends SourceFile19 {
    @SourceFile3
    public final UUID uuid;
    @SourceFile3
    public final String username;
    @SourceFile3
    public final SourceFile41 skin;
    @SourceFile3
    public final SourceFile41 cloak;

    @SourceFile3
    public SourceFile16(SourceFile5 sourceFile5) {
        this.uuid = sourceFile5.readUUID();
        this.username = SourceFile75.verifyUsername(sourceFile5.readString(64));
        this.skin = sourceFile5.readBoolean() ? new SourceFile41(sourceFile5) : null;
        this.cloak = sourceFile5.readBoolean() ? new SourceFile41(sourceFile5) : null;
    }

    @SourceFile3
    public SourceFile16(UUID uUID, String string, SourceFile41 sourceFile41, SourceFile41 sourceFile412) {
        this.uuid = Objects.requireNonNull(uUID, "uuid");
        this.username = SourceFile75.verifyUsername(string);
        this.skin = sourceFile41;
        this.cloak = sourceFile412;
    }

    @SourceFile3
    public static SourceFile16 newOfflineProfile(String string) {
        return new SourceFile16(SourceFile16.offlineUUID(string), string, null, null);
    }

    @SourceFile3
    public static UUID offlineUUID(String string) {
        return UUID.nameUUIDFromBytes(SourceFile72.encodeASCII("OfflinePlayer:" + string));
    }

    @Override
    public void write(SourceFile61 sourceFile61) {
        sourceFile61.writeUUID(this.uuid);
        sourceFile61.writeString(this.username, 64);
        sourceFile61.writeBoolean(this.skin != null);
        if (this.skin != null) {
            this.skin.write(sourceFile61);
        }
        sourceFile61.writeBoolean(this.cloak != null);
        if (this.cloak != null) {
            this.cloak.write(sourceFile61);
        }
    }
}


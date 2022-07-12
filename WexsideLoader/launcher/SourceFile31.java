/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import launcher.SourceFile3;
import launcher.SourceFile75;

public final class SourceFile31 {
    @SourceFile3
    public final int onlinePlayers;
    @SourceFile3
    public final int maxPlayers;
    @SourceFile3
    public final String raw;

    public SourceFile31(int n, int n2, String string) {
        this.onlinePlayers = SourceFile75.verifyInt(n, SourceFile75.NOT_NEGATIVE, "onlinePlayers can't be < 0");
        this.maxPlayers = SourceFile75.verifyInt(n2, SourceFile75.NOT_NEGATIVE, "maxPlayers can't be < 0");
        this.raw = string;
    }

    @SourceFile3
    public boolean isOverfilled() {
        return this.onlinePlayers >= this.maxPlayers;
    }
}


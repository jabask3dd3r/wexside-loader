/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.net.InetSocketAddress;
import java.security.interfaces.RSAPublicKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import launcher.SourceFile19;
import launcher.SourceFile3;
import launcher.SourceFile30;
import launcher.SourceFile5;
import launcher.SourceFile54;
import launcher.SourceFile61;
import launcher.SourceFile75;

public final class SourceFile2
extends SourceFile19 {
    @SourceFile3
    public static final String ADDRESS_OVERRIDE_PROPERTY = "launcher.addressOverride";
    @SourceFile3
    public static final String ADDRESS_OVERRIDE = System.getProperty("launcher.addressOverride", null);
    @SourceFile3
    public final InetSocketAddress address;
    @SourceFile3
    public final RSAPublicKey publicKey;
    @SourceFile3
    public final Map runtime;

    @SourceFile3
    public SourceFile2(String string, int n, RSAPublicKey rSAPublicKey, Map map) {
        this.address = InetSocketAddress.createUnresolved(string, n);
        this.publicKey = Objects.requireNonNull(rSAPublicKey, "publicKey");
        this.runtime = Collections.unmodifiableMap(new HashMap(map));
    }

    @SourceFile3
    public SourceFile2(SourceFile5 sourceFile5) {
        String string = sourceFile5.readASCII(255);
        this.address = InetSocketAddress.createUnresolved(ADDRESS_OVERRIDE == null ? string : ADDRESS_OVERRIDE, sourceFile5.readLength(65535));
        this.publicKey = SourceFile54.toPublicRSAKey(sourceFile5.readByteArray(2048));
        int n = sourceFile5.readLength(0);
        HashMap hashMap = new HashMap(n);
        for (int i = 0; i < n; ++i) {
            String string2 = sourceFile5.readString(255);
            SourceFile75.putIfAbsent(hashMap, string2, sourceFile5.readByteArray(2048), String.format("Duplicate runtime resource: '%s'", string2));
        }
        this.runtime = Collections.unmodifiableMap(hashMap);
        if (ADDRESS_OVERRIDE != null) {
            SourceFile30.warning("Address override is enabled: '%s'", ADDRESS_OVERRIDE);
        }
    }

    @Override
    public void write(SourceFile61 sourceFile61) {
        sourceFile61.writeASCII(this.address.getHostString(), 255);
        sourceFile61.writeLength(this.address.getPort(), 65535);
        sourceFile61.writeByteArray(this.publicKey.getEncoded(), 2048);
        Set set = this.runtime.entrySet();
        sourceFile61.writeLength(set.size(), 0);
        for (Map.Entry entry : this.runtime.entrySet()) {
            sourceFile61.writeString((String)entry.getKey(), 255);
            sourceFile61.writeByteArray((byte[])entry.getValue(), 2048);
        }
    }
}


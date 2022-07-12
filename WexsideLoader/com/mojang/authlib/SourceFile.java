/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.lang3.StringUtils
 *  org.apache.commons.lang3.builder.ToStringBuilder
 */
package com.mojang.authlib;

import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class SourceFile {
    private final UUID id;
    private final String name;
    private final com.mojang.authlib.properties.SourceFile properties = new com.mojang.authlib.properties.SourceFile();
    private boolean legacy;

    public SourceFile(UUID uUID, String string) {
        if (uUID == null && StringUtils.isBlank((CharSequence)string)) {
            throw new IllegalArgumentException("Name and ID cannot both be blank");
        }
        this.id = uUID;
        this.name = string;
    }

    public SourceFile(String string, String string2) {
        this(StringUtils.isBlank((CharSequence)string) ? null : com.mojang.util.SourceFile.fromString(string), string2);
    }

    public UUID getId() {
        return this.id;
    }

    public String getId() {
        return this.id == null ? null : com.mojang.util.SourceFile.fromUUID(this.id);
    }

    public UUID getUUID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public com.mojang.authlib.properties.SourceFile getProperties() {
        return this.properties;
    }

    public boolean isComplete() {
        return this.id != null && StringUtils.isNotBlank((CharSequence)this.getName());
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        SourceFile sourceFile = (SourceFile)object;
        if (this.id != null ? !this.id.equals(sourceFile.id) : sourceFile.id != null) {
            return false;
        }
        return !(this.name != null ? !this.name.equals(sourceFile.name) : sourceFile.name != null);
    }

    public int hashCode() {
        int n = this.id != null ? this.id.hashCode() : 0;
        n = 31 * n + (this.name != null ? this.name.hashCode() : 0);
        return n;
    }

    public String toString() {
        return new ToStringBuilder((Object)this).append("id", (Object)this.id).append("name", (Object)this.name).append("properties", (Object)this.properties).append("legacy", this.legacy).toString();
    }

    public boolean isLegacy() {
        return this.legacy;
    }
}


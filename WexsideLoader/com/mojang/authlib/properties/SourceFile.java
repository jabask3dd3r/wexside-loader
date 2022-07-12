/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ForwardingMultimap
 *  com.google.common.collect.LinkedHashMultimap
 *  com.google.common.collect.Multimap
 */
package com.mojang.authlib.properties;

import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

public class SourceFile
extends ForwardingMultimap {
    private final Multimap properties = LinkedHashMultimap.create();

    protected Multimap delegate() {
        return this.properties;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javafx.application.Application
 */
package launcher;

import java.util.concurrent.atomic.AtomicReference;
import javafx.application.Application;
import launcher.SourceFile3;

@SourceFile3
public abstract class SourceFile55
extends Application {
    private static final AtomicReference INSTANCE = new AtomicReference();

    public SourceFile55() {
        INSTANCE.set(this);
    }

    public static SourceFile55 getInstance() {
        return (SourceFile55)((Object)INSTANCE.get());
    }
}


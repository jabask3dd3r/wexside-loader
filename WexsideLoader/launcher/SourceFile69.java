/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Pattern;
import launcher.SourceFile57;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class SourceFile69 {
    private static final Pattern keepErJErRy6HE = Pattern.compile(Pattern.quote("/") + '+');
    private final Pattern[] keepErJErRy6HE;

    private SourceFile69(CharSequence charSequence) {
        this.keepErJErRy6HE = (Pattern[])keepErJErRy6HE.splitAsStream(charSequence).map(Pattern::compile).toArray(Pattern[]::new);
    }

    private boolean keepErJErRy6HE(Collection collection) {
        if (this.keepErJErRy6HE.length > collection.size()) {
            return false;
        }
        Iterator iterator = collection.iterator();
        for (Pattern pattern : this.keepErJErRy6HE) {
            String string = (String)iterator.next();
            if (pattern.matcher(string).matches()) continue;
            return false;
        }
        return true;
    }

    /* synthetic */ SourceFile69(CharSequence charSequence, SourceFile57 sourceFile57) {
        this(charSequence);
    }

    static /* synthetic */ boolean keepErJErRy6HE(SourceFile69 sourceFile69, Collection collection) {
        return sourceFile69.keepErJErRy6HE(collection);
    }
}


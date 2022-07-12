/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.util.Map;
import java.util.Objects;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import launcher.SourceFile3;

public final class SourceFile75 {
    @SourceFile3
    public static final IntPredicate POSITIVE = n -> n > 0;
    @SourceFile3
    public static final IntPredicate NOT_NEGATIVE = n -> n >= 0;
    @SourceFile3
    public static final LongPredicate L_POSITIVE = l -> l > 0L;
    @SourceFile3
    public static final LongPredicate L_NOT_NEGATIVE = l -> l >= 0L;
    @SourceFile3
    public static final Predicate NOT_EMPTY = string -> !string.isEmpty();
    @SourceFile3
    public static final Pattern USERNAME_PATTERN = Pattern.compile("[a-zA-Z\u0430-\u044f\u0410-\u042f0-9_.\\-]{1,16}");

    private SourceFile75() {
    }

    @SourceFile3
    public static Object getMapValue(Map map, Object object, String string) {
        return SourceFile75.verify(map.get(object), Objects::nonNull, string);
    }

    @SourceFile3
    public static boolean isValidIDName(String string) {
        return !string.isEmpty() && string.length() <= 255 && string.chars().allMatch(SourceFile75::isValidIDNameChar);
    }

    @SourceFile3
    public static boolean isValidIDNameChar(int n) {
        return n >= 97 && n <= 122 || n >= 65 && n <= 90 || n >= 48 && n <= 57 || n == 45 || n == 95;
    }

    @SourceFile3
    public static boolean isValidUsername(CharSequence charSequence) {
        return USERNAME_PATTERN.matcher(charSequence).matches();
    }

    @SourceFile3
    public static void putIfAbsent(Map map, Object object, Object object2, String string) {
        SourceFile75.verify(map.putIfAbsent(object, object2), Objects::isNull, string);
    }

    @SourceFile3
    public static IntPredicate range(int n, int n2) {
        return n3 -> n3 >= n && n3 <= n2;
    }

    @SourceFile3
    public static Object verify(Object object, Predicate predicate, String string) {
        if (predicate.test(object)) {
            return object;
        }
        throw new IllegalArgumentException(string);
    }

    @SourceFile3
    public static double verifyDouble(double d, DoublePredicate doublePredicate, String string) {
        if (doublePredicate.test(d)) {
            return d;
        }
        throw new IllegalArgumentException(string);
    }

    @SourceFile3
    public static String verifyIDName(String string) {
        return (String)SourceFile75.verify(string, SourceFile75::isValidIDName, String.format("Invalid name: '%s'", string));
    }

    @SourceFile3
    public static int verifyInt(int n, IntPredicate intPredicate, String string) {
        if (intPredicate.test(n)) {
            return n;
        }
        throw new IllegalArgumentException(string);
    }

    @SourceFile3
    public static long verifyLong(long l, LongPredicate longPredicate, String string) {
        if (longPredicate.test(l)) {
            return l;
        }
        throw new IllegalArgumentException(string);
    }

    @SourceFile3
    public static String verifyUsername(String string) {
        return (String)SourceFile75.verify(string, SourceFile75::isValidUsername, String.format("Invalid username: '%s'", string));
    }
}


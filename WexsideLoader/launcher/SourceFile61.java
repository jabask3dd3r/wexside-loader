/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.io.Flushable;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Objects;
import java.util.UUID;
import launcher.SourceFile3;
import launcher.SourceFile72;

public final class SourceFile61
implements Flushable,
AutoCloseable {
    @SourceFile3
    public final OutputStream stream;

    @SourceFile3
    public SourceFile61(OutputStream outputStream) {
        this.stream = Objects.requireNonNull(outputStream, "stream");
    }

    @Override
    public void close() {
        this.stream.close();
    }

    @Override
    public void flush() {
        this.stream.flush();
    }

    @SourceFile3
    public void writeASCII(String string, int n) {
        this.writeByteArray(SourceFile72.encodeASCII(string), n);
    }

    @SourceFile3
    public void writeBigInteger(BigInteger bigInteger, int n) {
        this.writeByteArray(bigInteger.toByteArray(), n);
    }

    @SourceFile3
    public void writeBoolean(boolean bl) {
        this.writeUnsignedByte(bl ? 1 : 0);
    }

    @SourceFile3
    public void writeByteArray(byte[] byArray, int n) {
        this.writeLength(byArray.length, n);
        this.stream.write(byArray);
    }

    @SourceFile3
    public void writeInt(int n) {
        this.writeUnsignedByte(n >>> 24 & 0xFF);
        this.writeUnsignedByte(n >>> 16 & 0xFF);
        this.writeUnsignedByte(n >>> 8 & 0xFF);
        this.writeUnsignedByte(n & 0xFF);
    }

    @SourceFile3
    public void writeLength(int n, int n2) {
        SourceFile72.verifyLength(n, n2);
        if (n2 >= 0) {
            this.writeVarInt(n);
        }
    }

    @SourceFile3
    public void writeLong(long l) {
        this.writeInt((int)(l >> 32));
        this.writeInt((int)l);
    }

    @SourceFile3
    public void writeShort(short s) {
        this.writeUnsignedByte(s >>> 8 & 0xFF);
        this.writeUnsignedByte(s & 0xFF);
    }

    @SourceFile3
    public void writeString(String string, int n) {
        this.writeByteArray(SourceFile72.encode(string), n);
    }

    @SourceFile3
    public void writeUUID(UUID uUID) {
        this.writeLong(uUID.getMostSignificantBits());
        this.writeLong(uUID.getLeastSignificantBits());
    }

    @SourceFile3
    public void writeUnsignedByte(int n) {
        this.stream.write(n);
    }

    @SourceFile3
    public void writeVarInt(int n) {
        while (((long)n & 0xFFFFFFFFFFFFFF80L) != 0L) {
            this.writeUnsignedByte(n & 0x7F | 0x80);
            n >>>= 7;
        }
        this.writeUnsignedByte(n);
    }

    @SourceFile3
    public void writeVarLong(long l) {
        while ((l & 0xFFFFFFFFFFFFFF80L) != 0L) {
            this.writeUnsignedByte((int)l & 0x7F | 0x80);
            l >>>= 7;
        }
        this.writeUnsignedByte((int)l);
    }
}


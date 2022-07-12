/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Objects;
import java.util.UUID;
import launcher.SourceFile3;
import launcher.SourceFile72;

public final class SourceFile5
implements AutoCloseable {
    @SourceFile3
    public final InputStream stream;

    @SourceFile3
    public SourceFile5(InputStream inputStream) {
        this.stream = Objects.requireNonNull(inputStream, "stream");
    }

    @SourceFile3
    public SourceFile5(byte[] byArray) {
        this.stream = new ByteArrayInputStream(byArray);
    }

    @Override
    public void close() {
        this.stream.close();
    }

    @SourceFile3
    public String readASCII(int n) {
        return SourceFile72.decodeASCII(this.readByteArray(n));
    }

    @SourceFile3
    public BigInteger readBigInteger(int n) {
        return new BigInteger(this.readByteArray(n));
    }

    @SourceFile3
    public boolean readBoolean() {
        int n = this.readUnsignedByte();
        switch (n) {
            case 0: {
                return false;
            }
            case 1: {
                return true;
            }
        }
        throw new IOException("Invalid boolean state: " + n);
    }

    @SourceFile3
    public byte[] readByteArray(int n) {
        byte[] byArray = new byte[this.readLength(n)];
        SourceFile72.read(this.stream, byArray);
        return byArray;
    }

    @SourceFile3
    public int readInt() {
        return (this.readUnsignedByte() << 24) + (this.readUnsignedByte() << 16) + (this.readUnsignedByte() << 8) + this.readUnsignedByte();
    }

    @SourceFile3
    public int readLength(int n) {
        if (n < 0) {
            return -n;
        }
        return SourceFile72.verifyLength(this.readVarInt(), n);
    }

    @SourceFile3
    public long readLong() {
        return (long)this.readInt() << 32 | (long)this.readInt() & 0xFFFFFFFFL;
    }

    @SourceFile3
    public short readShort() {
        return (short)((this.readUnsignedByte() << 8) + this.readUnsignedByte());
    }

    @SourceFile3
    public String readString(int n) {
        return SourceFile72.decode(this.readByteArray(n));
    }

    @SourceFile3
    public UUID readUUID() {
        return new UUID(this.readLong(), this.readLong());
    }

    @SourceFile3
    public int readUnsignedByte() {
        int n = this.stream.read();
        if (n < 0) {
            throw new EOFException("readUnsignedByte");
        }
        return n;
    }

    @SourceFile3
    public int readUnsignedShort() {
        return Short.toUnsignedInt(this.readShort());
    }

    @SourceFile3
    public int readVarInt() {
        int n = 0;
        for (int i = 0; i < 32; i += 7) {
            int n2 = this.readUnsignedByte();
            n |= (n2 & 0x7F) << i;
            if ((n2 & 0x80) != 0) continue;
            return n;
        }
        throw new IOException("VarInt too big");
    }

    @SourceFile3
    public long readVarLong() {
        long l = 0L;
        for (int i = 0; i < 64; i += 7) {
            int n = this.readUnsignedByte();
            l |= (long)(n & 0x7F) << i;
            if ((n & 0x80) != 0) continue;
            return l;
        }
        throw new IOException("VarLong too big");
    }
}


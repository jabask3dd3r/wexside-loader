/*
 * Decompiled with CFR 0.152.
 */
package com.eclipsesource.json;

class SourceFile$HashIndexTable {
    private final byte[] hashTable = new byte[32];

    public SourceFile$HashIndexTable() {
    }

    public SourceFile$HashIndexTable(SourceFile$HashIndexTable sourceFile$HashIndexTable) {
        System.arraycopy(sourceFile$HashIndexTable.hashTable, 0, this.hashTable, 0, this.hashTable.length);
    }

    void add(String string, int n) {
        int n2 = this.hashSlotFor(string);
        this.hashTable[n2] = n < 255 ? (byte)(n + 1) : (byte)0;
    }

    void remove(int n) {
        for (int i = 0; i < this.hashTable.length; ++i) {
            if (this.hashTable[i] == n + 1) {
                this.hashTable[i] = 0;
                continue;
            }
            if (this.hashTable[i] <= n + 1) continue;
            int n2 = i;
            this.hashTable[n2] = (byte)(this.hashTable[n2] - 1);
        }
    }

    int get(Object object) {
        int n = this.hashSlotFor(object);
        return (this.hashTable[n] & 0xFF) - 1;
    }

    private int hashSlotFor(Object object) {
        return object.hashCode() & this.hashTable.length - 1;
    }
}


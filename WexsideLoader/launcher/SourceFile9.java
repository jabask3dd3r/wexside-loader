/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.time.Duration;
import launcher.SourceFile3;

public final class SourceFile9 {
    @SourceFile3
    public final long fileDownloaded;
    @SourceFile3
    public final long fileSize;
    @SourceFile3
    public final long totalDownloaded;
    @SourceFile3
    public final long totalSize;
    @SourceFile3
    public final String filePath;
    @SourceFile3
    public final Duration duration;

    public SourceFile9(String string, long l, long l2, long l3, long l4, Duration duration) {
        this.filePath = string;
        this.fileDownloaded = l;
        this.fileSize = l2;
        this.totalDownloaded = l3;
        this.totalSize = l4;
        this.duration = duration;
    }

    @SourceFile3
    public double getBps() {
        long l = this.duration.getSeconds();
        if (l == 0L) {
            return -1.0;
        }
        return (double)this.totalDownloaded / (double)l;
    }

    @SourceFile3
    public Duration getEstimatedTime() {
        double d = this.getBps();
        if (d <= 0.0) {
            return null;
        }
        return Duration.ofSeconds((long)((double)this.getTotalRemaining() / d));
    }

    @SourceFile3
    public double getFileDownloadedKiB() {
        return (double)this.fileDownloaded / 1024.0;
    }

    @SourceFile3
    public double getFileDownloadedMiB() {
        return this.getFileDownloadedKiB() / 1024.0;
    }

    @SourceFile3
    public double getFileDownloadedPart() {
        if (this.fileSize == 0L) {
            return 0.0;
        }
        return (double)this.fileDownloaded / (double)this.fileSize;
    }

    @SourceFile3
    public long getFileRemaining() {
        return this.fileSize - this.fileDownloaded;
    }

    @SourceFile3
    public double getFileRemainingKiB() {
        return (double)this.getFileRemaining() / 1024.0;
    }

    @SourceFile3
    public double getFileRemainingMiB() {
        return this.getFileRemainingKiB() / 1024.0;
    }

    @SourceFile3
    public double getFileSizeKiB() {
        return (double)this.fileSize / 1024.0;
    }

    @SourceFile3
    public double getFileSizeMiB() {
        return this.getFileSizeKiB() / 1024.0;
    }

    @SourceFile3
    public double getTotalDownloadedKiB() {
        return (double)this.totalDownloaded / 1024.0;
    }

    @SourceFile3
    public double getTotalDownloadedMiB() {
        return this.getTotalDownloadedKiB() / 1024.0;
    }

    @SourceFile3
    public double getTotalDownloadedPart() {
        if (this.totalSize == 0L) {
            return 0.0;
        }
        return (double)this.totalDownloaded / (double)this.totalSize;
    }

    @SourceFile3
    public long getTotalRemaining() {
        return this.totalSize - this.totalDownloaded;
    }

    @SourceFile3
    public double getTotalRemainingKiB() {
        return (double)this.getTotalRemaining() / 1024.0;
    }

    @SourceFile3
    public double getTotalRemainingMiB() {
        return this.getTotalRemainingKiB() / 1024.0;
    }

    @SourceFile3
    public double getTotalSizeKiB() {
        return (double)this.totalSize / 1024.0;
    }

    @SourceFile3
    public double getTotalSizeMiB() {
        return this.getTotalSizeKiB() / 1024.0;
    }
}


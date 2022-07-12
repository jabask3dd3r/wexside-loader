/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.util.Collections;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import launcher.SourceFile10;
import launcher.SourceFile3;
import launcher.SourceFile30;
import launcher.SourceFile71;
import launcher.SourceFile75;
import launcher.SourceFile79;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class SourceFile72 {
    @SourceFile3
    public static final Charset UNICODE_CHARSET = StandardCharsets.UTF_8;
    @SourceFile3
    public static final Charset ASCII_CHARSET = StandardCharsets.US_ASCII;
    @SourceFile3
    public static final int SOCKET_TIMEOUT = SourceFile75.verifyInt(Integer.parseInt(System.getProperty("launcher.socketTimeout", Integer.toString(10000))), SourceFile75.POSITIVE, "launcher.socketTimeout can't be <= 0");
    @SourceFile3
    public static final int HTTP_TIMEOUT = SourceFile75.verifyInt(Integer.parseInt(System.getProperty("launcher.httpTimeout", Integer.toString(5000))), SourceFile75.POSITIVE, "launcher.httpTimeout can't be <= 0");
    @SourceFile3
    public static final int BUFFER_SIZE = SourceFile75.verifyInt(Integer.parseInt(System.getProperty("launcher.bufferSize", Integer.toString(4096))), SourceFile75.POSITIVE, "launcher.bufferSize can't be <= 0");
    @SourceFile3
    public static final String CROSS_SEPARATOR = "/";
    @SourceFile3
    public static final FileSystem FS = FileSystems.getDefault();
    @SourceFile3
    public static final String PLATFORM_SEPARATOR = FS.getSeparator();
    @SourceFile3
    public static final boolean POSIX = FS.supportedFileAttributeViews().contains("posix");
    @SourceFile3
    public static final Path JVM_DIR = Paths.get(System.getProperty("java.home"), new String[0]);
    @SourceFile3
    public static final Path HOME_DIR = Paths.get(System.getProperty("user.home"), new String[0]);
    @SourceFile3
    public static final Path HOME_DIR_WIN = Paths.get(System.getProperty("user.home") + "\\AppData\\Roaming", new String[0]);
    @SourceFile3
    public static final Path WORKING_DIR = Paths.get(System.getProperty("user.dir"), new String[0]);
    private static final OpenOption[] keepErJErRy6HE = new OpenOption[]{StandardOpenOption.READ};
    private static final OpenOption[] KeePerjeRryt52 = new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING};
    private static final OpenOption[] keEPERjERryabM = new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND};
    private static final LinkOption[] keepErJErRy6HE = new LinkOption[0];
    private static final CopyOption[] keepErJErRy6HE = new CopyOption[]{StandardCopyOption.REPLACE_EXISTING};
    private static final Set keepErJErRy6HE;
    private static final Pattern keepErJErRy6HE;
    private static final Pattern KeePerjeRryt52;

    private SourceFile72() {
    }

    @SourceFile3
    public static void close(AutoCloseable autoCloseable) {
        try {
            autoCloseable.close();
        }
        catch (Throwable throwable) {
            SourceFile30.error(throwable);
        }
    }

    @SourceFile3
    public static void copy(Path path, Path path2) {
        SourceFile72.createParentDirs(path2);
        Files.copy(path, path2, keepErJErRy6HE);
    }

    @SourceFile3
    public static void createParentDirs(Path path) {
        Path path2 = path.getParent();
        if (path2 != null && !SourceFile72.isDir(path2)) {
            Files.createDirectories(path2, new FileAttribute[0]);
        }
    }

    @SourceFile3
    public static String decode(byte[] byArray) {
        return new String(byArray, UNICODE_CHARSET);
    }

    @SourceFile3
    public static String decodeASCII(byte[] byArray) {
        return new String(byArray, ASCII_CHARSET);
    }

    @SourceFile3
    public static void deleteDir(Path path, boolean bl) {
        SourceFile72.walk(path, new SourceFile79(path, bl, null), true);
    }

    @SourceFile3
    public static byte[] encode(String string) {
        return string.getBytes(UNICODE_CHARSET);
    }

    @SourceFile3
    public static byte[] encodeASCII(String string) {
        return string.getBytes(ASCII_CHARSET);
    }

    @SourceFile3
    public static boolean exists(Path path) {
        return Files.exists(path, keepErJErRy6HE);
    }

    @SourceFile3
    public static Path getCodeSource(Class clazz) {
        return Paths.get(SourceFile72.toURI(clazz.getProtectionDomain().getCodeSource().getLocation()));
    }

    @SourceFile3
    public static String getFileName(Path path) {
        return path.getFileName().toString();
    }

    @SourceFile3
    public static String getIP(SocketAddress socketAddress) {
        return ((InetSocketAddress)socketAddress).getAddress().getHostAddress();
    }

    @SourceFile3
    public static byte[] getResourceBytes(String string) {
        return SourceFile72.read(SourceFile72.getResourceURL(string));
    }

    @SourceFile3
    public static URL getResourceURL(String string) {
        URL uRL = SourceFile71.class.getResource('/' + string);
        if (uRL == null) {
            throw new NoSuchFileException(string);
        }
        return uRL;
    }

    @SourceFile3
    public static boolean hasExtension(Path path, String string) {
        return SourceFile72.getFileName(path).endsWith('.' + string);
    }

    @SourceFile3
    public static boolean isDir(Path path) {
        return Files.isDirectory(path, keepErJErRy6HE);
    }

    @SourceFile3
    public static boolean isEmpty(Path path) {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);){
            boolean bl = !directoryStream.iterator().hasNext();
            return bl;
        }
    }

    @SourceFile3
    public static boolean isFile(Path path) {
        return Files.isRegularFile(path, keepErJErRy6HE);
    }

    @SourceFile3
    public static boolean isValidFileName(String string) {
        return !string.equals(".") && !string.equals("..") && string.chars().noneMatch(n -> n == 47 || n == 92) && SourceFile72.isValidPath(string);
    }

    @SourceFile3
    public static boolean isValidPath(String string) {
        try {
            SourceFile72.toPath(string);
            return true;
        }
        catch (InvalidPathException invalidPathException) {
            return false;
        }
    }

    @SourceFile3
    public static boolean isValidTextureBounds(int n, int n2, boolean bl) {
        return n % 64 == 0 && (n2 << 1 == n || !bl && n2 == n) && n <= 1024 || bl && n % 22 == 0 && n2 % 17 == 0 && n / 22 == n2 / 17;
    }

    @SourceFile3
    public static void move(Path path, Path path2) {
        SourceFile72.createParentDirs(path2);
        Files.move(path, path2, keepErJErRy6HE);
    }

    @SourceFile3
    public static byte[] newBuffer() {
        return new byte[BUFFER_SIZE];
    }

    @SourceFile3
    public static ByteArrayOutputStream newByteArrayOutput() {
        return new ByteArrayOutputStream();
    }

    @SourceFile3
    public static char[] newCharBuffer() {
        return new char[BUFFER_SIZE];
    }

    @SourceFile3
    public static URLConnection newConnection(URL uRL) {
        URLConnection uRLConnection = uRL.openConnection();
        if (uRLConnection instanceof HttpURLConnection) {
            uRLConnection.setReadTimeout(HTTP_TIMEOUT);
            uRLConnection.setConnectTimeout(HTTP_TIMEOUT);
            uRLConnection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
        } else {
            uRLConnection.setUseCaches(false);
        }
        uRLConnection.setDoInput(true);
        uRLConnection.setDoOutput(false);
        return uRLConnection;
    }

    @SourceFile3
    public static Deflater newDeflater() {
        Deflater deflater = new Deflater(-1, true);
        deflater.setStrategy(0);
        return deflater;
    }

    @SourceFile3
    public static Inflater newInflater() {
        return new Inflater(true);
    }

    @SourceFile3
    public static InputStream newInput(URL uRL) {
        return SourceFile72.newConnection(uRL).getInputStream();
    }

    @SourceFile3
    public static InputStream newInput(Path path) {
        return Files.newInputStream(path, keepErJErRy6HE);
    }

    @SourceFile3
    public static OutputStream newOutput(Path path) {
        return SourceFile72.newOutput(path, false);
    }

    @SourceFile3
    public static OutputStream newOutput(Path path, boolean bl) {
        SourceFile72.createParentDirs(path);
        return Files.newOutputStream(path, bl ? keEPERjERryabM : KeePerjeRryt52);
    }

    @SourceFile3
    public static BufferedReader newReader(InputStream inputStream) {
        return SourceFile72.newReader(inputStream, UNICODE_CHARSET);
    }

    @SourceFile3
    public static BufferedReader newReader(InputStream inputStream, Charset charset) {
        return new BufferedReader(new InputStreamReader(inputStream, charset));
    }

    @SourceFile3
    public static BufferedReader newReader(URL uRL) {
        URLConnection uRLConnection = SourceFile72.newConnection(uRL);
        String string = uRLConnection.getContentEncoding();
        return SourceFile72.newReader(uRLConnection.getInputStream(), string == null ? UNICODE_CHARSET : Charset.forName(string));
    }

    @SourceFile3
    public static BufferedReader newReader(Path path) {
        return Files.newBufferedReader(path, UNICODE_CHARSET);
    }

    @SourceFile3
    public static Socket newSocket() {
        Socket socket = new Socket();
        SourceFile72.setSocketFlags(socket);
        return socket;
    }

    @SourceFile3
    public static BufferedWriter newWriter(OutputStream outputStream) {
        return new BufferedWriter(new OutputStreamWriter(outputStream, UNICODE_CHARSET));
    }

    @SourceFile3
    public static BufferedWriter newWriter(Path path) {
        return SourceFile72.newWriter(path, false);
    }

    @SourceFile3
    public static BufferedWriter newWriter(Path path, boolean bl) {
        SourceFile72.createParentDirs(path);
        return Files.newBufferedWriter(path, UNICODE_CHARSET, bl ? keEPERjERryabM : KeePerjeRryt52);
    }

    @SourceFile3
    public static BufferedWriter newWriter(FileDescriptor fileDescriptor) {
        return SourceFile72.newWriter(new FileOutputStream(fileDescriptor));
    }

    @SourceFile3
    public static ZipEntry newZipEntry(String string) {
        ZipEntry zipEntry = new ZipEntry(string);
        zipEntry.setTime(0L);
        return zipEntry;
    }

    @SourceFile3
    public static ZipEntry newZipEntry(ZipEntry zipEntry) {
        return SourceFile72.newZipEntry(zipEntry.getName());
    }

    @SourceFile3
    public static ZipInputStream newZipInput(InputStream inputStream) {
        return new ZipInputStream(inputStream, UNICODE_CHARSET);
    }

    @SourceFile3
    public static ZipInputStream newZipInput(URL uRL) {
        return SourceFile72.newZipInput(SourceFile72.newInput(uRL));
    }

    @SourceFile3
    public static ZipInputStream newZipInput(Path path) {
        return SourceFile72.newZipInput(SourceFile72.newInput(path));
    }

    @SourceFile3
    public static byte[] read(Path path) {
        long l = SourceFile72.readAttributes(path).size();
        if (l > Integer.MAX_VALUE) {
            throw new IOException("File too big");
        }
        byte[] byArray = new byte[(int)l];
        try (InputStream inputStream = SourceFile72.newInput(path);){
            SourceFile72.read(inputStream, byArray);
        }
        return byArray;
    }

    @SourceFile3
    public static byte[] read(URL uRL) {
        try (InputStream inputStream = SourceFile72.newInput(uRL);){
            byte[] byArray = SourceFile72.read(inputStream);
            return byArray;
        }
    }

    @SourceFile3
    public static void read(InputStream inputStream, byte[] byArray) {
        int n;
        for (int i = 0; i < byArray.length; i += n) {
            n = inputStream.read(byArray, i, byArray.length - i);
            if (n >= 0) continue;
            throw new EOFException(String.format("%d bytes remaining", byArray.length - i));
        }
    }

    @SourceFile3
    public static byte[] read(InputStream inputStream) {
        try (ByteArrayOutputStream byteArrayOutputStream = SourceFile72.newByteArrayOutput();){
            SourceFile72.transfer(inputStream, (OutputStream)byteArrayOutputStream);
            byte[] byArray = byteArrayOutputStream.toByteArray();
            return byArray;
        }
    }

    @SourceFile3
    public static BasicFileAttributes readAttributes(Path path) {
        return Files.readAttributes(path, BasicFileAttributes.class, keepErJErRy6HE);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @SourceFile3
    public static BufferedImage readTexture(Object object, boolean bl) {
        ImageReader imageReader = ImageIO.getImageReadersByMIMEType("image/png").next();
        try {
            imageReader.setInput(ImageIO.createImageInputStream(object), false, false);
            int n = imageReader.getWidth(0);
            int n2 = imageReader.getHeight(0);
            if (!SourceFile72.isValidTextureBounds(n, n2, bl)) {
                throw new IOException(String.format("Invalid texture bounds: %dx%d", n, n2));
            }
            BufferedImage bufferedImage = imageReader.read(0);
            return bufferedImage;
        }
        finally {
            imageReader.dispose();
        }
    }

    @SourceFile3
    public static String request(URL uRL) {
        return SourceFile72.decode(SourceFile72.read(uRL)).trim();
    }

    @SourceFile3
    public static InetSocketAddress resolve(InetSocketAddress inetSocketAddress) {
        if (inetSocketAddress.isUnresolved()) {
            return new InetSocketAddress(inetSocketAddress.getHostString(), inetSocketAddress.getPort());
        }
        return inetSocketAddress;
    }

    @SourceFile3
    public static Path resolveIncremental(Path path, String string, String string2) {
        Path path2;
        Path path3 = path.resolve(string + '.' + string2);
        if (!SourceFile72.exists(path3)) {
            return path3;
        }
        int n = 1;
        while (SourceFile72.exists(path2 = path.resolve(String.format("%s (%d).%s", string, n, string2)))) {
            ++n;
        }
        return path2;
    }

    @SourceFile3
    public static Path resolveJavaBin(Path path) {
        Path path2;
        Path path3 = (path == null ? JVM_DIR : path).resolve("bin");
        if (!SourceFile30.isDebugEnabled() && SourceFile72.isFile(path2 = path3.resolve("javaw.exe"))) {
            return path2;
        }
        path2 = path3.resolve("java.exe");
        if (SourceFile72.isFile(path2)) {
            return path2;
        }
        Path path4 = path3.resolve("java");
        if (SourceFile72.isFile(path4)) {
            return path4;
        }
        throw new RuntimeException("Java binary wasn't found");
    }

    @SourceFile3
    public static void setSocketFlags(Socket socket) {
        socket.setKeepAlive(false);
        socket.setTcpNoDelay(false);
        socket.setReuseAddress(true);
        socket.setSoTimeout(SOCKET_TIMEOUT);
        socket.setTrafficClass(28);
        socket.setPerformancePreferences(1, 0, 2);
    }

    @SourceFile3
    public static Path toPath(String string) {
        return Paths.get(keepErJErRy6HE.matcher(string).replaceAll(Matcher.quoteReplacement(PLATFORM_SEPARATOR)), new String[0]);
    }

    @SourceFile3
    public static String toString(Path path) {
        return KeePerjeRryt52.matcher(path.toString()).replaceAll(Matcher.quoteReplacement(CROSS_SEPARATOR));
    }

    @SourceFile3
    public static URI toURI(URL uRL) {
        try {
            return uRL.toURI();
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new IllegalArgumentException(uRISyntaxException);
        }
    }

    @SourceFile3
    public static URL toURL(Path path) {
        try {
            return path.toUri().toURL();
        }
        catch (MalformedURLException malformedURLException) {
            throw new InternalError(malformedURLException);
        }
    }

    @SourceFile3
    public static int transfer(InputStream inputStream, OutputStream outputStream) {
        int n = 0;
        byte[] byArray = SourceFile72.newBuffer();
        int n2 = inputStream.read(byArray);
        while (n2 >= 0) {
            outputStream.write(byArray, 0, n2);
            n += n2;
            n2 = inputStream.read(byArray);
        }
        return n;
    }

    @SourceFile3
    public static void transfer(Path path, OutputStream outputStream) {
        try (InputStream inputStream = SourceFile72.newInput(path);){
            SourceFile72.transfer(inputStream, outputStream);
        }
    }

    @SourceFile3
    public static int transfer(InputStream inputStream, Path path) {
        return SourceFile72.transfer(inputStream, path, false);
    }

    @SourceFile3
    public static int transfer(InputStream inputStream, Path path, boolean bl) {
        try (OutputStream outputStream = SourceFile72.newOutput(path, bl);){
            int n = SourceFile72.transfer(inputStream, outputStream);
            return n;
        }
    }

    @SourceFile3
    public static String urlDecode(String string) {
        try {
            return URLDecoder.decode(string, UNICODE_CHARSET.name());
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new InternalError(unsupportedEncodingException);
        }
    }

    @SourceFile3
    public static String urlEncode(String string) {
        try {
            return URLEncoder.encode(string, UNICODE_CHARSET.name());
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new InternalError(unsupportedEncodingException);
        }
    }

    @SourceFile3
    public static String verifyFileName(String string) {
        return (String)SourceFile75.verify(string, SourceFile72::isValidFileName, String.format("Invalid file name: '%s'", string));
    }

    @SourceFile3
    public static int verifyLength(int n, int n2) {
        if (n < 0 || n2 < 0 && n != -n2 || n2 > 0 && n > n2) {
            throw new IOException("Illegal length: " + n);
        }
        return n;
    }

    @SourceFile3
    public static BufferedImage verifyTexture(BufferedImage bufferedImage2, boolean bl) {
        return (BufferedImage)SourceFile75.verify(bufferedImage2, bufferedImage -> SourceFile72.isValidTextureBounds(bufferedImage.getWidth(), bufferedImage.getHeight(), bl), String.format("Invalid texture bounds: %dx%d", bufferedImage2.getWidth(), bufferedImage2.getHeight()));
    }

    @SourceFile3
    public static String verifyURL(String string) {
        try {
            new URL(string).toURI();
            return string;
        }
        catch (MalformedURLException | URISyntaxException exception) {
            throw new IllegalArgumentException("Invalid URL", exception);
        }
    }

    @SourceFile3
    public static URL convertToURL(String string) {
        try {
            return new URL(string);
        }
        catch (MalformedURLException malformedURLException) {
            throw new IllegalArgumentException("Invalid URL", malformedURLException);
        }
    }

    @SourceFile3
    public static void walk(Path path, FileVisitor fileVisitor, boolean bl) {
        Files.walkFileTree(path, keepErJErRy6HE, Integer.MAX_VALUE, bl ? fileVisitor : new SourceFile10(fileVisitor, null));
    }

    @SourceFile3
    public static void write(Path path, byte[] byArray) {
        SourceFile72.createParentDirs(path);
        Files.write(path, byArray, KeePerjeRryt52);
    }

    @SourceFile3
    public static OutputStream newBufferedOutStream(OutputStream outputStream) {
        return new BufferedOutputStream(outputStream);
    }

    @SourceFile3
    public static InputStream newBufferedInputStream(InputStream inputStream) {
        return new BufferedInputStream(inputStream);
    }

    static {
        keepErJErRy6HE = Collections.singleton(FileVisitOption.FOLLOW_LINKS);
        keepErJErRy6HE = Pattern.compile(CROSS_SEPARATOR, 16);
        KeePerjeRryt52 = Pattern.compile(PLATFORM_SEPARATOR, 16);
    }
}


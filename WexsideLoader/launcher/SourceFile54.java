/*
 * Decompiled with CFR 0.152.
 */
package launcher;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.security.CodeSource;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import launcher.SourceFile3;
import launcher.SourceFile63;
import launcher.SourceFile72;
import launcher.SourceFile75;
import launcher.SourceFile81;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class SourceFile54 {
    @SourceFile3
    public static final String RSA_ALGO = "RSA";
    @SourceFile3
    public static final String RSA_SIGN_ALGO = "SHA256withRSA";
    @SourceFile3
    public static final String RSA_CIPHER_ALGO = "RSA/ECB/PKCS1Padding";
    @SourceFile3
    public static final int TOKEN_LENGTH = 16;
    @SourceFile3
    public static final int RSA_KEY_LENGTH_BITS = 2048;
    @SourceFile3
    public static final int RSA_KEY_LENGTH = 256;
    @SourceFile3
    public static final int CRYPTO_MAX_LENGTH = 2048;
    @SourceFile3
    public static final String CERTIFICATE_DIGEST = "b87c079e3bf6e709860e05e283678c857b6a27916c2ba280a212f78f1a2ec20a";
    @SourceFile3
    public static final String HEX = "0123456789abcdef";
    @SourceFile3
    public static final String JWT = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.";
    private static final char[] keepErJErRy6HE = new char[]{'e', 'u', 'i', 'o', 'a'};
    private static final char[] KeePerjeRryt52 = new char[]{'r', 't', 'p', 's', 'd', 'f', 'g', 'h', 'k', 'l', 'c', 'v', 'b', 'n', 'm'};

    private SourceFile54() {
    }

    @SourceFile3
    public static byte[] digest(SourceFile63 sourceFile63, String string) {
        return SourceFile54.digest(sourceFile63, SourceFile72.encode(string));
    }

    @SourceFile3
    public static byte[] digest(SourceFile63 sourceFile63, URL uRL) {
        try (InputStream inputStream = SourceFile72.newInput(uRL);){
            byte[] byArray = SourceFile54.digest(sourceFile63, inputStream);
            return byArray;
        }
    }

    @SourceFile3
    public static byte[] digest(SourceFile63 sourceFile63, Path path) {
        try (InputStream inputStream = SourceFile72.newInput(path);){
            byte[] byArray = SourceFile54.digest(sourceFile63, inputStream);
            return byArray;
        }
    }

    @SourceFile3
    public static byte[] digest(SourceFile63 sourceFile63, byte[] byArray) {
        return SourceFile54.newDigest(sourceFile63).digest(byArray);
    }

    @SourceFile3
    public static byte[] digest(SourceFile63 sourceFile63, InputStream inputStream) {
        byte[] byArray = SourceFile72.newBuffer();
        MessageDigest messageDigest = SourceFile54.newDigest(sourceFile63);
        int n = inputStream.read(byArray);
        while (n != -1) {
            messageDigest.update(byArray, 0, n);
            n = inputStream.read(byArray);
        }
        return messageDigest.digest();
    }

    @SourceFile3
    public static KeyPair genRSAKeyPair(SecureRandom secureRandom) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA_ALGO);
            keyPairGenerator.initialize(2048, secureRandom);
            return keyPairGenerator.genKeyPair();
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new InternalError(noSuchAlgorithmException);
        }
    }

    @SourceFile3
    public static KeyPair genRSAKeyPair() {
        return SourceFile54.genRSAKeyPair(SourceFile54.newRandom());
    }

    @SourceFile3
    public static boolean isValidCertificate(Certificate certificate) {
        try {
            return SourceFile54.toHex(SourceFile54.digest(SourceFile63.SHA256, certificate.getEncoded())).equals(CERTIFICATE_DIGEST);
        }
        catch (CertificateEncodingException certificateEncodingException) {
            throw new InternalError(certificateEncodingException);
        }
    }

    @SourceFile3
    public static boolean isValidCertificates(Certificate ... certificateArray) {
        return certificateArray != null && certificateArray.length == 1 && SourceFile54.isValidCertificate(certificateArray[0]);
    }

    @SourceFile3
    public static boolean isValidCertificates(Class clazz) {
        Certificate[] certificateArray = SourceFile81.getCertificates("META-INF/MANIFEST.MF");
        if (certificateArray == null || !SourceFile54.isValidCertificates(certificateArray)) {
            return false;
        }
        CodeSource codeSource = clazz.getProtectionDomain().getCodeSource();
        return codeSource != null && SourceFile54.isValidCertificates(codeSource.getCertificates());
    }

    @SourceFile3
    public static boolean isValidSign(Path path, byte[] byArray, RSAPublicKey rSAPublicKey) {
        try (InputStream inputStream = SourceFile72.newInput(path);){
            boolean bl = SourceFile54.isValidSign(inputStream, byArray, rSAPublicKey);
            return bl;
        }
    }

    @SourceFile3
    public static boolean isValidSign(byte[] byArray, byte[] byArray2, RSAPublicKey rSAPublicKey) {
        Signature signature = SourceFile54.newRSAVerifySignature(rSAPublicKey);
        try {
            signature.update(byArray);
        }
        catch (SignatureException signatureException) {
            throw new InternalError(signatureException);
        }
        return signature.verify(byArray2);
    }

    @SourceFile3
    public static boolean isValidSign(InputStream inputStream, byte[] byArray, RSAPublicKey rSAPublicKey) {
        Signature signature = SourceFile54.newRSAVerifySignature(rSAPublicKey);
        SourceFile54.keepErJErRy6HE(inputStream, signature);
        return signature.verify(byArray);
    }

    @SourceFile3
    public static boolean isValidSign(URL uRL, byte[] byArray, RSAPublicKey rSAPublicKey) {
        try (InputStream inputStream = SourceFile72.newInput(uRL);){
            boolean bl = SourceFile54.isValidSign(inputStream, byArray, rSAPublicKey);
            return bl;
        }
    }

    @SourceFile3
    public static boolean isValidToken(CharSequence charSequence) {
        return charSequence.chars().allMatch(n -> JWT.indexOf(n) >= 0);
    }

    @SourceFile3
    public static MessageDigest newDigest(SourceFile63 sourceFile632) {
        SourceFile75.verify((Object)sourceFile632, sourceFile63 -> sourceFile63 != SourceFile63.PLAIN, "PLAIN digest");
        try {
            return MessageDigest.getInstance(sourceFile632.name);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new InternalError(noSuchAlgorithmException);
        }
    }

    @SourceFile3
    public static Cipher newRSADecryptCipher(RSAPrivateKey rSAPrivateKey) {
        return SourceFile54.keepErJErRy6HE(2, rSAPrivateKey);
    }

    @SourceFile3
    public static Cipher newRSAEncryptCipher(RSAPublicKey rSAPublicKey) {
        return SourceFile54.keepErJErRy6HE(1, rSAPublicKey);
    }

    @SourceFile3
    public static Signature newRSASignSignature(RSAPrivateKey rSAPrivateKey) {
        Signature signature = SourceFile54.keepErJErRy6HE();
        try {
            signature.initSign(rSAPrivateKey);
        }
        catch (InvalidKeyException invalidKeyException) {
            throw new InternalError(invalidKeyException);
        }
        return signature;
    }

    @SourceFile3
    public static Signature newRSAVerifySignature(RSAPublicKey rSAPublicKey) {
        Signature signature = SourceFile54.keepErJErRy6HE();
        try {
            signature.initVerify(rSAPublicKey);
        }
        catch (InvalidKeyException invalidKeyException) {
            throw new InternalError(invalidKeyException);
        }
        return signature;
    }

    @SourceFile3
    public static SecureRandom newRandom() {
        return new SecureRandom();
    }

    @SourceFile3
    public static byte[] randomBytes(Random random, int n) {
        byte[] byArray = new byte[n];
        random.nextBytes(byArray);
        return byArray;
    }

    @SourceFile3
    public static byte[] randomBytes(int n) {
        return SourceFile54.randomBytes(SourceFile54.newRandom(), n);
    }

    @SourceFile3
    public static String randomStringToken(Random random) {
        return SourceFile54.toHex(SourceFile54.randomToken(random));
    }

    @SourceFile3
    public static String randomStringToken() {
        return SourceFile54.randomStringToken(SourceFile54.newRandom());
    }

    @SourceFile3
    public static byte[] randomToken(Random random) {
        return SourceFile54.randomBytes(random, 16);
    }

    @SourceFile3
    public static byte[] randomToken() {
        return SourceFile54.randomToken(SourceFile54.newRandom());
    }

    @SourceFile3
    public static String randomUsername(Random random) {
        String string;
        String string2;
        int n = 3 + random.nextInt(7);
        int n2 = random.nextInt(7);
        if (n >= 5 && n2 == 6) {
            string2 = random.nextBoolean() ? "Mr" : "Dr";
            n -= 2;
        } else if (n >= 6 && n2 == 5) {
            string2 = "Mrs";
            n -= 3;
        } else {
            string2 = "";
        }
        int n3 = random.nextInt(7);
        if (n >= 5 && n3 == 6) {
            string = String.valueOf(10 + random.nextInt(90));
            n -= 2;
        } else if (n >= 7 && n3 == 5) {
            string = String.valueOf(1990 + random.nextInt(26));
            n -= 4;
        } else {
            string = "";
        }
        int n4 = 0;
        boolean bl = random.nextBoolean();
        char[] cArray = new char[n];
        for (int i = 0; i < cArray.length; ++i) {
            if (i > 1 && bl && random.nextInt(10) == 0) {
                cArray[i] = cArray[i - 1];
                continue;
            }
            if (n4 < 1 && random.nextInt() == 5) {
                ++n4;
            } else {
                n4 = 0;
                bl ^= true;
            }
            char[] cArray2 = bl ? KeePerjeRryt52 : keepErJErRy6HE;
            cArray[i] = cArray2[random.nextInt(cArray2.length)];
        }
        if (!string2.isEmpty() || random.nextBoolean()) {
            cArray[0] = Character.toUpperCase(cArray[0]);
        }
        return SourceFile75.verifyUsername(string2 + new String(cArray) + string);
    }

    @SourceFile3
    public static String randomUsername() {
        return SourceFile54.randomUsername(SourceFile54.newRandom());
    }

    @SourceFile3
    public static byte[] sign(InputStream inputStream, RSAPrivateKey rSAPrivateKey) {
        Signature signature = SourceFile54.newRSASignSignature(rSAPrivateKey);
        SourceFile54.keepErJErRy6HE(inputStream, signature);
        try {
            return signature.sign();
        }
        catch (SignatureException signatureException) {
            throw new InternalError(signatureException);
        }
    }

    @SourceFile3
    public static byte[] sign(byte[] byArray, RSAPrivateKey rSAPrivateKey) {
        Signature signature = SourceFile54.newRSASignSignature(rSAPrivateKey);
        try {
            signature.update(byArray);
            return signature.sign();
        }
        catch (SignatureException signatureException) {
            throw new InternalError(signatureException);
        }
    }

    @SourceFile3
    public static byte[] sign(Path path, RSAPrivateKey rSAPrivateKey) {
        try (InputStream inputStream = SourceFile72.newInput(path);){
            byte[] byArray = SourceFile54.sign(inputStream, rSAPrivateKey);
            return byArray;
        }
    }

    @SourceFile3
    public static String toHex(byte[] byArray) {
        int n = 0;
        char[] cArray = new char[byArray.length << 1];
        for (byte by : byArray) {
            int n2 = Byte.toUnsignedInt(by);
            cArray[n] = HEX.charAt(n2 >>> 4);
            cArray[++n] = HEX.charAt(n2 & 0xF);
            ++n;
        }
        return new String(cArray);
    }

    @SourceFile3
    public static RSAPrivateKey toPrivateRSAKey(byte[] byArray) {
        return (RSAPrivateKey)SourceFile54.keepErJErRy6HE().generatePrivate(new PKCS8EncodedKeySpec(byArray));
    }

    @SourceFile3
    public static RSAPublicKey toPublicRSAKey(byte[] byArray) {
        return (RSAPublicKey)SourceFile54.keepErJErRy6HE().generatePublic(new X509EncodedKeySpec(byArray));
    }

    @SourceFile3
    public static void verifyCertificates(Class clazz) {
        if (!SourceFile54.isValidCertificates(clazz)) {
            throw new SecurityException("Invalid certificates");
        }
    }

    @SourceFile3
    public static void verifySign(byte[] byArray, byte[] byArray2, RSAPublicKey rSAPublicKey) {
        if (!SourceFile54.isValidSign(byArray, byArray2, rSAPublicKey)) {
            throw new SignatureException("Invalid sign");
        }
    }

    @SourceFile3
    public static void verifySign(InputStream inputStream, byte[] byArray, RSAPublicKey rSAPublicKey) {
        if (!SourceFile54.isValidSign(inputStream, byArray, rSAPublicKey)) {
            throw new SignatureException("Invalid stream sign");
        }
    }

    @SourceFile3
    public static void verifySign(Path path, byte[] byArray, RSAPublicKey rSAPublicKey) {
        if (!SourceFile54.isValidSign(path, byArray, rSAPublicKey)) {
            throw new SignatureException(String.format("Invalid file sign: '%s'", path));
        }
    }

    @SourceFile3
    public static void verifySign(URL uRL, byte[] byArray, RSAPublicKey rSAPublicKey) {
        if (!SourceFile54.isValidSign(uRL, byArray, rSAPublicKey)) {
            throw new SignatureException(String.format("Invalid URL sign: '%s'", uRL));
        }
    }

    @SourceFile3
    public static String verifyToken(String string) {
        return (String)SourceFile75.verify(string, SourceFile54::isValidToken, String.format("Invalid token: '%s'", string));
    }

    private static Cipher keepErJErRy6HE(String string) {
        try {
            return Cipher.getInstance(string);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new InternalError(noSuchAlgorithmException);
        }
        catch (NoSuchPaddingException noSuchPaddingException) {
            throw new InternalError(noSuchPaddingException);
        }
    }

    private static Cipher keepErJErRy6HE(int n, RSAKey rSAKey) {
        Cipher cipher = SourceFile54.keepErJErRy6HE(RSA_CIPHER_ALGO);
        try {
            cipher.init(n, (Key)((Object)rSAKey));
        }
        catch (InvalidKeyException invalidKeyException) {
            throw new InternalError(invalidKeyException);
        }
        return cipher;
    }

    private static KeyFactory keepErJErRy6HE() {
        try {
            return KeyFactory.getInstance(RSA_ALGO);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new InternalError(noSuchAlgorithmException);
        }
    }

    private static Signature keepErJErRy6HE() {
        try {
            return Signature.getInstance(RSA_SIGN_ALGO);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new InternalError(noSuchAlgorithmException);
        }
    }

    private static void keepErJErRy6HE(InputStream inputStream, Signature signature) {
        byte[] byArray = SourceFile72.newBuffer();
        int n = inputStream.read(byArray);
        while (n >= 0) {
            try {
                signature.update(byArray, 0, n);
            }
            catch (SignatureException signatureException) {
                throw new InternalError(signatureException);
            }
            n = inputStream.read(byArray);
        }
    }
}


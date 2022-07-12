/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  org.apache.commons.io.Charsets
 *  org.apache.commons.io.IOUtils
 *  org.apache.commons.lang3.Validate
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package com.mojang.authlib;

import com.mojang.authlib.SourceFile7;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Map;
import javax.annotation.Nullable;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class SourceFile12
extends SourceFile7 {
    private static final Logger LOGGER = LogManager.getLogger();
    private final Proxy proxy;

    protected SourceFile12(Proxy proxy) {
        Validate.notNull((Object)proxy);
        this.proxy = proxy;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    protected HttpURLConnection createUrlConnection(URL uRL) {
        Validate.notNull((Object)uRL);
        LOGGER.debug("Opening connection to " + uRL);
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection(this.proxy);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setUseCaches(false);
        return httpURLConnection;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String performPostRequest(URL uRL, String string, String string2) {
        Validate.notNull((Object)uRL);
        Validate.notNull((Object)string);
        Validate.notNull((Object)string2);
        HttpURLConnection httpURLConnection = this.createUrlConnection(uRL);
        byte[] byArray = string.getBytes(Charsets.UTF_8);
        httpURLConnection.setRequestProperty("Content-Type", string2 + "; charset=utf-8");
        httpURLConnection.setRequestProperty("Content-Length", "" + byArray.length);
        httpURLConnection.setDoOutput(true);
        LOGGER.debug("Writing POST data to " + uRL + ": " + string);
        OutputStream outputStream = null;
        try {
            outputStream = httpURLConnection.getOutputStream();
            IOUtils.write((byte[])byArray, (OutputStream)outputStream);
        }
        finally {
            IOUtils.closeQuietly((OutputStream)outputStream);
        }
        LOGGER.debug("Reading data from " + uRL);
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            String string3 = IOUtils.toString((InputStream)inputStream, (Charset)Charsets.UTF_8);
            LOGGER.debug("Successful read, server response was " + httpURLConnection.getResponseCode());
            LOGGER.debug("Response: " + string3);
            String string4 = string3;
            return string4;
        }
        catch (IOException iOException) {
            IOUtils.closeQuietly((InputStream)inputStream);
            inputStream = httpURLConnection.getErrorStream();
            if (inputStream != null) {
                LOGGER.debug("Reading error page from " + uRL);
                String string5 = IOUtils.toString((InputStream)inputStream, (Charset)Charsets.UTF_8);
                LOGGER.debug("Successful read, server response was " + httpURLConnection.getResponseCode());
                LOGGER.debug("Response: " + string5);
                String string6 = string5;
                return string6;
            }
            LOGGER.debug("Request failed", (Throwable)iOException);
            throw iOException;
        }
        finally {
            IOUtils.closeQuietly((InputStream)inputStream);
        }
    }

    public String performGetRequest(URL uRL) {
        return this.performGetRequest(uRL, null);
    }

    public String performGetRequest(URL uRL, @Nullable String string) {
        Validate.notNull((Object)uRL);
        HttpURLConnection httpURLConnection = this.createUrlConnection(uRL);
        if (string != null) {
            httpURLConnection.setRequestProperty("Authorization", string);
        }
        LOGGER.debug("Reading data from " + uRL);
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            String string2 = IOUtils.toString((InputStream)inputStream, (Charset)Charsets.UTF_8);
            LOGGER.debug("Successful read, server response was " + httpURLConnection.getResponseCode());
            LOGGER.debug("Response: " + string2);
            String string3 = string2;
            return string3;
        }
        catch (IOException iOException) {
            IOUtils.closeQuietly((InputStream)inputStream);
            inputStream = httpURLConnection.getErrorStream();
            if (inputStream != null) {
                LOGGER.debug("Reading error page from " + uRL);
                String string4 = IOUtils.toString((InputStream)inputStream, (Charset)Charsets.UTF_8);
                LOGGER.debug("Successful read, server response was " + httpURLConnection.getResponseCode());
                LOGGER.debug("Response: " + string4);
                String string5 = string4;
                return string5;
            }
            LOGGER.debug("Request failed", (Throwable)iOException);
            throw iOException;
        }
        finally {
            IOUtils.closeQuietly((InputStream)inputStream);
        }
    }

    public static URL constantURL(String string) {
        try {
            return new URL(string);
        }
        catch (MalformedURLException malformedURLException) {
            throw new Error("Couldn't create constant for " + string, malformedURLException);
        }
    }

    public static String buildQuery(Map map) {
        if (map == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append('&');
            }
            try {
                stringBuilder.append(URLEncoder.encode((String)entry.getKey(), "UTF-8"));
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                LOGGER.error("Unexpected exception building query", (Throwable)unsupportedEncodingException);
            }
            if (entry.getValue() == null) continue;
            stringBuilder.append('=');
            try {
                stringBuilder.append(URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                LOGGER.error("Unexpected exception building query", (Throwable)unsupportedEncodingException);
            }
        }
        return stringBuilder.toString();
    }

    public static URL concatenateURL(URL uRL, String string) {
        try {
            if (uRL.getQuery() != null && uRL.getQuery().length() > 0) {
                return new URL(uRL.getProtocol(), uRL.getHost(), uRL.getPort(), uRL.getFile() + "&" + string);
            }
            return new URL(uRL.getProtocol(), uRL.getHost(), uRL.getPort(), uRL.getFile() + "?" + string);
        }
        catch (MalformedURLException malformedURLException) {
            throw new IllegalArgumentException("Could not concatenate given URL with GET arguments!", malformedURLException);
        }
    }
}


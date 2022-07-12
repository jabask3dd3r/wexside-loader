/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib.yggdrasil.response;

public class SourceFile5 {
    private String error;
    private String errorMessage;
    private String cause;

    public String getError() {
        return this.error;
    }

    public String getCause() {
        return this.cause;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    protected void setError(String string) {
        this.error = string;
    }

    protected void setErrorMessage(String string) {
        this.errorMessage = string;
    }

    protected void setCause(String string) {
        this.cause = string;
    }
}


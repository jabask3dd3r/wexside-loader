/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Multimap
 *  org.apache.commons.lang3.StringUtils
 *  org.apache.commons.lang3.Validate
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package com.mojang.authlib;

import com.google.common.collect.Multimap;
import com.mojang.authlib.SourceFile10;
import com.mojang.authlib.SourceFile11;
import com.mojang.authlib.SourceFile4;
import com.mojang.authlib.properties.SourceFile;
import com.mojang.authlib.properties.SourceFile1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class SourceFile2
implements SourceFile11 {
    private static final Logger LOGGER = LogManager.getLogger();
    protected static final String STORAGE_KEY_PROFILE_NAME = "displayName";
    protected static final String STORAGE_KEY_PROFILE_ID = "uuid";
    protected static final String STORAGE_KEY_PROFILE_PROPERTIES = "profileProperties";
    protected static final String STORAGE_KEY_USER_NAME = "username";
    protected static final String STORAGE_KEY_USER_ID = "userid";
    protected static final String STORAGE_KEY_USER_PROPERTIES = "userProperties";
    private final SourceFile10 authenticationService;
    private final SourceFile userProperties = new SourceFile();
    private String userid;
    private String username;
    private String password;
    private com.mojang.authlib.SourceFile selectedProfile;
    private SourceFile4 userType;

    protected SourceFile2(SourceFile10 sourceFile10) {
        Validate.notNull((Object)sourceFile10);
        this.authenticationService = sourceFile10;
    }

    @Override
    public boolean canLogIn() {
        return !this.canPlayOnline() && StringUtils.isNotBlank((CharSequence)this.getUsername()) && StringUtils.isNotBlank((CharSequence)this.getPassword());
    }

    @Override
    public void logOut() {
        this.password = null;
        this.userid = null;
        this.setSelectedProfile(null);
        this.getModifiableUserProperties().clear();
        this.setUserType(null);
    }

    @Override
    public boolean isLoggedIn() {
        return this.getSelectedProfile() != null;
    }

    @Override
    public void setUsername(String string) {
        if (this.isLoggedIn() && this.canPlayOnline()) {
            throw new IllegalStateException("Cannot change username whilst logged in & online");
        }
        this.username = string;
    }

    @Override
    public void setPassword(String string) {
        if (this.isLoggedIn() && this.canPlayOnline() && StringUtils.isNotBlank((CharSequence)string)) {
            throw new IllegalStateException("Cannot set password whilst logged in & online");
        }
        this.password = string;
    }

    protected String getUsername() {
        return this.username;
    }

    protected String getPassword() {
        return this.password;
    }

    @Override
    public void loadFromStorage(Map map) {
        String string;
        String string2;
        Object object;
        Object object2;
        Object object3;
        Object object4;
        this.logOut();
        this.setUsername(String.valueOf(map.get(STORAGE_KEY_USER_NAME)));
        this.userid = map.containsKey(STORAGE_KEY_USER_ID) ? String.valueOf(map.get(STORAGE_KEY_USER_ID)) : this.username;
        if (map.containsKey(STORAGE_KEY_USER_PROPERTIES)) {
            try {
                object4 = (List)map.get(STORAGE_KEY_USER_PROPERTIES);
                object3 = object4.iterator();
                while (object3.hasNext()) {
                    object2 = (Map)object3.next();
                    object = (String)object2.get("name");
                    string2 = (String)object2.get("value");
                    string = (String)object2.get("signature");
                    if (string == null) {
                        this.getModifiableUserProperties().put(object, new SourceFile1((String)object, string2));
                        continue;
                    }
                    this.getModifiableUserProperties().put(object, new SourceFile1((String)object, string2, string));
                }
            }
            catch (Throwable throwable) {
                LOGGER.warn("Couldn't deserialize user properties", throwable);
            }
        }
        if (map.containsKey(STORAGE_KEY_PROFILE_NAME) && map.containsKey(STORAGE_KEY_PROFILE_ID)) {
            object4 = new com.mojang.authlib.SourceFile(com.mojang.util.SourceFile.fromString(String.valueOf(map.get(STORAGE_KEY_PROFILE_ID))), String.valueOf(map.get(STORAGE_KEY_PROFILE_NAME)));
            if (map.containsKey(STORAGE_KEY_PROFILE_PROPERTIES)) {
                try {
                    object3 = (List)map.get(STORAGE_KEY_PROFILE_PROPERTIES);
                    object2 = object3.iterator();
                    while (object2.hasNext()) {
                        object = (Map)object2.next();
                        string2 = (String)object.get("name");
                        string = (String)object.get("value");
                        String string3 = (String)object.get("signature");
                        if (string3 == null) {
                            ((com.mojang.authlib.SourceFile)object4).getProperties().put(string2, new SourceFile1(string2, string));
                            continue;
                        }
                        ((com.mojang.authlib.SourceFile)object4).getProperties().put(string2, new SourceFile1(string2, string, string3));
                    }
                }
                catch (Throwable throwable) {
                    LOGGER.warn("Couldn't deserialize profile properties", throwable);
                }
            }
            this.setSelectedProfile((com.mojang.authlib.SourceFile)object4);
        }
    }

    @Override
    public Map saveForStorage() {
        Object object;
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        if (this.getUsername() != null) {
            hashMap.put(STORAGE_KEY_USER_NAME, this.getUsername());
        }
        if (this.getUserID() != null) {
            hashMap.put(STORAGE_KEY_USER_ID, this.getUserID());
        } else if (this.getUsername() != null) {
            hashMap.put(STORAGE_KEY_USER_NAME, this.getUsername());
        }
        if (!this.getUserProperties().isEmpty()) {
            object = new ArrayList();
            for (Object object2 : this.getUserProperties().values()) {
                Object object3 = new HashMap<String, String>();
                object3.put("name", ((SourceFile1)object2).getName());
                object3.put("value", ((SourceFile1)object2).getValue());
                object3.put("signature", ((SourceFile1)object2).getSignature());
                object.add(object3);
            }
            hashMap.put(STORAGE_KEY_USER_PROPERTIES, object);
        }
        if ((object = this.getSelectedProfile()) != null) {
            hashMap.put(STORAGE_KEY_PROFILE_NAME, ((com.mojang.authlib.SourceFile)object).getName());
            hashMap.put(STORAGE_KEY_PROFILE_ID, ((com.mojang.authlib.SourceFile)object).getId());
            ArrayList arrayList = new ArrayList();
            for (Object object3 : ((com.mojang.authlib.SourceFile)object).getProperties().values()) {
                HashMap<String, String> hashMap2 = new HashMap<String, String>();
                hashMap2.put("name", ((SourceFile1)object3).getName());
                hashMap2.put("value", ((SourceFile1)object3).getValue());
                hashMap2.put("signature", ((SourceFile1)object3).getSignature());
                arrayList.add(hashMap2);
            }
            if (!arrayList.isEmpty()) {
                hashMap.put(STORAGE_KEY_PROFILE_PROPERTIES, arrayList);
            }
        }
        return hashMap;
    }

    protected void setSelectedProfile(com.mojang.authlib.SourceFile sourceFile) {
        this.selectedProfile = sourceFile;
    }

    @Override
    public com.mojang.authlib.SourceFile getSelectedProfile() {
        return this.selectedProfile;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append("{");
        if (this.isLoggedIn()) {
            stringBuilder.append("Logged in as ");
            stringBuilder.append(this.getUsername());
            if (this.getSelectedProfile() != null) {
                stringBuilder.append(" / ");
                stringBuilder.append(this.getSelectedProfile());
                stringBuilder.append(" - ");
                if (this.canPlayOnline()) {
                    stringBuilder.append("Online");
                } else {
                    stringBuilder.append("Offline");
                }
            }
        } else {
            stringBuilder.append("Not logged in");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SourceFile10 getAuthenticationService() {
        return this.authenticationService;
    }

    @Override
    public String getUserID() {
        return this.userid;
    }

    @Override
    public SourceFile getUserProperties() {
        if (this.isLoggedIn()) {
            SourceFile sourceFile = new SourceFile();
            sourceFile.putAll((Multimap)this.getModifiableUserProperties());
            return sourceFile;
        }
        return new SourceFile();
    }

    protected SourceFile getModifiableUserProperties() {
        return this.userProperties;
    }

    @Override
    public SourceFile4 getUserType() {
        if (this.isLoggedIn()) {
            return this.userType == null ? SourceFile4.LEGACY : this.userType;
        }
        return null;
    }

    protected void setUserType(SourceFile4 sourceFile4) {
        this.userType = sourceFile4;
    }

    protected void setUserid(String string) {
        this.userid = string;
    }
}


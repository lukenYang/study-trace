package com.deep.jwt;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPublicKeySpec;

public class JKSUtil {
    private static JKSUtil instance = null;
    private final Object lock = new Object();
    private String keyStoreFile;
    private char[] password;
    private KeyStore store;

    private JKSUtil(String keyStorePath, char[] password) {
        this.keyStoreFile = keyStorePath;
        this.password = password;
    }

    public static JKSUtil getInstance() {
        if (instance == null) {
            synchronized (JKSUtil.class) {
                if (instance != null) {
                    return instance;
                }
                instance = new JKSUtil("C:\\ylh\\test.keystore", "123456".toCharArray());
            }
        }
        return instance;
    }

    public KeyPair getKeyPair(String alias) {
        return getKeyPair(alias, this.password);
    }

    public KeyPair getKeyPair(String alias, char[] password) {
        try {
            synchronized (this.lock) {
                if (this.store == null) {
                    try (InputStream is = new FileInputStream(new File(keyStoreFile))) {
                        this.store = KeyStore.getInstance("JKS");//keystore type
                        this.store.load(is, this.password);
                    }
                }
            }
            RSAPrivateCrtKey key = (RSAPrivateCrtKey) this.store.getKey(alias, password);
            RSAPublicKeySpec spec = new RSAPublicKeySpec(key.getModulus(), key.getPublicExponent());
            PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(spec);
            return new KeyPair(publicKey, key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

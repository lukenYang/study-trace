package com.deep.jwt;

import java.io.*;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

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

    //read file to get publicKey
    private static PublicKey getPublicKeyFromCrt() {
        //test2.cer  test1.crt  support both
        String crtPath = "C:/ylh/20170929/test1.crt"; // KeyTool generate
        FileInputStream in = null;
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            in = new FileInputStream(crtPath);
            Certificate crt = cf.generateCertificate(in);
            return crt.getPublicKey();
        } catch (CertificateException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        PublicKey publicKey = getPublicKeyFromCrt();
        System.out.println("publicKey：" + Base64.getEncoder().encodeToString(publicKey.getEncoded()));
        System.out.println(publicKey.getEncoded().length);
        System.out.println(Base64.getEncoder().encode(publicKey.getEncoded()).length);
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
            PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(spec);//get publicKey from privateKey,better
//            PublicKey publicKey = getPublicKeyFromCrt();//read file to get publicKey
            return new KeyPair(publicKey, key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

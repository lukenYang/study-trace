package com.deep.jwt;

import com.auth0.jwt.interfaces.RSAKeyProvider;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class DiscoveryRSAKeyProvider implements RSAKeyProvider {
    @Override
    public RSAPublicKey getPublicKeyById(String keyId) {
        return null;
    }

    @Override
    public RSAPrivateKey getPrivateKey() {
        return null;
    }

    @Override
    public String getPrivateKeyId() {
        return null;
    }
}

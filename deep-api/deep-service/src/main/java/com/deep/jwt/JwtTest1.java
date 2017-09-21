package com.deep.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.RSAKeyProvider;
import sun.security.rsa.RSAKeyPairGenerator;

import java.io.UnsupportedEncodingException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

/**
 * https://github.com/auth0/java-jwt
 */
public class JwtTest1 {

    public static void main(String[] args) {
        JwtTest1 test1 = new JwtTest1();
//        test1.hmac();
//        test1.rsa();
        test1.testKeyTool();
    }

    //Using static secrets or keys, HMAC256
    private void hmac() {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String token = JWT.create().withIssuer("issuer").withClaim("k1", "v1").sign(algorithm);
            System.out.println(token);

            JWTVerifier verifier = JWT.require(algorithm).withIssuer("issuer").build();
            DecodedJWT decodedJWT = verifier.verify(token);
            String header = decodedJWT.getHeader();
            System.out.println(header);
            System.out.println(new String(Base64.getDecoder().decode(header)));
            String payload = decodedJWT.getPayload();
            System.out.println(payload);
            System.out.println(new String(Base64.getDecoder().decode(payload)));
            System.out.println(decodedJWT.getSignature());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    //Using static secrets or keys, RSA256
    private void rsa() {
        KeyPair keyPair = getKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        System.out.println("publicKey：" + new String(Base64.getEncoder().encode(publicKey.getEncoded())));
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("privateKey：" + new String(Base64.getEncoder().encode(privateKey.getEncoded())));
        try {
            Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) publicKey, (RSAPrivateKey) privateKey);
            String token = JWT.create().withIssuer("issuer").withClaim("name", "value").sign(algorithm);
            System.out.println(token);

            //Verify a Token
            JWTVerifier verifier = JWT.require(algorithm).withIssuer("issuer").build();
//            DecodedJWT decodedJWT = verifier.verify(token.replaceFirst("3", "2"));
            DecodedJWT decodedJWT = verifier.verify(token);
            String header = decodedJWT.getHeader();
            System.out.println(header);
            System.out.println(new String(Base64.getDecoder().decode(header)));
            String payload = decodedJWT.getPayload();
            System.out.println(payload);
            System.out.println(new String(Base64.getDecoder().decode(payload)));
            System.out.println(decodedJWT.getSignature());

            //Decode a Token
//            DecodedJWT decodedJWT1 = JWT.decode(token);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (JWTCreationException e) {
            e.printStackTrace();
        }

    }

    //Using a KeyProvider:RSA256
    private void rsaProvider() {
        Algorithm algorithm = Algorithm.RSA256(getKeyProvider());
        String token = JWT.create().withIssuer("issuer").withClaim("name", "value").sign(algorithm);
        System.out.println(token);

        //Verify a Token
        JWTVerifier verifier = JWT.require(algorithm).withIssuer("issuer").build();
        DecodedJWT decodedJWT = verifier.verify(token);
    }

    //Using a java keytool
    private void testKeyTool() {
        KeyPair keyPair = JKSUtil.getInstance().getKeyPair("test1");
        PublicKey publicKey = keyPair.getPublic();
        System.out.println("publicKey：" + new String(Base64.getEncoder().encode(publicKey.getEncoded())));
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("privateKey：" + new String(Base64.getEncoder().encode(privateKey.getEncoded())));
        try {
            Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) publicKey, (RSAPrivateKey) privateKey);
            String token = JWT.create().withIssuer("issuer").withClaim("name", "value").sign(algorithm);
            System.out.println(token);

        } catch (IllegalArgumentException | JWTCreationException e) {
            e.printStackTrace();
        }
    }

    private RSAKeyProvider getKeyProvider() {
        return new DiscoveryRSAKeyProvider();
    }

    private KeyPair getKeyPair() {
        RSAKeyPairGenerator generator = new RSAKeyPairGenerator();
        return generator.generateKeyPair();
    }
}

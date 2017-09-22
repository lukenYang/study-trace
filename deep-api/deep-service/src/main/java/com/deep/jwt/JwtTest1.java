package com.deep.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.RSAKeyProvider;
import org.apache.commons.lang.StringUtils;
import sun.security.rsa.RSAKeyPairGenerator;

import java.io.*;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * https://github.com/auth0/java-jwt
 */
public class JwtTest1 {

    public static final String PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCl6ROr6AXAahejCKlL02BEZ5glEjpY4j39YvAsDnZvuFvV5SreV+L0BfEv86mDMN86miZdijSgcNtSs0VidLW1bsLLiAanNb08Sv/CNTl6Sl6UylzcR7ZB1jTQWg1rUsjlIhToW9HhAN5zHMlLGQym9f42laq5GP3EgemCP1pyeRgbzlLWUbshiGJAHfO9dZLMCLLbvUJ71yBEkqMYt5EIzP9giXgGfFqsvTE1k49fHtKr2aj1QbgnkEn/e/MZEbMqnKn7f03MKEAhXRog2+FBpvY7JN4nj1EYZs7ZtZ0TF9VcC/qO1nCJG7w4/wdAxpRXCefFmCUDZEsmBuRys/8LAgMBAAECggEAEitBLT0+jADST9dd+uDOFQ+nOMATRbKZCUuxc5Gt5LQy0mzDUhAb2Y9hB1hOwwAyIg/JjcrZ0owpaJgbTBnt4E2d5X4jBGK9M4IfGhyMC9ljHDZBDxqHWhRkOkDyYUNynq0pzvxnMpXOxpprbN70ZMBhs4aWaKjU+ZUkhk/7zrdIv3eTq1Cao/fuWiDBy+7HBkwgXnK2epvgid53MrccCPV5H0/7EVTOETNvmYmKcfJw/k1pZAT38m1YBGj1CCXyYOtPdSgs3Bs27emHECgCcBN56vLQueK9+5jIU7iVu0tWpns8wEzTbpn+w8KJTVWggd1ppOLjZckcutzZ00SWqQKBgQDm4KPIA0y03KAkwk85Q9SpBvDF4MoaQb5KFvMHtMd1KqDjdgcphVSsbJJ5uuwOqc10xvtjUVV61r8TrjUp4xgGDFUSX++p1HKEwdfUkMk9zUugv2bI/6sdSOF5tbK+k1x61riQBrVitr3QWan4Vk/J6fBgxBNhy6oK+DDymt2CpwKBgQC39rRvin5ozbcKX/vjgY/4v5hP6C9Ma4Wx1w2uQMrg+Z6kEv1+3Hk0+WFw2r4wbzs32ANFsj/HV7DqWajlort8SqDApYamtEGXPENItoWdoyiBTlhCAMfr0Ubp5nLkEVUOMcq46gV0kgD9QI575AvJsfr54wCPr9gfk/jyloMg/QKBgB2/O9r9cdirxIZ38rUyJChTGJqmR+PyLI5nPpDzne9eurQT9QBIiYxdwNGmX9vTzQEK0kENrbHSEXR7saXf+Kxu0lc3vS1ojgjE4QYmUYeA+AmSH7AuIOH5DfQckRc07Wl2WPlVo/FAElzR8LBqjoU5exs8qDKlhxc6uzPG+FtpAoGBAK6SR1GdvC1aIbuPsCmJtoTX1ALoE5JSanGD4TCdvahWWKvcdYAgWkjh6gy9F0RBGZH5w8ksyIczeOg6oyMfFQlyjC+kJC4n2iJZBoSG6C7aOMLUBL7FnPH0C3ZEwHwa0nsA1x44vWqMbrHkxBFfK6x/3+mn981ikhYNRm12VQNFAoGANHUz+ViWMWnVP8C/Q/SEnfzLdAKRCFu3xzQCAifOeeo/5McRTR2VSLa4ghNARMREEE8p1Y1p8i9lKrAwEISFMQdEd+O9UE08A1gQJHElMQIf6sPC67T0DnZZSSKuawpSmYucWbjjyqF1dWQwYW8BKcPFDhDxy8slE8BgLNz4sNQ=";

    public static void main(String[] args) {
        JwtTest1 test1 = new JwtTest1();
//        test1.hmac();
//        test1.rsa();
//        test1.testKeyTool();
        test1.StringPrivateKey();
    }

    //Using static secrets or keys, HMAC256
    private void hmac() {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String token = JWT.create().withKeyId("publicId").withIssuer("issuer").withClaim("k1", "v1").sign(algorithm);
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
            String token = JWT.create().withKeyId("publicId").withIssuer("issuer").withClaim("name", "value").sign(algorithm);
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
        String token = JWT.create().withKeyId("publicId").withIssuer("issuer").withClaim("name", "value").sign(algorithm);
        System.out.println(token);

        //Verify a Token
        JWTVerifier verifier = JWT.require(algorithm).withIssuer("issuer").build();
        DecodedJWT decodedJWT = verifier.verify(token);
    }

    //http://www.360doc.com/content/16/0919/13/9200790_591987035.shtml
    public static PrivateKey getPrivateKeyFromString(String algorithm, String privateKey) {
        PrivateKey privateKeyFromX509 = null;
        try {
            privateKeyFromX509 = getPrivateKeyFromPKCS8(algorithm, new ByteArrayInputStream(privateKey.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return privateKeyFromX509;
    }

    public static PrivateKey getPrivateKeyFromPKCS8(String algorithm, String privateKey) throws Exception {
        if (!StringUtils.isEmpty(privateKey) && !StringUtils.isEmpty(algorithm)) {
            KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
            byte[] decodeKey = Base64.getDecoder().decode(privateKey.getBytes());
            return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decodeKey));
        } else {
            return null;
        }
    }

    private RSAKeyProvider getKeyProvider() {
        return new DiscoveryRSAKeyProvider();
    }

    private KeyPair getKeyPair() {
        RSAKeyPairGenerator generator = new RSAKeyPairGenerator();
        return generator.generateKeyPair();
    }

    //Using a java keytool
    private void testKeyTool() {
        KeyPair keyPair = JKSUtil.getInstance().getKeyPair("test1");
        PublicKey publicKey = keyPair.getPublic();
        System.out.println("publicKey：" + new String(Base64.getEncoder().encode(publicKey.getEncoded())));
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("privateKey：" + new String(Base64.getEncoder().encode(privateKey.getEncoded())));
        try {
            PrivateKey privateKeyFromString = getPrivateKeyFromPKCS8("RSA", PRIVATE_KEY);
            System.out.println("privateKeyFromString：" + new String(Base64.getEncoder().encode(privateKeyFromString.getEncoded())));
            Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) publicKey, (RSAPrivateKey) privateKey);
            String token = JWT.create().withKeyId("publicId").withIssuer("issuer").withClaim("name", "value").sign(algorithm);
            System.out.println(token);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Using String key
    private void StringPrivateKey() {
        try {
            PrivateKey privateKey = getPrivateKeyFromPKCS8("RSA", PRIVATE_KEY);
            RSAPrivateCrtKey rsaPrivateCrtKey = (RSAPrivateCrtKey) privateKey;
            System.out.println("privateKey：" + new String(Base64.getEncoder().encode(privateKey.getEncoded())));
            RSAPublicKeySpec spec = new RSAPublicKeySpec(rsaPrivateCrtKey.getModulus(), rsaPrivateCrtKey.getPublicExponent());
            PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(spec);//get publicKey from privateKey
            System.out.println("publicKey：" + new String(Base64.getEncoder().encode(publicKey.getEncoded())));
            Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) publicKey, (RSAPrivateKey) privateKey);
            String token = JWT.create().withKeyId("publicId").withIssuer("issuer").withClaim("name", "value").sign(algorithm);
            System.out.println(token);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PrivateKey getPrivateKeyFromX509(String algorithm, InputStream ins) throws Exception {
        if (ins != null && !StringUtils.isEmpty(algorithm)) {
            KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
            byte[] encodedKey = readText(ins);
            encodedKey = Base64.getDecoder().decode(encodedKey);
            return keyFactory.generatePrivate(new X509EncodedKeySpec(encodedKey));
        } else {
            return null;
        }
    }

    public static PrivateKey getPrivateKeyFromPKCS8(String algorithm, InputStream ins) throws Exception {
        if (ins != null && !StringUtils.isEmpty(algorithm)) {
            KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
            byte[] encodedKey = readText(ins);
            encodedKey = Base64.getDecoder().decode(encodedKey);
            return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
        } else {
            return null;
        }
    }

    public static byte[] readText(InputStream ins) throws IOException {
        Reader reader = new InputStreamReader(ins);
        StringWriter writer = new StringWriter();
        io(reader, writer, -1);
        return writer.toString().getBytes();
    }

    public static void io(Reader in, Writer out, int bufferSize) throws IOException {
        if (bufferSize == -1) {
            bufferSize = 4096;
        }

        char[] buffer = new char[bufferSize];

        int amount;
        while ((amount = in.read(buffer)) >= 0) {
            out.write(buffer, 0, amount);
        }

    }
}

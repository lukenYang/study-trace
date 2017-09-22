package com.deep.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.lang.StringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class StringKeyTest {

    private static final String PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCl6ROr6AXAahejCKlL02BEZ5glEjpY4j39YvAsDnZvuFvV5SreV+L0BfEv86mDMN86miZdijSgcNtSs0VidLW1bsLLiAanNb08Sv/CNTl6Sl6UylzcR7ZB1jTQWg1rUsjlIhToW9HhAN5zHMlLGQym9f42laq5GP3EgemCP1pyeRgbzlLWUbshiGJAHfO9dZLMCLLbvUJ71yBEkqMYt5EIzP9giXgGfFqsvTE1k49fHtKr2aj1QbgnkEn/e/MZEbMqnKn7f03MKEAhXRog2+FBpvY7JN4nj1EYZs7ZtZ0TF9VcC/qO1nCJG7w4/wdAxpRXCefFmCUDZEsmBuRys/8LAgMBAAECggEAEitBLT0+jADST9dd+uDOFQ+nOMATRbKZCUuxc5Gt5LQy0mzDUhAb2Y9hB1hOwwAyIg/JjcrZ0owpaJgbTBnt4E2d5X4jBGK9M4IfGhyMC9ljHDZBDxqHWhRkOkDyYUNynq0pzvxnMpXOxpprbN70ZMBhs4aWaKjU+ZUkhk/7zrdIv3eTq1Cao/fuWiDBy+7HBkwgXnK2epvgid53MrccCPV5H0/7EVTOETNvmYmKcfJw/k1pZAT38m1YBGj1CCXyYOtPdSgs3Bs27emHECgCcBN56vLQueK9+5jIU7iVu0tWpns8wEzTbpn+w8KJTVWggd1ppOLjZckcutzZ00SWqQKBgQDm4KPIA0y03KAkwk85Q9SpBvDF4MoaQb5KFvMHtMd1KqDjdgcphVSsbJJ5uuwOqc10xvtjUVV61r8TrjUp4xgGDFUSX++p1HKEwdfUkMk9zUugv2bI/6sdSOF5tbK+k1x61riQBrVitr3QWan4Vk/J6fBgxBNhy6oK+DDymt2CpwKBgQC39rRvin5ozbcKX/vjgY/4v5hP6C9Ma4Wx1w2uQMrg+Z6kEv1+3Hk0+WFw2r4wbzs32ANFsj/HV7DqWajlort8SqDApYamtEGXPENItoWdoyiBTlhCAMfr0Ubp5nLkEVUOMcq46gV0kgD9QI575AvJsfr54wCPr9gfk/jyloMg/QKBgB2/O9r9cdirxIZ38rUyJChTGJqmR+PyLI5nPpDzne9eurQT9QBIiYxdwNGmX9vTzQEK0kENrbHSEXR7saXf+Kxu0lc3vS1ojgjE4QYmUYeA+AmSH7AuIOH5DfQckRc07Wl2WPlVo/FAElzR8LBqjoU5exs8qDKlhxc6uzPG+FtpAoGBAK6SR1GdvC1aIbuPsCmJtoTX1ALoE5JSanGD4TCdvahWWKvcdYAgWkjh6gy9F0RBGZH5w8ksyIczeOg6oyMfFQlyjC+kJC4n2iJZBoSG6C7aOMLUBL7FnPH0C3ZEwHwa0nsA1x44vWqMbrHkxBFfK6x/3+mn981ikhYNRm12VQNFAoGANHUz+ViWMWnVP8C/Q/SEnfzLdAKRCFu3xzQCAifOeeo/5McRTR2VSLa4ghNARMREEE8p1Y1p8i9lKrAwEISFMQdEd+O9UE08A1gQJHElMQIf6sPC67T0DnZZSSKuawpSmYucWbjjyqF1dWQwYW8BKcPFDhDxy8slE8BgLNz4sNQ=";
    private static final String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApekTq+gFwGoXowipS9NgRGeYJRI6WOI9/WLwLA52b7hb1eUq3lfi9AXxL/OpgzDfOpomXYo0oHDbUrNFYnS1tW7Cy4gGpzW9PEr/wjU5ekpelMpc3Ee2QdY00FoNa1LI5SIU6FvR4QDecxzJSxkMpvX+NpWquRj9xIHpgj9acnkYG85S1lG7IYhiQB3zvXWSzAiy271Ce9cgRJKjGLeRCMz/YIl4BnxarL0xNZOPXx7Sq9mo9UG4J5BJ/3vzGRGzKpyp+39NzChAIV0aINvhQab2OyTeJ49RGGbO2bWdExfVXAv6jtZwiRu8OP8HQMaUVwnnxZglA2RLJgbkcrP/CwIDAQAB";

    public static void main(String[] args) {
        try {
            PrivateKey privateKey = getPrivateKey("RSA", PRIVATE_KEY);
            PublicKey publicKey = getPublicKey("RSA", PUBLIC_KEY);
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
            exportPrivateKey(PRIVATE_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static PrivateKey getPrivateKey(String algorithm, String privateKey) throws Exception {
        if (!StringUtils.isEmpty(privateKey) && !StringUtils.isEmpty(algorithm)) {
            KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
            byte[] decodeKey = Base64.getDecoder().decode(privateKey.getBytes());
            return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decodeKey));
        } else {
            return null;
        }
    }

    public static PublicKey getPublicKey(String algorithm, String publicKey) throws Exception {
        if (!StringUtils.isEmpty(publicKey) && !StringUtils.isEmpty(algorithm)) {
            KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
            byte[] decodeKey = Base64.getDecoder().decode(publicKey.getBytes());
            return keyFactory.generatePublic(new X509EncodedKeySpec(decodeKey));
        } else {
            return null;
        }
    }

    public static void exportPrivateKey(String privateKey) {
        String file = "C:\\ylh\\privateKey.pem";
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("-- privateKey begin --\n");
            writer.write(privateKey);
            writer.write("\n");
            writer.write("-- privateKey end --");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

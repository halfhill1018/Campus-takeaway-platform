package com.graduation.campustakeawayplatform.common.jwt;

/**
 * @Author HuangShen
 * @Date 2024/1/12 13:31
 * @Describe
 */
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JwtUtil {

    private static final String SECRET = "JwtSecretKey"; // 用于签名的密钥，请替换成你自己的密钥
    private static final long EXPIRATION_TIME = 864_000_000; // 10天，以毫秒为单位

    /**
     * 生成JWT Token
     *
     * @param subject 用户ID或其他标识
     * @return JWT Token
     */
    public static String generateToken(String subject) {
        Date issuedAt = new Date();
        Date expiration = new Date(issuedAt.getTime() + EXPIRATION_TIME);

        return JWT.create()
                .withSubject(subject)
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiration)
                .sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * 验证JWT Token，并获取其中的信息
     *
     * @param token JWT Token
     * @return 包含在Token中的信息
     * @throws JWTDecodeException 如果解码失败
     */
    public static String verifyToken(String token) throws JWTDecodeException {
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token);

        return decodedJWT.getSubject();
    }

    /**
     * 示例用法
     */
    public static void main(String[] args) {
        // 生成Token
        String token = generateToken("userId123");
        System.out.println("Generated Token: " + token);

        // 验证Token
        try {
            String userId = verifyToken(token);
            System.out.println("User ID from Token: " + userId);
        } catch (JWTDecodeException e) {
            System.out.println("Invalid Token: " + e.getMessage());
        }
    }
}


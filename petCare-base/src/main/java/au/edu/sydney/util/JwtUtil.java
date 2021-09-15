package au.edu.sydney.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Chris
 * @date 2021-09-14 19:1
 */
@Component
@ConfigurationProperties(prefix = "pet-care.jwt.config")
public class JwtUtil {

    private String secretKey;

    //unit second
    private long expires = 60*60*24*7;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public long getExpires() {
        return expires;
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }

    /**
     * create JWT
     * @param id
     */
    public String createJWT(String id, String subject, Boolean isLogin) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder().setId(id)
                .setSubject(subject)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .claim("isLogin", isLogin);
        if (expires > 0) {
            // expires乘以1000是毫秒转秒
            builder.setExpiration(new Date(nowMillis + expires*1000));
        }
        return builder.compact();
    }

    /**
     * parse JWT
     * @param jwtToken
     */
    public Claims parseJWT(String jwtToken){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken).getBody();
    }

}


package org.example.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthClass{
    private final String SECRET="my-super-long-secret-key-1234567890!";

    public String createToken(String login){
        return Jwts
                .builder()
                .setSubject(login)
                .setIssuedAt(new Date())
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .setExpiration(new Date(System.currentTimeMillis() +900000))
                .claim("ROLE","USER")
                .compact();
    }
    public String getLogin(String token){
        return  Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public Boolean authJwt(String token){
        try{
            Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(SECRET.getBytes()))
                    .build()
                    .parseClaimsJwt(token);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}

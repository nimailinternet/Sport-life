package org.example.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class AuthClass{
    private final String SECRET="dfdsfdfsdfsdfdsf";
    public String createToken(String login){
        return Jwts
                .builder()
                .setSubject(login)
                .setIssuedAt(new Date())
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .claim("ROLE","USER")
                .compact();
    }
    public String getLogin(String token){
        return  Jwts.parserBuilder()
                .setSigningKey(SECRET)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public Boolean authJwt(String token){
        try{
            Jwts.parserBuilder()
                    .setSigningKey(SECRET)
                    .build()
                    .parseClaimsJwt(token);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}

package com.example.eurekauser.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.core.codec.ByteArrayEncoder;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;

@Component
public class JwtTokenUtil {
    byte[] secretKey;

    public  Claims claims(String token){

        return  Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();

    }
    public Boolean validateAccessToken(String token){
         try {
             Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
             return  true;
         }
         catch (JwtException e){
              return  false;
         }
    }


}

package com.portfolio.miportfolio.jwt;

import com.portfolio.miportfolio.entity.UsuarioPrincipal;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private final static Logger logger = (Logger) LoggerFactory.getLogger(JwtProvider.class);
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    public String generateToken(Authentication authententicacion) {
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authententicacion.getPrincipal();
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration *1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    public String getNombreUsuarioFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
     public Boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            logger.error("Token aml formado");
        }
        catch (UnsupportedJwtException e){
            logger.error("Token no soportakdo");
        }
        catch (ExpiredJwtException e){
            logger.error("Token expirado");
        }
        catch (IllegalArgumentException e){
            logger.error("Token vacio");
        }
        catch (SignatureException e){
            logger.error("Firma no válida");
        }
        return false;
     }
}

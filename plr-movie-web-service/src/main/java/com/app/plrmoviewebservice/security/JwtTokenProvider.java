package com.app.plrmoviewebservice.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenProvider.class);
    @Value("${app.jwtSecret}")
    private String jwtSecret;

    public boolean validateToken(String jwt, HttpServletRequest request) {
        LOGGER.debug("JwtTokenProvider -> validate token invoked!");
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwt);
            return true;
        } catch (SignatureException ex) {
            LOGGER.error("Invalid JWT signature!");
        } catch (MalformedJwtException ex) {
            LOGGER.error("Invalid JWT token!");
        } catch (ExpiredJwtException ex) {
            LOGGER.error("Expired JWT token!");
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("Unsupported JWT token!");
        } catch (IllegalArgumentException ex) {
            LOGGER.error("JWT claims string is empty!");
        }
        return false;
    }
}

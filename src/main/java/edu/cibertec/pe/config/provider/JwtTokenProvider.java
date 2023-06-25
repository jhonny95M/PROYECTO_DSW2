package edu.cibertec.pe.config.provider;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {
  
	static final byte[] secretKeyBytes = Keys.secretKeyFor(SignatureAlgorithm.HS512).getEncoded();
	public static final String SECRET_KEY = "FxMh+BnmeEZwb1vUgiH4lZag7OE4kvNb9Ig6ALyCp0vP5iongvbzZ/NX4juX23sCcZyuQqhFRdZ+tVSujm+HbQ==";//Base64.getEncoder().encodeToString(secretKeyBytes);
	//private static final String SECRET_KEY = Base64.getEncoder().encodeToString(secretKeyBytes);
	private static final long EXPIRATION_TIME = 86400000; // 24 horas en milisegundos
  
	@SuppressWarnings("deprecation")
	public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);
        
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
            //.signWith(SignatureAlgorithm.HS512, SignatureAlgorithm.HS256)
            .compact();
    }
  
    @SuppressWarnings("deprecation")
	public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException | ExpiredJwtException |UnsupportedJwtException | IllegalArgumentException ex) {
            return false;
        }
    }
  
    public String getUsernameFromToken(String token) {
        @SuppressWarnings("deprecation")
		Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}


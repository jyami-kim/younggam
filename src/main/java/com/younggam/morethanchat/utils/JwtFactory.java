package com.younggam.morethanchat.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import com.younggam.morethanchat.domain.ProviderUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
public class JwtFactory {

    public static final String HEADER_PREFIX = "EROMTHAN";
    @Value("${JWT.tokenIssuer}")
    private String tokenIssuer;
    @Value("${JWT.tokenIssuer}PASSWORD")
    private String passTokenIssuer;
    @Value("${JWT.tokenSigningKey}")
    private String tokenSigningKey;

    public String generatePasswordToken(ProviderUser providerUser) {
        String token;

        token = JWT.create()
                .withIssuer(passTokenIssuer)
                .withClaim("ID", providerUser.getId())
                .sign(Algorithm.HMAC256(tokenSigningKey));

        log.info("passWordChangeToken -- " + token);

        return token;
    }

    public String generateToken(ProviderUser providerUser) {
        String token;

        token = JWT.create()
                .withIssuer(tokenIssuer)
                .withClaim("ID", providerUser.getId())
                .withClaim("NAME", providerUser.getEmail())
                .sign(Algorithm.HMAC256(tokenSigningKey));

        log.info("token -- " + token);

        return token;
    }

    public Optional<Long> getUserId(String token) {
        if (StringUtils.isEmpty(token)) {
            return Optional.empty();
        }
        try {
            return decodeToken(token);
        } catch (NumberFormatException ex) {
            return Optional.empty();
        }
    }

    private Optional<Long> decodeToken(String header) {

        String token;
        try {
            token = tokenExtractor(header);
        } catch (IllegalArgumentException ex) {
            log.warn("Failed to extract token from header. header:" + header, ex);
            return Optional.empty();
        }

        DecodedJWT decodedJWT;
        try {
            Verification verification = JWT.require(Algorithm.HMAC256(tokenSigningKey));
            JWTVerifier verifier = verification.build();
            decodedJWT = verifier.verify(token);
        } catch (Exception e) {
            return Optional.empty();
        }

        Map<String, Claim> claims = decodedJWT.getClaims();
        Claim idClaim = claims.get("ID");
        if (idClaim == null) {
            log.warn("Failed to decode jwt token. header:" + header);
            return Optional.empty();
        }
        return Optional.of(idClaim.asLong());
    }

    private String tokenExtractor(String header) {
        if (StringUtils.isEmpty(header)) {
            throw new IllegalArgumentException("Authorization header가 없습니다.");
        }

        if (header.length() < HEADER_PREFIX.length()) {
            throw new IllegalArgumentException("authorization header size가 옳지 않습니다. header의 길이는 " + HEADER_PREFIX.length() + " 보다 크거나 같아야 합니다.");
        }

        if (!header.startsWith(HEADER_PREFIX)) {
            throw new IllegalArgumentException("올바른 header형식이 아닙니다.");
        }

        return header.substring(HEADER_PREFIX.length());
    }

}

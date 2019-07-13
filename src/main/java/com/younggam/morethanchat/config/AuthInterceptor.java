package com.younggam.morethanchat.config;

import com.younggam.morethanchat.utils.JwtFactory;
import com.younggam.morethanchat.utils.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequiredArgsConstructor
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    private final JwtFactory jwtFactory;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info(request.getHeader("Authorization"));

        String token = request.getHeader("Authorization");
        Long providerId = this.jwtFactory.getUserId(token)
                .orElseThrow(() -> new AuthException(ResponseMessage.AUTH));

        request.setAttribute("providerId", providerId);

        return super.preHandle(request, response, handler);
    }

}


package com.younggam.morethanchat.interceptor;

import com.younggam.morethanchat.exception.UnauthorizedException;
import com.younggam.morethanchat.utils.JwtFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

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
                .orElseThrow(UnauthorizedException::new);

        request.setAttribute("providerId", providerId);

        return super.preHandle(request, response, handler);
    }

}


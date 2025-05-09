package org.template.template.common.filter;

import jakarta.servlet.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.template.template.common.model.DefaultUserInfo;
import org.template.template.common.utils.JwtUtils;

import java.io.IOException;
import java.util.Collections;

@Slf4j
@Component
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String jwt = resolveToken(request);

        if (jwt != null) {
            try {
                DefaultUserInfo userInfo = JwtUtils.parse(jwt);

                Authentication auth = new UsernamePasswordAuthenticationToken(userInfo, null, Collections.emptyList());

                SecurityContextHolder.getContext().setAuthentication(auth);

            } catch (Exception e) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            }
        }
        filterChain.doFilter(request, response);
    }

    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }

        return null;
    }
}

package com.example.learningSpring.filter;

import com.example.learningSpring.model.dto.request.LoginRequest;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

/**
 * @author Shirali Alihummatov
 */
@Component
public class AuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // gelen tokeni yoxlayacagiq
        String authorization = request.getHeader("Authorization");

        if (Objects.isNull(authorization) || !authorization.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authorization.substring(7);
//        String token = null.substring(7); ---> NullPointer Exception


        // tokeni extract edib icindeki datalari check edeceyik
    }

}

package com.example.pos_api.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
@RequiredArgsConstructor
public class jwtAuthFilter extends OncePerRequestFilter {


    private final jwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader(AUTHORIZATION);
        final String username;
        final String jwtToken;

        if (authHeader == null || !authHeader.startsWith("Bearer")) {
            filterChain.doFilter(request, response); // No token, proceed to next filter
            return;
        }

        // Extract token from the header
        jwtToken = authHeader.substring(7);
        username = jwtUtils.extractUsername(jwtToken); // Extract username from the token

        // If the username is not null and the authentication is not already set
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Validate the token (this will check if the token is valid and not expired)
            if (jwtUtils.isTokenValid(jwtToken, username)) {
                // You can set authorities/roles if needed, e.g., based on JWT claims or a static role
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, null, null);
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Set the authentication in the security context
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response); // Proceed to next filter in the chain
    }
}

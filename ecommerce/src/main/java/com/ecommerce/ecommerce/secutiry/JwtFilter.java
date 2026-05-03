package com.ecommerce.ecommerce.security;

import com.ecommerce.ecommerce.domain.user.User;
import com.ecommerce.ecommerce.domain.user.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserRepository repository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String header =
                request.getHeader("Authorization");

        if (header == null ||
                !header.startsWith("Bearer ")) {

            filterChain.doFilter(
                    request,
                    response
            );
            return;
        }

        String token =
                header.replace("Bearer ", "");

        try {

            String email =
                    jwtService.getEmail(token);

            Optional<User> optionalUser =
                    repository.findByEmail(email);

            if (optionalUser.isPresent()) {

                User user =
                        optionalUser.get();

                String role =
                        user.getRole();

                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(
                                user.getEmail(),
                                null,
                                AuthorityUtils.createAuthorityList(
                                        "ROLE_" + role
                                )
                        );

                SecurityContextHolder
                        .getContext()
                        .setAuthentication(auth);
            }

        } catch (Exception e) {

            response.setStatus(
                    HttpServletResponse.SC_UNAUTHORIZED
            );
            return;
        }

        filterChain.doFilter(
                request,
                response
        );
    }
}
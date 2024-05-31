//package com.fdr.jo_project.security;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import com.auth0.jwt.JWTVerifier;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletOutputStream;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.GrantedAuthority;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//
//
//public class JWTAuthorizationFilter extends OncePerRequestFilter {
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String jwt = request.getHeader("Authorization");
//        System.out.println("JWT = " + jwt);
//
//        if (jwt == null || jwt.startsWith(SecParams.PREFIX)) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SecParams.SECRET)).build();
//
//        jwt = jwt.substring(SecParams.PREFIX.length());
//
//        DecodedJWT decodedJWT = verifier.verify(jwt);
//
//        String username = decodedJWT.getSubject();
//
//        List<String> roles = decodedJWT.getClaims().get("roles").asList(String.class);
//
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//
//        for (String r : roles)
//            authorities.add(new SimpleGrantedAuthority(r));
//
//        UsernamePasswordAuthenticationToken user =
//                new UsernamePasswordAuthenticationToken(username, null, authorities);
//
//        SecurityContextHolder.getContext().setAuthentication(user);
//        filterChain.doFilter(request, response);
//    }
//}

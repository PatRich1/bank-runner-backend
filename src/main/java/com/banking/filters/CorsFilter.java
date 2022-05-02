package com.banking.filters;

import com.banking.props.CorsConfigurationProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@Component
public class CorsFilter extends OncePerRequestFilter {

    @Autowired
    private CorsConfigurationProps props;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        response.addHeader("Access-Control-Allow-Origin", String.join(",", props.getAllowedOrigins()));
        response.setHeader("Access-Control-Allow-Methods", String.join(",", props.getAllowedMethods()));
        response.setHeader("Access-Control-Allow-Credentials", Boolean.toString(props.isAllowCredentials()));
        response.setHeader("Access-Control-Allow-Headers", String.join(",", props.getAllowedHeaders()));

        filterChain.doFilter(request, response);
    }
}

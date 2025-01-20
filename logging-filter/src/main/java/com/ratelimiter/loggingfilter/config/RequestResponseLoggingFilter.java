package com.ratelimiter.loggingfilter.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class RequestResponseLoggingFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // Log Request
        logger.info("Request Method: {}, URI: {}", request.getMethod(), request.getRequestURI());

        // Wrap the request and response to allow for multiple reads
        CachedBodyHttpServletRequest wrappedRequest = new CachedBodyHttpServletRequest(request);
        CachedBodyHttpServletResponse wrappedResponse = new CachedBodyHttpServletResponse(response);

        // Log request body
        String requestBody = new String(wrappedRequest.getBody(), request.getCharacterEncoding());
        logger.info("Request Body: {}", requestBody);

        // Proceed with the filter chain
        filterChain.doFilter(wrappedRequest, wrappedResponse);

        // Log Response Body
        String responseBody = new String(wrappedResponse.getBody(), response.getCharacterEncoding());
        logger.info("Response Body: {}", responseBody);

        // Write the captured content back to the original response
        wrappedResponse.flushBuffer();
    }

}

package com.github.football.exception;

import com.github.football.exception.error.ErrorCode;
import com.github.football.exception.error.ErrorResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ExceptionHandlerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (FootBallException e) {
            ErrorCode errorCode = e.getErrorCode();
            ErrorResponse errorResponse =
                    new ErrorResponse(errorCode.getStatus(), errorCode.getMessage());
            response.setStatus(errorCode.getStatus());
            response.setContentType("application/json");
            response.getWriter().write(errorResponse.toString());
        }
    }
}

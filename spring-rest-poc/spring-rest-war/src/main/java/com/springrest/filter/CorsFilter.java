package com.springrest.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;

        // response.setHeader("Access-Control-Allow-Origin", "*");
        // response.setHeader("Access-Control-Allow-Methods", "POST, GET,
        // OPTIONS, DELETE");
        // response.setHeader("Access-Control-Max-Age", "3600");
        // response.setHeader("Access-Control-Allow-Headers",
        // "x-requested-with");

        String acrHeaders = request.getHeader("Access-Control-Request-Headers");
        String acrMethod = request.getHeader("Access-Control-Request-Method");

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", acrHeaders);
        response.setHeader("Access-Control-Allow-Methods", acrMethod);
        response.setHeader("Content-Type", "application/x-www-form-urlencoded");

        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
    }

}

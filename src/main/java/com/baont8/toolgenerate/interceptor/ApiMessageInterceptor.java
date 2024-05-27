package com.baont8.toolgenerate.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ApiMessageInterceptor implements HandlerInterceptor{

    public static String langCode = "en";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // Get value param language
        String lang = ((request.getParameter("lang") != null) && !request.getParameter("lang").isEmpty()) 
        		? request.getParameter("lang") : "en";

        // Invoke init method init language to get message error depend language
        langCode = lang;

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}

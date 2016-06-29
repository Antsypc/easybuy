package com.gentlemen.easybuy.interceptor;

/**
 * @author ants_ypc
 * @version 1.0 6/29/16
 */

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ants_ypc
 * @version 1.0 6/12/16
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
    private static final String[] exclude = new String[] {
            "/profile","/logging",""
    };
    private static final String[] resource = new String[]{
            "/assets", "/error-pages","/logging"
    };

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String user = "/" + request.getSession().getAttribute("identity");
        String servletPath = request.getServletPath();
        System.out.println(user);
        System.out.println(servletPath);
        for (String s : exclude) {
            if (s.equals(servletPath)) return true;
        }
        for (String s : resource) {
            if (servletPath.startsWith(s)) return true;
        }
        if (servletPath.startsWith(user)) {
            return true;
        } else {
            response.sendError(404);
            return false;
        }
    }
}

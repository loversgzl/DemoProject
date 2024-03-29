package com.light.aop.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.servlet.*;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
/**
 * @Author light
 * @Date 2023/6/25
 * @Desc 过滤器 实现一
 * 在Spring Boot中实现过滤器有两种方式：
 * 一种是通过实现javax.servlet.Filter接口，
 * 另一种是通过实现org.springframework.web.filter.OncePerRequestFilter抽象类
 **/

public class LogFilter implements Filter {

    /**
     * 功能：我们创建一个LogFilter类来记录请求日志
     * 实现1、首先，创建一个类并实现javax.servlet.Filter接口，并实现其中的doFilter方法。
     * 实现2、在Spring Boot应用程序中注册这个过滤器，通过创建一个FilterRegistrationBean对象来注册这个过滤器，就是需要把过滤器放到一个bean中。
     * 这个过滤器我是在application中注册的。
     * */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();
        System.out.println("第一个拦截器打印，请求：" + requestURI);
        // 需要注意：doFilter方法中必须调用 chain.doFilter 方法来继续执行后续的过滤器或请求处理程序。
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // 销毁
    }
}

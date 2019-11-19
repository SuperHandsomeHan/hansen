package edu.nf.hansen.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Achine
 * @date 2019/11/8
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 调用controller方法之前先执行
     * @param request
     * @param response
     * @param handler 目标控制器实例
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截方法");
        HttpSession session = request.getSession();
        if(session.getAttribute("userInfo") == null){
            //重定向到登陆页面
            response.sendRedirect("/login.html");
            //返回false，阻止后面的方法执行
            return false;
        }
        return true;
    }

    /**
     * 在调用controller方法之后，但未返回ModelAndView时执行
     * 注意：只有在preHandle方法返回true的情况下才会执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 返回ModelAndView之后执行
     * 注意：这个方法只有在preHandle方法返回true的情况下才会被调用
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

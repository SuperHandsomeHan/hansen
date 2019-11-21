package edu.nf.hansen.controller.interceptor;

import com.google.gson.Gson;
import edu.nf.hansen.controller.vo.ResponseVO;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Achine
 * @date 2019/11/11
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        if(req.getSession().getAttribute("userInfo") == null){
            if("XMLHttpRequest".equals(req.getHeader("X-Requested-With"))) {
                ResponseVO vo = new ResponseVO();
                vo.setCode(401);
                resp.setContentType("application/json;charset=utf-8");
                String json = new Gson().toJson(vo);
                resp.getWriter().println(json);
            }else {
                String root = req.getContextPath();
                resp.sendRedirect(root+"/login.html");
            }
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

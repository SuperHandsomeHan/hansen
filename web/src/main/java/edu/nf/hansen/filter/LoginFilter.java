package edu.nf.hansen.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nf.hansen.controller.vo.ResponseVO;
import com.google.gson.Gson;

/**
 * 
 * @author Achine
 *
 */
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		if(req.getSession().getAttribute("userInfo") != null) {
			chain.doFilter(request, response);
		}else {
			if("XMLHttpRequest".equals(req.getHeader("X-Requested-With"))) {
				ResponseVO vo = new ResponseVO();
				vo.setCode(401);
				resp.setContentType("application/json;charset=utf-8");
				String json = new Gson().toJson(vo);
				response.getWriter().println(json);
			}else {
				String root = req.getContextPath();
				resp.sendRedirect(root+"/login.html");
			}
			
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}

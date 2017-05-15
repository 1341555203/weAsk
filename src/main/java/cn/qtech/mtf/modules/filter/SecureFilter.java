package cn.qtech.mtf.modules.filter;



import cn.qtech.mtf.modules.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mtf81 on 2017/4/9.
 */
@WebFilter(filterName = "secureFilter",urlPatterns = "/user")
public class SecureFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;
		HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;
		String servletPath=httpServletRequest.getServletPath();

		System.out.println(servletPath);

		if(servletPath.startsWith("/login")||servletPath.startsWith("/signUp")||servletPath.startsWith("/success")||servletPath.startsWith("loginAjax")){
			filterChain.doFilter(servletRequest,servletResponse);
		}
		else {
			User user=(User)httpServletRequest.getSession().getAttribute("currentUser");
			if(user==null){
				httpServletResponse.sendRedirect("/login");
			}else {
				filterChain.doFilter(servletRequest,servletResponse);
			}

		}
	}

	@Override
	public void destroy() {

	}
}

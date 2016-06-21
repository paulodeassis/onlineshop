package de.java2enterprise.onlineshop;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/register")
public class SecurityFilter implements Filter {
	public void destroy(){}
	
	public void doFilter(ServletRequest request,ServletResponse response, FilterChain filterchain) throws IOException, ServletException{
		String code = request.getParameter("code");
		if("supergeheim123".equals(code)){
			filterchain.doFilter(request, response);
		}else{
			final String remoteAdd = request.getRemoteAddr();
			final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			final String requestURI = httpServletRequest.getRequestURI();
			final ServletContext servletcontext = request.getServletContext();
			servletcontext.log("Warning: immproper access by remote address "+remoteAdd+" on "+requestURI);
			final RequestDispatcher dispatcher = request.getRequestDispatcher("signedout.html");
			dispatcher.forward(request, response);
		}
	}
	
	public void init(FilterConfig filterconfig) throws ServletException {}

}

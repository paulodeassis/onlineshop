package de.java2enterprise.onlineshop;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(
		urlPatterns={"/sell", "/buy"},
		filterName="LoggingFilter",
		description="Logging bei bestimmten Zugriffen"
		)
public class LoggingFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
			throws IOException, ServletException {
		ServletContext servletcontext = request.getServletContext();
		servletcontext.log("LoggingFilter");
		filterchain.doFilter(request, response);
				
	}

	public void init(FilterConfig filterconfig) throws ServletException {
				
	}
	
}

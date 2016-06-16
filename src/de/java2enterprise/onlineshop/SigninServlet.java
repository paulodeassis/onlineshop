package de.java2enterprise.onlineshop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SigninServlet
 */
@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		final String email=request.getParameter("email");
		final String password=request.getParameter("password");
		
		String cookie_email=null;
		String cookie_password=null;
		
		ServletOutputStream out = response.getOutputStream();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>Cookie-Name</td>");
		out.println("<td>Cookie-Value</td>");
		out.println("</tr>");
		
		Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie : cookies){
			String name=cookie.getName();
			String value=cookie.getValue();
			
			out.println("<tr>");
			out.println("<td>"+name+"</td>");
			out.println("<td>"+value+"</td>");
			out.println("</tr>");
			
			if("email".equals(name)){
				cookie_email=value;
			}else if("password".equals(name)){
				cookie_password=value;
			}
		}
		out.println("</table>");
		
		if(email.equals(cookie_email) && password.equals(cookie_password)){
			out.println("<h1>Benutzer ist nicht valide!");
		}else{
			out.println("<h1>Benutzer ist nicht valide!</h1>");
		}
		out.println("</body>");
		out.println("</html>");
	}

}

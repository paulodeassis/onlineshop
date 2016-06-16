package de.java2enterprise.onlineshop;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JdbcServlet
 */
/*@WebServlet("/JdbcServlet")*/
public class JdbcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletConfig config = getServletConfig();
		String jdbc_properties = config.getInitParameter("jdbc_properties");
		ServletContext application = getServletContext();
		final InputStream in = application.getResourceAsStream(jdbc_properties);
		final Properties p = new Properties();
		p.load(in);
		
		response.setContentType("text/hmtl;charset=UTF-8");
		
		/*out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("<br>driver: "+p.getProperty("driver"));
		out.println("<br>url: "+p.getProperty("url"));
		out.println("<br>password: "+p.getProperty("password"));
		out.println("</body>");
		out.println("</html>");
		*/
		/*final String driver = getInitParameter("driver");
		final String url = getInitParameter("url");
		final String username = getInitParameter("username");
		final String password = getInitParameter("password");*/
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html");
		out.println("<html>");
		out.println("<body>");
		out.println("<br>Driver: "+p.getProperty("driver"));
		out.println("<br>url: "+p.getProperty("url"));
		out.println("<br>username: "+p.getProperty("username"));
		out.println("<br>password: "+p.getProperty("password"));
		out.println("</body>");
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
		/*ServletConfig config = getServletConfig();
		String jdbc_properties = config.getInitParameter("jdbc_properties");
		ServletContext application = getServletContext();
		final InputStream in = application.getResourceAsStream(jdbc_properties);
		final Properties p = new Properties();
		p.load(in);
		
		response.setContentType("text/hmtl;charset=UTF-8");
		
		final PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("<br>driver: "+p.getProperty("driver"));
		out.println("<br>url: "+p.getProperty("url"));
		out.println("<br>password: "+p.getProperty("password"));
		out.println("</body>");
		out.println("</html>");*/
	}

}

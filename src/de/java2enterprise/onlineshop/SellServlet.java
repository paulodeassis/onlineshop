package de.java2enterprise.onlineshop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class SellServlet
 */
@WebServlet("/sell")
@MultipartConfig(
		maxFileSize=1024*1024*10,
		maxRequestSize=1024*1024*30,
		fileSizeThreshold=1024*1024,
		location="C:\tmp")

public class SellServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath()+" is alive");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String title=request.getParameter("title");
		final String description=request.getParameter("description");
		final String price = request.getParameter("price");
		
		final Part part = request.getPart("foto");
		
		OutputStream outputstream = null;
		InputStream inputstream = null;
		
		try{
			String path = "C:\\tmp"+part.getSubmittedFileName();
			File file = new File(path);
			outputstream = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			int i=0;
			inputstream = part.getInputStream();
			while((i=inputstream.read(buffer))!= -1){
				outputstream.write(buffer, 0, i);
			}
		}catch(Exception ex){
			throw new ServletException(
					ex.getMessage());
		}finally{
			outputstream.close();
			inputstream.close();
		}
		
		PrintWriter out = response.getWriter();
		
		
		out.println("<!DOCTYPE html");
		out.println("<html>");
		out.println("<body>");
		out.println("<br>Hochgeladener Artikel: "+title);
		out.println("<br>Beschreibung: "+description);
		out.println("<br>Preis "+price);
		out.println("<br>Bild "+part.getSubmittedFileName());
		out.println("</body>");
		out.println("</html>");
		
	}
	
	protected long PermitedFileSize() throws IOException{
		ServletConfig config = getServletConfig();
		String general_properties = config.getInitParameter("general.properties");
		ServletContext application  = getServletContext();
		final InputStream in=application.getResourceAsStream(general_properties);
		final Properties property = new Properties();
		property.load(in);
		long maximalFileSize=Long.parseLong(property.getProperty("sellMaximalFileSize"));
		
		return maximalFileSize;
		
	}
}

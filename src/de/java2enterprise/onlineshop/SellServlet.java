package de.java2enterprise.onlineshop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.AsyncContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class SellServlet
 */
@WebServlet( urlPatterns="/sell", 
			 asyncSupported=true)
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
		final AsyncContext asyncron = request.startAsync();
			
		ServletInputStream inputstream = request.getInputStream();
		inputstream.setReadListener(new FotoReadListener(asyncron));
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

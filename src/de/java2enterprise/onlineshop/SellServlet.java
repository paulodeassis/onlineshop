package de.java2enterprise.onlineshop;

import java.io.IOException;

import javax.servlet.AsyncContext;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		FotoReadListener fotoReadListener = new FotoReadListener(asyncron);
		inputstream.setReadListener(fotoReadListener);
	}
}

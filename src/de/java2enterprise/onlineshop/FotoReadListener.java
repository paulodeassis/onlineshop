package de.java2enterprise.onlineshop;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.InputStream;

import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


public class FotoReadListener implements ReadListener {
	private AsyncContext async;
	
	public FotoReadListener(AsyncContext ac){
		this.async=ac;
	}
	
	@Override
	public void onDataAvailable(){
		final HttpServletRequest request = (HttpServletRequest)async.getRequest();
		final HttpServletResponse response = (HttpServletResponse)async.getResponse();
		
		OutputStream outputstream = null;
		InputStream inputstream = null;
		PrintWriter out = null;
		try{
			final Part part = request.getPart("foto");
			outputstream = new FileOutputStream(part.getSubmittedFileName());
			inputstream = part.getInputStream();
			out = response.getWriter();
			byte[] buffer = new byte[1024];
			int i = 0;
			while((i=inputstream.read(buffer))!=-1){
				outputstream.write(buffer, 0, i);
			}
			outputstream.flush();
			out.write("true");
			async.complete();
		}catch(Exception ex){
			out.write("false");
			ex.printStackTrace();
		}finally{
			try{
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onAllDataRead(){
		async.complete();
	}
	
	@Override
	public void onError(Throwable ex){
		ex.printStackTrace();
		async.complete();
	}
}

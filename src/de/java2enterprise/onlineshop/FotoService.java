package de.java2enterprise.onlineshop;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class FotoService implements Runnable {
private AsyncContext async;

public FotoService(AsyncContext ac){
	this.async=ac;
}
@Override
public void run(){
	final HttpServletRequest request = (HttpServletRequest)async.getRequest();
	final HttpServletResponse response = (HttpServletResponse)async.getResponse();
	
	OutputStream outputstream = null;
	InputStream inputstream = null;	
	PrintWriter out = null;
	
	try{
		
		final Part part = request.getPart("foto");
		String novaURL="C:\\tmp\\"+ part.getName();
		outputstream = new FileOutputStream(novaURL);
		inputstream = part.getInputStream();
		
		byte[] buffer  = new byte[1024];
		int i = 0;
		while((i = inputstream.read(buffer))!=-1){
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

}


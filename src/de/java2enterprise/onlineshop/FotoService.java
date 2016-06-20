package de.java2enterprise.onlineshop;

import java.io.InputStream;
import java.io.OutputStream;

public class FotoService implements Runnable {
private InputStream inputstream;
private OutputStream outputstream;

public FotoService(InputStream is, OutputStream os){
	this.inputstream=is;
	this.outputstream=os;
}
@Override
public void run(){
	try{
		byte[] buffer = new byte[1024];
		int i=0;
			while((i=inputstream.read(buffer))!=-1){
				outputstream.write(buffer, 0, i);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				outputstream.close();
				inputstream.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}

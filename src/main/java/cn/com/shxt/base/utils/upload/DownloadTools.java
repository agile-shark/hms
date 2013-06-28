package cn.com.shxt.base.utils.upload;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadTools {
	public static boolean downloadIE(HttpServletResponse response,String fileName,String filePath,String old) throws Exception{
		boolean flag = false;
		File file = new File(filePath+"\\"+fileName);//
		System.out.println(file.exists()+"--file_path:--"+filePath+"\\"+fileName);
		if(file.exists()){
			System.out.println();
			
		    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		    byte[] buffer = new byte[1];
		    response.reset();
		    response.setCharacterEncoding("UTF-8");
		    response.setContentType("application/x-rar-compressed");
		    old=URLEncoder.encode(old, "UTF-8").replace("+", "%20").length()>100?URLEncoder.encode(old, "UTF-8").replace("+", "%20").substring(0,100)+"."+old.substring(old.lastIndexOf(".")+1):URLEncoder.encode(old, "UTF-8").replace("+", "%20");
		    response.setHeader("Content-disposition", "attachment;filename="+old);
		    OutputStream os = response.getOutputStream();
		    while(bis.read(buffer) > 0){
		     os.write(buffer);
		    }
		    bis.close();
		    os.close();
		    flag = true;
		}
		return flag;
	}
	public static boolean download(HttpServletRequest request,HttpServletResponse response,String fileName,String filePath,String old) throws Exception{
		boolean flag = false;
		File file = new File(filePath+"\\"+fileName);//
		System.out.println("--file_path:--"+filePath+"\\"+fileName);
		if(file.exists()){
				String agent=request.getHeader("User-Agent");
				String type="";
				
			    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			    byte[] buffer = new byte[1];
			    response.reset();
			    response.setCharacterEncoding("UTF-8");
			    response.setContentType("application/x-rar-compressed");
			    if(agent.indexOf("MSIE 7")>0){
			    	old=URLEncoder.encode(old, "UTF-8").replace("+", "%20").length()>100?URLEncoder.encode(old, "UTF-8").replace("+", "%20").substring(0,100)+"."+old.substring(old.lastIndexOf(".")+1):URLEncoder.encode(old, "UTF-8").replace("+", "%20");
				    response.setHeader("Content-disposition", "attachment;filename="+old);}
				else if(agent.indexOf("Firefox")>0){
					response.setHeader("Content-disposition", "attachment;filename*="+URLEncoder.encode(old, "utf-8").replace("+", "%20"));
				}else{
					response.setHeader("Content-disposition", "attachment;filename="+URLEncoder.encode(old, "utf-8").replace("+", "%20"));
				}
			    OutputStream os = response.getOutputStream();
			    while(bis.read(buffer) > 0){
			     os.write(buffer);
			    }
			    bis.close();
			    os.close();
			    flag = true;
		}
		return flag;
	}
}

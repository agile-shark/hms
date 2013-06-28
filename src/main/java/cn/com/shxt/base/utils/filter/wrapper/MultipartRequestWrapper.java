package cn.com.shxt.base.utils.filter.wrapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FilenameUtils;

import cn.com.shxt.base.utils.io.FileHelper;



public class MultipartRequestWrapper extends HttpServletRequestWrapper {
	Map<String,String[]> params = new HashMap<String,String[]>();
	
	List<Map<String,String>>  fileList = new ArrayList<Map<String, String>>();
	
	/**默认值*/
	public static String PATH = "C:\\upload";

	public MultipartRequestWrapper(HttpServletRequest request) {
		super(request);
		setParams(request);
	}
	
	private void setParams(HttpServletRequest request) {
		try {
			
			//1、判断是否是multipart类型
			boolean isMul = ServletFileUpload.isMultipartContent(request);
			if(isMul) {
				
				//获取上传路径
				PATH = request.getSession().getServletContext().getRealPath(File.separator+"upload");
				
				File file = new File(PATH);
			
				if(!file.isDirectory()){
					//如果目录不存在,则新建目录
					file.mkdirs();
				}
				
				
				ServletFileUpload upload = new ServletFileUpload();
				FileItemIterator iter = upload.getItemIterator(request);
				InputStream is = null;
				while(iter.hasNext()) {
					FileItemStream fis = iter.next();
					is = fis.openStream();
					if(fis.isFormField()) {
						setFormParam(fis.getFieldName(),is);
					} else {
						//要输入流中有数据才进行上传操作
						if(is.available()>0) {
							int size = is.available();
							
							//对于IE而言，上传的文件或获取完整的绝对路径，此时就需要仅仅获取绝对路径中的文件名
							String fname = FilenameUtils.getName(fis.getName());
							//System.out.println("上传的文件名:"+fname);
							String sname = FileHelper.generateFileName(fis.getName());
							//System.out.println("改变后的文件名:"+sname);
							//完成文件上传，并且自动关闭流
							
							Streams.copy(is,new FileOutputStream(PATH+File.separator+sname),true);
							//fis.getFieldName表示获取表单域的名称，getName表示获取文件的名称
							setFormParam(fis.getFieldName(),fname,sname,size);
							
						}
					}
				}
			} else {
				//如果不是multipart直接通过请求获取值
				params = request.getParameterMap();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setFormParam(String fieldName, InputStream is) throws IOException {
		if(params.containsKey(fieldName)) {
			//说明表单域中已经存在了值，这个时候就需要往params的String的数组中添加
			String[] values = params.get(fieldName);
			//让数组长度加1
			values = Arrays.copyOf(values, values.length+1);
			//添加到数组中
			values[values.length-1] = Streams.asString(is,"UTF-8");
			
			params.put(fieldName, values);
		} else {
			
			params.put(fieldName, new String[]{Streams.asString(is,"UTF-8")});
		}
	}
	private void setFormParam(String fieldName,String fname,String sname,int size) throws IOException {
		if(params.containsKey(fieldName)) {
			//说明表单域中已经存在了值，这个时候就需要往params的String的数组中添加
			String[] values = params.get(fieldName);
			//让数组长度加1
			values = Arrays.copyOf(values, values.length+1);
			//添加到数组中
			values[values.length-1] = fname;
			
			String[] valuesc = params.get(fieldName+"_c");
			//让数组长度加1
			valuesc = Arrays.copyOf(valuesc, valuesc.length+1);
			//添加到数组中
			valuesc[valuesc.length-1] = sname;
			
			
			String[] sizes = params.get(fieldName+"_s");
			//让数组长度加1
			sizes = Arrays.copyOf(sizes, sizes.length+1);
			//添加到数组中
			sizes[sizes.length-1] =String.valueOf(FileHelper.FormetFileSize(size));
			
			
			
			
			params.put(fieldName, values);
			params.put(fieldName+"_c", valuesc);
			params.put(fieldName+"_s", sizes);
			
		} else {
			
			params.put(fieldName, new String[]{fname});
			params.put(fieldName+"_c", new String[]{sname});
			params.put(fieldName+"_s", new String[]{String.valueOf(FileHelper.FormetFileSize(size))});
			
		}
	}

	@Override
	public Map<String,String[]> getParameterMap() {
		return params;
	}
	
	@Override
	public String getParameter(String name) {
		String[] values = params.get(name);
		if(values!=null) {
			return values[0];
		}
		return null;
	}
	
	@Override
	public String[] getParameterValues(String name) {
		String[] values = params.get(name);
		if(values!=null) {
			return values;
		}
		return null;
	}

}

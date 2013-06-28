package cn.com.shxt.base.utils.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;


/**
 * @author 刘文铭
 * @日期 2012 2012-12-3 下午3:58:21
 * @描述 文件上传帮助类
 * 
 */
public class UploadTools {

	public static Map<String, Object> uploadFile(HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		// upload的真实路径
		String path = request.getSession().getServletContext()
		        .getRealPath(File.separator + "upload");
		//String path = "D:"+File.separator+"upload";
		// 判断目录是否存在
		File forlder = new File(path);
		if (!forlder.isDirectory()) {
			forlder.mkdirs();
		}

		// 上传的临时目录
		String temppath = request.getSession().getServletContext()
		        .getRealPath(File.separator + "temp");
		File tempforlder = new File(temppath);
		if (!tempforlder.isDirectory()) {
			tempforlder.mkdirs();
		}
		// 1.检测是否是文件上传的请求
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {

			// 2.创建DiskFileItemFactory 实例[获得磁盘文件条目工厂]
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 当文件大小超过300k时，就在磁盘上建立临时文件
			factory.setSizeThreshold(300000);
			// 设计文件上传的临时目录
			factory.setRepository(tempforlder);

			// 3.创建ServletFileUpload类的实例，，使用DiskFileItemFactory
			// 对象做为参数[高水平的API文件上传处理 ]
			ServletFileUpload upload = new ServletFileUpload(factory);// 需要注意，还有带参构造方法
			// 文件大小不能超过20M
			upload.setSizeMax(20 * 1024 * 1024);
			// 单个文件不能超过5M
			upload.setFileSizeMax(5*1024 * 1024);

			// 声明输入输出流
			InputStream is = null;
			// 输出流
			OutputStream os = null;

			try {
				// 4.解析请求对象中所有的表单项,返回一个列表
				FileItemIterator iter = upload.getItemIterator(request);
				// 5.遍历 迭代器
				while (iter.hasNext()) {
					FileItemStream item = iter.next();
					// 取得表单空间的name对应的值
					String name = item.getFieldName();
					is = item.openStream();
					// 判断表单是否普通表单
					if (item.isFormField()) {
						//存储普通表单的值
						map.put(name, Streams.asString(is,"UTF-8"));
					} else {
						// 将文件以流的方式上传到服务器
						// 构建一个输出流，目的是将用户上传的文件以输出流的方式写入到应程序上下文的upload文件夹中
						String realName = FileHelper.getRealFileName(item
				                .getName());
						String saveName = FileHelper.generateFileName(realName);
						
						os = new FileOutputStream(
						        new File(path, saveName));
						map.put("realName", realName);
						map.put("saveName", saveName);
						map.put("fileSize", FileHelper.FormetFileSize(is.available()));
						

						// 将输入流里的内容写入到输出流中，目的是在程序上下文的upload文件夹中创建用户上传的文件
						// 流的输入输出 要借助于缓冲区，即使用字节数组,1024为缓冲区大小-->1024byte
						byte[] buf = new byte[1024];
						// length代表读取的字节数量
						int length = 0;
						while ((length = is.read(buf)) > 0) {
							os.write(buf, 0, length);
						}
					}

				}

			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (is != null)
						is.close();

					if (os != null)
						os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		
		return map;
	}
	
	public static Map<String, Object> uploadFileBatch(HttpServletRequest request) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		//存普通控件
		List<Map<String,Object>> filedList = new ArrayList<Map<String,Object>>();
		//存文件
		List<Map<String,Object>> fileList = new ArrayList<Map<String,Object>>();

		// upload的真实路径
		String path = request.getSession().getServletContext()
		        .getRealPath(File.separator + "upload");
		// 判断目录是否存在
		File forlder = new File(path);
		if (!forlder.isDirectory()) {
			forlder.mkdirs();
		}

		// 上传的临时目录
		String temppath = request.getSession().getServletContext()
		        .getRealPath(File.separator + "temp");
		File tempforlder = new File(temppath);
		if (!tempforlder.isDirectory()) {
			tempforlder.mkdirs();
		}
		// 1.检测是否是文件上传的请求
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {

			// 2.创建DiskFileItemFactory 实例[获得磁盘文件条目工厂]
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 当文件大小超过300k时，就在磁盘上建立临时文件
			factory.setSizeThreshold(300000);
			// 设计文件上传的临时目录
			factory.setRepository(tempforlder);

			// 3.创建ServletFileUpload类的实例，，使用DiskFileItemFactory
			// 对象做为参数[高水平的API文件上传处理 ]
			ServletFileUpload upload = new ServletFileUpload(factory);// 需要注意，还有带参构造方法
			// 文件大小不能超过20M
			upload.setSizeMax(20 * 1024 * 1024);
			// 单个文件不能超过5M
			upload.setFileSizeMax(5*1024 * 1024);

			// 声明输入输出流
			InputStream is = null;
			// 输出流
			OutputStream os = null;

			try {
				// 4.解析请求对象中所有的表单项,返回一个列表
				FileItemIterator iter = upload.getItemIterator(request);
				// 5.遍历 迭代器
				while (iter.hasNext()) {
					
					FileItemStream item = iter.next();
					// 取得表单空间的name对应的值
					String name = item.getFieldName();
					is = item.openStream();
					// 判断表单是否普通表单
					if (item.isFormField()) {
						//存储普通表单的值
						HashMap<String, Object> map = new HashMap<String, Object>();
						map.put(name, Streams.asString(is,"UTF-8"));
						filedList.add(map);
					} else {
						
						HashMap<String, Object> map = new HashMap<String, Object>();
						
						// 将文件以流的方式上传到服务器
						// 构建一个输出流，目的是将用户上传的文件以输出流的方式写入到应程序上下文的upload文件夹中
						String realName = FileHelper.getRealFileName(item
				                .getName());
						String saveName = FileHelper.generateFileName(realName);
						
						os = new FileOutputStream(
						        new File(path, saveName));
						map.put("realName", realName);
						map.put("saveName", saveName);
						map.put("fileSize", FileHelper.FormetFileSize(is.available()));
						
						fileList.add(map);
						// 将输入流里的内容写入到输出流中，目的是在程序上下文的upload文件夹中创建用户上传的文件
						// 流的输入输出 要借助于缓冲区，即使用字节数组,1024为缓冲区大小-->1024byte
						byte[] buf = new byte[1024];
						// length代表读取的字节数量
						int length = 0;
						while ((length = is.read(buf)) > 0) {
							os.write(buf, 0, length);
						}
					}
					
				}
				
				
				resultMap.put("filedList", filedList);
				resultMap.put("fileList", fileList);
				

			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (is != null)
						is.close();

					if (os != null)
						os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		
		return resultMap;
	}
}

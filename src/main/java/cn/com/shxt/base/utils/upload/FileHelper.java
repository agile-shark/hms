package cn.com.shxt.base.utils.upload;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public final class FileHelper {
	/**
	 * 获取文件真实名称
	 * @param fileName [传入的路径]
	 * @return String
	 */
	public static String getRealFileName(String fileName){
		 //索引到最后一个反斜杠   
        int start = fileName.lastIndexOf("\\");  
        String value ="";
        if(start>0){
        	  //截取 上传文件的 字符串名字，加1是 去掉反斜杠
        	value = fileName.substring(start+1);
        }else{
        	value = fileName;
        }
     
		return value;
	}
	/**
	 * 获取随机的文件名称
	 * @param fileName
	 * @return
	 */
	
	public static String generateFileName(String fileName) {
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String formatDate = format.format(new Date());

		int random = new Random().nextInt(10000);

		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);

		return formatDate + random + extension;
	}

	public static String FormetFileSize(long fileS) {// 转换文件大小
		DecimalFormat df = new DecimalFormat("#.00");
		String fileSizeString = "";
		if (fileS < 1024) {
			fileSizeString = df.format((double) fileS) + "B";
		} else if (fileS < 1048576) {
			fileSizeString = df.format((double) fileS / 1024) + "KB";
		} else if (fileS < 1073741824) {
			fileSizeString = df.format((double) fileS / 1048576) + "MB";
		} else {
			fileSizeString = df.format((double) fileS / 1073741824) + "GB";
		}
		return fileSizeString;
	}
}

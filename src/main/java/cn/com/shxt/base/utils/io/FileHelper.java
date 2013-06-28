package cn.com.shxt.base.utils.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 刘文铭
 * @日期 2012 2012-12-15 下午2:43:07
 * @描述
 * 
 */
public class FileHelper {
	/**
	 * 获取不包含后缀名的文件名，　如 file的路径为C:\\temp\\test.txt，则返回 "test";
	 * file的路径为C:\\temp\\test1，则返回"test1"; file的路径为C:\\temp\\.project，则返回 ""
	 * 
	 * @param file  　文件
	 * @return　不含后缀名的文件名
	 */
	public static String getShortFileName(File file) {
		String name = file.getName();
		int pos = name.lastIndexOf(".");
		return (pos < 0) ? name : (pos == 0) ? "" : name.substring(0, pos);
	}

	/**
	 * 获取不包含后缀名的文件名，　如 fileName = "C:\\temp\\test.txt"，则返回"test"; fileName =
	 * "C:\\temp\\test1"，则返回"test1"; fileName = "C:\\temp\\.project"，则返回 ""
	 * 
	 * @param fileName
	 *            　完整的文件名
	 * @return　不含后缀名的文件名
	 */
	public static String getShortFileName(String fileName) {
		return getShortFileName(new File(fileName));
	}

	/**
	 * 提取文件的后缀名
	 * @param file
	 *            文件
	 * @return 文件的后缀名， 如 fileName = "test.txt" 时， 将返回 "txt", 如果文件没有后缀名，则返回一个长度为
	 *         0 的字符串
	 */
	public static String getFileExtention(File file) {
		return getFileExtention(file.getName());
	}

	/**
	 * 根据文件名提取文件的后缀名
	 * @param fileName
	 *            文件名
	 * @return 文件的后缀名， 如 fileName = "test.txt" 时， 将返回 "txt", 如果文件没有后缀名，则返回一个长度为
	 *         0 的字符串
	 */
	public static String getFileExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return (pos == -1) ? "" : fileName.substring(pos + 1);
	}

	/**
	 * 获取新的文件名，先判断机器上是否已经存在指定文件，如果不存在，则返回原文件名，如果已经存在，则在原文件名后面加上"(i)",其中i是一个正整数
	 * 例如：fileName = "C:\\test.txt", 而C盘已经存在一个文件名为test.txt的文件，则返回
	 * C:\\test(1).txt，如果C盘同时还存在一个文件名为test(1).txt的文件，则返回C:\\test(2).txt,
	 * 依此类推，直到对应路径下不存在要返回的文件名为此，这个不存在的就是要返回的
	 * 
	 * @param fileName
	 *            　文件名
	 * @return
	 */
	public static String getNewFileName(String fileName) {
		String ext = getFileExtention(fileName); // 后缀名
		String name = ext.length() > 0 ? fileName.substring(0,
		        fileName.length() - ext.length() - 1) : fileName; // 不含后缀名的文件名
		Pattern pattern = Pattern.compile("(.*)\\((\\d+)\\)$");

		File file = new File(fileName);
		while (file.exists()) {
			Matcher matcher = pattern.matcher(name);
			if (matcher.matches()) {
				name = matcher.group(1) + "("
				        + (Integer.valueOf(matcher.group(2)) + 1) + ")";
			} else {
				name += "(1)";
			}
			file = new File(name + "." + ext);
		}
		return name + "." + ext;
	}

	/**
	 * 复制文件
	 * 
	 * @param sourceFile
	 *            源文件
	 * @param path
	 *            目标路径，如:c:\\media360\1.jpg
	 * @return 复制后的文件对象, 如果复制失败，则返回null
	 */
	public static File copyFile(File sourceFile, String path) {
		if (sourceFile == null || !sourceFile.exists()) { // 如果源文件不存在则直接返回 null
			return null;
		}
		FileInputStream input = null;
		FileOutputStream output = null;
		try {
			File file = new File(path);
			File parent = file.getParentFile();
			if (!parent.exists()) {
				parent.mkdirs();
			}
			input = new FileInputStream(sourceFile);
			output = new FileOutputStream(path);
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = input.read(b)) != -1) {
				output.write(b, 0, len);
			}
			return file;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (output != null) {
					output.flush();
					output.close();
				}
				if (input != null) {
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 读取文件内容后， 将文件内容作为字符串返回
	 * 
	 * @param file
	 *            要读取的文件
	 * @param charsetName
	 *            文件的字符编码, 可以为 null
	 * @return 文件内容，如果文件不存在， 或者在读取文件时发生异常，则返回一个空字符串
	 */
	public static String readFile(File file, String charsetName) {
		InputStreamReader isr = null;
		BufferedReader read = null;
		StringBuffer content = new StringBuffer();
		try {
			if (charsetName == null || charsetName.length() == 0) {
				isr = new InputStreamReader(new FileInputStream(file));
			} else {
				isr = new InputStreamReader(new FileInputStream(file),
				        charsetName);
			}
			read = new BufferedReader(isr);
			while (read.ready()) {
				content.append(read.readLine()).append("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (read != null) {
					read.close();
				}
				if (read != null) {
					isr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return content.toString();
	}

	/**
	 * 将字符串写入文件
	 * 
	 * @param file
	 *            文件
	 * @param content
	 *            字符串内容
	 * @param charsetName
	 *            字符集名称 , 可以为 null
	 * @return 写入成功返回true, 否则返回 false
	 */
	public static boolean writeFile(File file, String content,
	        String charsetName) {
		OutputStreamWriter writer = null;
		try {
			File parentFile = file.getParentFile();
			if (!parentFile.exists()) { // 如果目录不存在则创建目录
				parentFile.mkdirs();
			}
			if (!file.exists()) { // 如果文件不存在，则创建文件
				file.createNewFile();
			}

			if (charsetName == null || charsetName.length() == 0) {
				writer = new OutputStreamWriter(new FileOutputStream(file));
			} else {
				writer = new OutputStreamWriter(new FileOutputStream(file),
				        charsetName);
			}
			writer.write(content);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.flush();
					writer.close();
				} catch (Exception ignore) {
				}
			}
		}
		return false;
	}

	/**
	 * 删除文件，如果要删除的文件对象是文件夹，则先将其所有子文件(夹)删除，再删除此文件夹
	 * 
	 * @param file
	 *            要删除的文件对象
	 * @return 删除是否成功
	 * @author Carl He
	 * @createDate 2009-08-15
	 */
	public static boolean deleteFile(File file) {
		if (!file.exists()) { // 文件不存在
			return true;
		}

		boolean result = false;
		if (file.isFile()) {
			result = file.delete();
		} else {
			File[] children = file.listFiles();
			for (int i = 0; i < children.length; i++) { // 删除所有子文件和子文件夹
				result = deleteFile(children[i]);
				if (!result) {
					return false;
				}
			}

			result = file.delete(); // 删除当前文件夹
		}
		return result;
	}

	/**
	 * 移动文件，如果源文件不存在，则直接返回 false
	 * 
	 * @param sourceFilePath
	 *            源文件路径
	 * @param targetFilePath
	 *            目标文件路径
	 * @return 如果移动成功，则返回 true, 否则返回 false
	 */
	public static boolean moveFile(String sourceFilePath, String targetFilePath) {
		return moveFile(new File(sourceFilePath), new File(targetFilePath));
	}

	/**
	 * 移动文件，如果源文件不存在，则直接返回 false
	 * 
	 * @param sourceFile
	 *            源文件
	 * @param targetFile
	 *            目标文件
	 * @return 如果移动成功，则返回 true, 否则返回 false
	 */
	public static boolean moveFile(File sourceFile, File targetFile) {
		if (!sourceFile.exists())
			return false;

		File targetFileParent = targetFile.getParentFile();
		if (!targetFileParent.exists()) {
			targetFileParent.mkdirs();
		}
		return sourceFile.renameTo(targetFile);
	}

	/**
	 * 创建文件(以免发生 {@link java.io.FileNotFoundException} 异常 ), 当文件 pathname
	 * 已经存在时，则什么也不做
	 * 
	 * @param pathname
	 *            文件名
	 * @throws IOException
	 */
	public static void createFile(String pathname) throws IOException {
		File file = new File(pathname);
		if (!file.exists()) {
			File directory = file.getParentFile();
			if (!directory.exists())
				directory.mkdirs();
			file.createNewFile();
		}
	}
	
	/**
	 * 重新取文件名字
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
	/**
	 * 获取文件大小
	 * @param fileS
	 * @return
	 */
	public static String FormetFileSize(long fileS) {//转换文件大小
	       DecimalFormat df = new DecimalFormat("#.00");
	       System.out.println(fileS);
	       String fileSizeString = "";
	       if (fileS < 1024) {
	           fileSizeString = df.format((double) fileS) + "B";
	       } else if (fileS < 1048576) {
	           fileSizeString = df.format((double) fileS / 1024) + "KB";
	       } else if (fileS < 1073741824) {
	           fileSizeString = df.format((double) fileS / 1048576) + "MB";
	       } else {
	           fileSizeString = df.format((double) fileS / 1073741824) +"GB";
	       }
	       return fileSizeString;
	    }
}

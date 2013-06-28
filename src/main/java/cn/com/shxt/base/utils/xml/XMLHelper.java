package cn.com.shxt.base.utils.xml;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.com.shxt.base.utils.io.FileHelper;


public class XMLHelper {
	 public static String ENCODING_UTF8 = "UTF-8";
     /**
      * 保存Document对象到 XML 文件(采用UTF-8编码)
      * @param document Document对象
      * @param filePath XML文件的文件名
      * @throws IOException
      */
     public static void savaXML(Document document, String filePath) throws IOException {
             savaXML(document, filePath, ENCODING_UTF8);
     }
     
     /**
      * 保存Document对象到 XML 文件
      * @param document Document对象
      * @param filePath XML文件的文件名
      * @param encoding 文件编码
      * @throws IOException
      */
     public static void savaXML(Document document, String filePath, String encoding) throws IOException {
             FileHelper.createFile(filePath);
             
             OutputFormat format = OutputFormat.createPrettyPrint();
             format.setEncoding(encoding);
             
             XMLWriter writer = new XMLWriter(new FileOutputStream(filePath), format);
             writer.write(document);
             writer.close();
     }
     
     /**
      * 读取 XML 文件， 返回一个 org.dom4j.Document 对象
      * @param filePath XML 文件的路径
      * @return
      * @throws DocumentException
      * @throws IOException
      */
     public static Document readXml(String filePath) throws DocumentException, IOException{
             FileReader fr = new FileReader(filePath);
     Document  document = new SAXReader().read(fr);
     fr.close();
     return document;
     }
     
     /**
      * 读取输入流， 返回一个 org.dom4j.Document 对象， 并在读取完成后将输入流关闭
      * @param filePath XML 文件的路径
      * @return
      * @throws DocumentException 
      * @throws IOException 
      */
     public static Document readXml(InputStream in) throws DocumentException, IOException{
             Document  document = new SAXReader().read(in);
             in.close();
             return document;
     }

     public static void main(String[] args) {
             /*
             List<User> users = g.docAapter.getUserDAO().selectWithIdByExample(new UserExample());
             List<Department> departments = g.docAapter.getDeptDAO().selectByExample(new DepartmentExample());
             try {
                     g.savaXML(g.createUserInfoDoc(users), "C:\\TEMP\\userInfo.xml");
                     g.savaXML(g.createDepartmentsDoc(departments), "C:\\TEMP\\department.xml");
             } catch (IOException e) {
                     e.printStackTrace();
             }
             */
             
             try {
                     List<?> list = readXml("C:\\TEMP\\userInfo.xml").selectNodes("/userInfo/user[updateflg=\"1\"]");
                     Element e;
                     for (int i = 0; i < list.size(); i++) {
                             e = (Element) list.get(i);
                             System.out.println(e.asXML());
                     }
             } catch (DocumentException e) {
                     e.printStackTrace();
             } catch (IOException e) {
                     e.printStackTrace();
             }
     }
}


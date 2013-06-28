package cn.com.shxt.base.utils.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author 刘文铭
 * @日期 2012 2012-12-15 下午2:48:52
 * @描述
 * 负责读取工程中 .properties 文件中的配置信息
 *
 */
public class PropertiesConfigHelper {
	 private static final Logger logger = Logger.getLogger(PropertiesConfigHelper.class);
     private static final String PROTERTIES = ".proterties";
     private static final String XML = ".xml";
     private static final Properties configProps = new Properties();
     
    private static final String[] files = new String[] { "jdbc.properties" };

     //静态代码块
     static {
    	 load(files);
     }
     

     /**
      * * 加载properties文件 *
      * 
      * @param fileType
      *                文件类型: 0.普通的properties文件; 1.XML格式的properties文件 *
      * @param filePath
      *                properties文件路径
      */
     private static void load(String... filePath) {
 	
 	logger.debug("开始读取properties文件 开始时间"+System.currentTimeMillis());
 	
 	String configFilePath = null;
 	InputStream is = null;
 	for (int i = 0; i < filePath.length; i++) {
 	    configFilePath = filePath[i];
 	    try {
 		if (configFilePath.toLowerCase().endsWith(".xml")) {
 		    is = PropertiesConfigHelper.class.getClassLoader().getResourceAsStream(configFilePath);
 		    configProps.loadFromXML(is);
 		} else if (configFilePath.toLowerCase().endsWith(".properties")) {
 		    is = PropertiesConfigHelper.class.getClassLoader().getResourceAsStream(configFilePath);
 		    configProps.load(is);
 		} else {
 		    throw new RuntimeException("can't support the file: " + configFilePath);
 		}
 		logger.debug("文件 \"" + configFilePath + "\" 读取 成功! 时间为:"+System.currentTimeMillis());
 	    } catch (Exception e) {
 		logger.debug("文件 \"" + configFilePath + "\" 读取 失败, 失败异常信息:\\n"+ e.getMessage());
 		throw new RuntimeException("file \"" + configFilePath + "\" load failed", e);
 	    } finally {
 		if (is != null) {
 		    try {
 			is.close();
 		    } catch (IOException e) {
 			logger.debug("所有配置文件读取完毕,当关闭文件FileInputStream时，异常信息 :\\n"+ e.getMessage());
 		    }
 		}
 	    }
 	    
 	}
 	
     }

     public static Short getShortValue(String key) {
             return Short.parseShort(configProps.getProperty(key));
     }

     public static Short getShortValue(String key, Short defaultValue) {
             try {
                     return getShortValue(key, defaultValue);
             } catch (NumberFormatException e) {
                     return defaultValue;
             }
     }

     public static Integer getIntegerValue(String key) {
             return Integer.parseInt(configProps.getProperty(key));
     }

     /**
      * 获取 int 类型的配置属性的value
      * @param key 配置属性的key
      * @param defaultValue 默认值
      * @return 对应的配置属性value，如果配置属性的value不为int类型或不存在对应的配置属性，则返回 defaultValue
      */
     public static int getIntegerValue(String key, Integer defaultValue) {
             try {
                     return getIntegerValue(key, defaultValue);
             } catch (NumberFormatException e) {
                     return defaultValue;
             }
     }

     public static Float getFloatValue(String key) {
             return Float.parseFloat(configProps.getProperty(key));
     }

     /**
      * 获取 float 类型的配置属性的value
      * 
      * @param key 配置属性的key
      * @param defaultValue 默认值
      * @return 对应的配置属性value，如果配置属性的value不为float类型或不存在对应的配置属性，则返回 defaultValue
      */
     public static Float getFloatValue(String key, float defaultValue) {
             try {
                     return getFloatValue(key);
             } catch (NumberFormatException e) {
                     return defaultValue;
             }
     }

     public static Double getDoubleValue(String key) {
             return Double.parseDouble(configProps.getProperty(key));
     }

     /**
      * 获取 double 类型的配置属性的value
      * 
      * @param key 配置属性的key
      * @param defaultValue 默认值
      * @return 对应的配置属性value，如果配置属性的value不为double类型或不存在对应的配置属性，则返回 defaultValue
      */
     public static Double getDoubleValue(String key, double defaultValue) {
             try {
                     return getDoubleValue(key);
             } catch (NumberFormatException e) {
                     return defaultValue;
             }
     }

     public static Long getLongValue(String key) {
             return Long.parseLong(configProps.getProperty(key));
     }

     /**
      * 获取 long 类型的配置属性的value
      * 
      * @param key 配置属性的key
      * @param defaultValue 默认值
      * @return 对应的配置属性value，如果配置属性的value不为long类型或不存在对应的配置属性，则返回 defaultValue
      */
     public static Long getLongValue(String key, long defaultValue) {
             try {
                     return getLongValue(key);
             } catch (NumberFormatException e) {
                     return defaultValue;
             }
     }

     public static String getStringValue(String key) {
             return configProps.getProperty(key);
     }

     /**
      * 获取 String 类型的配置属性的value
      * 
      * @param key 配置属性的key
      * @param defaultValue 默认值
      * @return 对应的配置属性value，如果配置属性的value为""或不存在对应的配置属性，则返回 defaultValue
      */
     public static String getStringValue(String key, String defaultValue) {
             return configProps.getProperty(key, defaultValue);
     }

     public static Boolean getBooleanValue(String key) {
             String value = configProps.getProperty(key);
             return ("y".equalsIgnoreCase(value)) || ("on".equalsIgnoreCase(value)) || ("yes".equalsIgnoreCase(value))
                             || ("true".equalsIgnoreCase(value)) || (getIntegerValue(key, 0) != 0);
     }

     /**
      * 获取 boolean 类型的配置属性的value
      * 
      * @param key 配置属性的key
      * @param defaultValue 默认值
      * @return 如果在配置文件中没有定义此属性，则返回 defaultValue; <br>
      *         如果 value 为y、on、yes 、true 或非 0 数值(均不区分大小写) 则返回 true, 否则返回 false
      */
     public static boolean getBooleanValue(String key, Boolean defaultValue) {
             String value = configProps.getProperty(key);
             return (value == null) ? defaultValue : getBooleanValue(key);
     }
     
     
     
     public static void main(String[] args) {
  	   System.out.println(PropertiesConfigHelper.getStringValue("db.driver"));
      }
     
   

}

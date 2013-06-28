package cn.com.shxt.base.utils.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class CreateTabel {
	public static void main(String[] args) {
		//加载配置文件
		try {
			Configuration  cfg = new Configuration().configure();
			
			//工具类 方案导出
			SchemaExport  sExport = new SchemaExport(cfg);
			//第一个参数是表示是否显示脚本
			//第二参数是是否执行到数据库中
			sExport.create(true, true);
			
			System.out.println("<---------生成数据库表成功-------->");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

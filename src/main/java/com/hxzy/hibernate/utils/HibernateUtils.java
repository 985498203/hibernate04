package com.hxzy.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateUtils {
	private static final Configuration CFG;
	private static final SessionFactory SESSIONFACTORY;
	static {
		CFG = new Configuration();
		CFG.configure();// 加载核心配置文件
		SESSIONFACTORY = CFG.buildSessionFactory();
	}
	/**
	 * 创建Session工厂
	 * 
	 * @return
	 */
	public static SessionFactory getSessionFactory() {
		return SESSIONFACTORY;
	}

	public static void main(String[] args) {
		getSessionFactory();
	}

}

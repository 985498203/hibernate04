import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;

import com.hxzy.hibernate.entity.Student;
import com.hxzy.hibernate.utils.HibernateUtils;

public class Tests {
	static Logger logger = Logger.getLogger(Tests.class);

	static SessionFactory sessionFactory = null;
	static Session session = null;
	static Transaction tx = null;

	@Before
	public void Before() {
		logger.info("加载配置文件");
		sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
	}

	@After
	public void After() {
		logger.info("关闭资源");
		if (null != session) {
			session.close();
		}
	}

	@Test
	// 批量添加
	public void testAdd() {
		try {
			for (int i = 0; i < 2000; i++) {
				Student student = new Student();
				student.setName("小明" + i);
				session.save(student);
				if (i % 30 == 0) {// 每30条
					session.flush();// 将session的缓存中的数据与数据库同步。
					session.clear();// 清除session中的缓存数据（不管缓存与数据库的同步）
				}
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Test
	// 分页
	public void testFenYe() {
		Query query = session.createQuery("from Student");
		query.setFirstResult(0);// 起始索引
		query.setMaxResults(5);// 查询几条
		List<Student> studentList = query.list();
		for (Student student : studentList) {
			System.out.println(student);
		}
	}

	@Test
	public void testSelectById() {
		Object object = session.get(Student.class, 1);
		System.out.println("on:" + object);

	}
}

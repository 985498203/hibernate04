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

public class TestsLock {
//	static Logger logger = Logger.getLogger(TestsLock.class);
//
//	static SessionFactory sessionFactory = null;
//	static Session session = null;
//	static Transaction tx = null;
//
//	@Before
//	public void Before() {
//		logger.info("加载配置文件");
//		sessionFactory = HibernateUtils.getSessionFactory();
//		session = sessionFactory.openSession();
//		tx = session.beginTransaction();
//	}
//
//	@After
//	public void After() {
//		logger.info("关闭资源");
//		if (null != session) {
//			session.close();
//		}
//	}
	
	@Test
	public void testLock() {
		try {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			
			Session session = sessionFactory.openSession();
			Session session2 = sessionFactory.openSession();
			
			session.beginTransaction();
			session2.beginTransaction();
			
			Student student = (Student) session.load(Student.class, 1);
			Student student2 = (Student) session2.load(Student.class, 1);
			
			
			student.setName("小明");
			System.out.println(student);
//			System.out.println(student.getTimestamp()+"-----"+student2.getTimestamp());
			session.getTransaction().commit();
			
			
			student2.setName("小芳");
			System.out.println(student2);
//			System.out.println(student.getTimestamp()+"-----"+student2.getTimestamp());
			session2.getTransaction().commit();
			
			
		} catch (Exception e) {
			System.out.println("异常");
			e.printStackTrace();
		}
	}
//	@Test
//	public void testAdd() {
//		try {
//			
//		Student student = new Student();
//		student.setName("小明");
//		session.save(student);
//				
//		
//			tx.commit();
//		} catch (Exception e) {
//			tx.rollback();
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	// 分页
//	public void testFenYe() {
//		Query query = session.createQuery("from Student");
//		query.setFirstResult(0);// 起始索引
//		query.setMaxResults(5);// 查询几条
//		List<Student> studentList = query.list();
//		for (Student student : studentList) {
//			System.out.println(student);
//		}
//	}
//
//	@Test
//	public void testSelectById() {
//		Object object = session.get(Student.class, 1);
//		System.out.println("on:" + object);
//
//	}
}

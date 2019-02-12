package utils;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {
	
	private static SqlSessionFactory factory = null;
	
	
	static {
		InputStream inputStream = null;
		
		
		try {
			inputStream = Resources.getResourceAsStream("mybatis/sqlMapConfig.xml");
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			factory = builder.build(inputStream);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (inputStream != null) {
				try {
					inputStream.close();
					inputStream = null;
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static  SqlSession getSqlSession() {
		return factory.openSession(); 
		}
	public static  SqlSession getSqlSession(boolean  autoCommit) { return factory.openSession(autoCommit); }
	public static void closeSqlSession(boolean autoCommit , SqlSession session) {
		if (autoCommit) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
	}
	
	
}

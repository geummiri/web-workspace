package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template2 {
		
	public static SqlSession getSqlSession() {
		
		SqlSession session = null;
		
		String resource = "/mybatis-config.xml";
		
		try {
			InputStream stream = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			
			SqlSessionFactory factory = builder.build(stream); 
			
			session = factory.openSession(false);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return session;
	}
}

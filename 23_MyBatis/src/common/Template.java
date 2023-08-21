package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	public static SqlSession getSqlSession() {
		
		SqlSession session = null;
		
		//config에 mapper를 담아놨기 때문에 config만 해주면 됨
		
		String resource = "/mybatis-config.xml";
		
		// 1. mybatis-config.xml의 설정 정보를 InputStream 객체를 통해 읽어온다.
		try {
			InputStream stream = Resources.getResourceAsStream(resource);
			
			// 2. SqlSessionFactoryBuilder 객체를 생성하고 build() 메소드를 통해
			// SqlSessionFactory 객체를 생성
			
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(stream);
			
			// 3. SqlSessionFactory 객체의 openSession() 메소드를 통해 SqlSession 객체 생성
			session = factory.openSession(false);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return session;
	
}
}

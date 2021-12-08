package co.micol.prj.comm;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {	// Mybatis를 활용하는 DataSource 객체
	
	private static SqlSessionFactory sqlSessionFactory;
	private DataSource() {}		// 외부에서 객체 생성 할 수 없도록 private 생성자를 만듬
	
	public static SqlSessionFactory getInstance() {
		
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sqlSessionFactory;
	}
	
}

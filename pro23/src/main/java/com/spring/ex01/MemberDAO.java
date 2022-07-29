package com.spring.ex01;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
// DB접속 정보 및 매퍼들에 대한 위치가 지정된 마이바티스의 설정파일을 읽어보기
public class MemberDAO {
	public static SqlSessionFactory sqlMapper = null;
	
	// SqlSessionFactory
	//	데이터베이스와의 연결과 SQL실행에 대한 모든것을 가진 객체
	//  이 객체가 DataSource를 참조하여 DB서버와 연동시켜준다.
	
	private static SqlSessionFactory getInstance() {
		if (sqlMapper == null) {
			try {
				//1. SQLMapConfig.xml을 읽어들인다.
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				//2. SqlSessionFactory를 리턴받는다.
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
				
				//3. SqlSession을 리턴받는다.
				/*SqlSession session = factory.openSession();
				
				//4. session에 쿼리문을 실행하는 모든 기능이 다 들어있다...
				 //insert(), delete(), update(), selectList()-다 가져올 때, selectOne()-하나만 가져올 때
					session.insert("mysawonMapper.sawonAdd", vo);
									("네임스페이스.추가함수")
				 session.commit(); //DML(추가/수정/삭제)일 때 반드시 해줄 것.
				 session.close(); //spring DI Framework일 때는 들어가 있다..*/
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;

	}

	public List<MemberVO> selectAllMemberList() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<MemberVO> memlist = null;
		memlist = session.selectList("mapper.member.selectAllMemberList");
		return memlist;
	}
}

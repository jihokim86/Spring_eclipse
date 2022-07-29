package com.mysprint.pro30a.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mysprint.pro30a.member.vo.MemberVO;


@Repository("memberDAO")

public class MemberDAOimpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllMemberList() throws DataAccessException {
		List membersList = sqlSession.selectList("mapper.member.selectAllMemberList");
		return membersList;
	}
	/*
	 * sqlSession클래스의 메소드기능
	 * List selectList(query_id)	id에 대한 select 문을 실행한 후 여러 레코드를 List로 반환
	 * List selectList(query_id, 조건)	id에 대한 select 문을 실행하면서 사용되는 조건도 전달
	 * T selectOne(query_id)	id에 대한 select 문을 실행한 후 지정된 타입으로 한 개의 레코드 반환
	 * T selectOne(query_id, 조건)	id에 대한 select 문을 실행하면서 사용되는 조건도 전달
	 * Map<K,V> selectMap(query_id, 조건)	id에 대한 select 문을 실행하면서 사용되는 조건도 전달. Map 타입으로 레코드 반환
	 * int insert(query_id, Object obj)	id에 대한 insert문을 실행하면서 객체의 값을 테이블에 추가
	 * int update(query_id, Object obj)	obj 객체의 값을 조건문의 수정 값으로 사용해 id데 대한 update문 실행
	 * int delete(query_id, Object obj)	obj 객체의 값을 조건문의 조건 값으로 사용해 id데 대한 delete문 실행
	 */
	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
		return result;
	}

	@Override
	public int deleteMember(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.member.deleteMember", id);
		return result;
	}

	@Override
	public MemberVO loginById(MemberVO memberVO) throws DataAccessException {
		MemberVO vo = sqlSession.selectOne("mapper.member.loginById",memberVO);
		return vo;
	}

	@Override
	public int updateMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.delete("mapper.member.updateMember", memberVO);
		return result;
	}
	
	
	
	
	
}

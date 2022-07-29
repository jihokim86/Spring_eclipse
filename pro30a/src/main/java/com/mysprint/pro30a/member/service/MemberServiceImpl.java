package com.mysprint.pro30a.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.mysprint.pro30a.member.dao.MemberDAO;
import com.mysprint.pro30a.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	
	 @Autowired 
	 private MemberDAO memberDAO;
	 
	@Override
	public List listMembers() throws DataAccessException {
		List membersList  = memberDAO.selectAllMemberList();
		return membersList ;
	}

	@Override
	public int addMember(MemberVO memberVO) throws DataAccessException {
		int result = memberDAO.insertMember(memberVO);
		return result;
	}

	@Override
	public int removeMember(String id) throws DataAccessException {
		return memberDAO.deleteMember(id);
	}

	@Override
	public MemberVO login(MemberVO memberVO) throws DataAccessException {
		return memberDAO.loginById(memberVO);
	}

	@Override
	public int modMember(MemberVO memberVO) throws DataAccessException {
		return memberDAO.updateMember(memberVO);
	}
	
}

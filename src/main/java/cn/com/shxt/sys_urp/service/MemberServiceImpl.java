package cn.com.shxt.sys_urp.service;

import cn.com.shxt.sys_urp.dao.IMemberDao;

public class MemberServiceImpl implements IMemberService {

	private IMemberDao memberDao;

	public IMemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(IMemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	
}

package cn.com.shxt.sys_urp.action;

import org.apache.log4j.Logger;

import cn.com.shxt.base.action.BaseAction;
import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.sys_urp.domain.Member;
import cn.com.shxt.sys_urp.service.IMemberService;

public class MemberAction extends BaseAction {

	private Logger logger = Logger.getLogger(AccountAction.class);
	
	private IMemberService memberService;
	
	/**使用模型驱动--生成setter getter方法*/
	private Member member;
	
	/**使用模型驱动获取PageBean对象*/
	private PageBean pb;

	public IMemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(IMemberService memberService) {
		this.memberService = memberService;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public PageBean getPb() {
		return pb;
	}

	public void setPb(PageBean pb) {
		this.pb = pb;
	}
	
	
	
}

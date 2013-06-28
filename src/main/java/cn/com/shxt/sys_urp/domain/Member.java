package cn.com.shxt.sys_urp.domain;

import java.io.Serializable;

public class Member implements Serializable {

	/**主键*/
	private int m_id;
	/**房客身份证号*/
	private String rrIdcard;
	/**电话*/
	private String mPhone;
	/**会员类型*/
	private String mType;
	/**备注*/
	private String mRemark;
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getRrIdcard() {
		return rrIdcard;
	}
	public void setRrIdcard(String rrIdcard) {
		this.rrIdcard = rrIdcard;
	}
	public String getmPhone() {
		return mPhone;
	}
	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}
	public String getmType() {
		return mType;
	}
	public void setmType(String mType) {
		this.mType = mType;
	}
	public String getmRemark() {
		return mRemark;
	}
	public void setmRemark(String mRemark) {
		this.mRemark = mRemark;
	}
	@Override
	public String toString() {
		return "Member [m_id=" + m_id + ", rrIdcard=" + rrIdcard + ", mPhone="
				+ mPhone + ", mType=" + mType + ", mRemark=" + mRemark + "]";
	}
	
	
}
